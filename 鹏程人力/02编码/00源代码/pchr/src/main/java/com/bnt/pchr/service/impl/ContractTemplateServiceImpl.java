package com.bnt.pchr.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bnt.pchr.commons.util.DES;
import com.bnt.pchr.commons.vo.PageData;
import com.bnt.pchr.commons.vo.ResponseData;
import com.bnt.pchr.vo.ContractTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.bnt.pchr.entity.ContractTemplate;
import com.bnt.pchr.mapper.ContractTemplateMapper;
import com.bnt.pchr.service.IContractTemplateService;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Map;


@Service("resumeTemplateService")
public class ContractTemplateServiceImpl implements IContractTemplateService {

    /**
     * 上传文件基本路径
     */
    @Value("${config.contract.template.upload-dir}")
    private String uploadDirPath;

    /**
     * 简历服务器上下文路径
     */
    @Value("${config.contract.template.server-path}")
    private String tempServerPath;

    @Autowired
    @Qualifier("contractTemplateMapper")
    private ContractTemplateMapper contractTemplateMapper;


    @Override
    public PageData<ContractTemplate> selectPage(PageData<ContractTemplate> pageData) {
        Map<String, Object> criteriaMap = pageData.getCriteriaMap();
        QueryWrapper<ContractTemplate> qw = new QueryWrapper<>();
        Integer tempType = (Integer) criteriaMap.get("tempType");
        if (tempType != null && 0 != tempType) {
            qw.eq("temp_type", tempType);
        }
        Integer tempState = (Integer) criteriaMap.get("tempState");
        if (tempState != null && 0 != tempState) {
            qw.eq("temp_state", tempState);
        }
        long total = contractTemplateMapper.selectCount(qw);
        pageData.setTotal(total);
        pageData = contractTemplateMapper.selectPage(pageData, qw);
        return pageData;
    }

    @Override
    public ContractTemplate selectById(Integer tempId) {
        return contractTemplateMapper.selectById(tempId);
    }

    @Override
    public int deleteById(Integer tempId) {
        return contractTemplateMapper.deleteById(tempId);
    }

    @Override
    public ResponseData insert(ContractTemplate template) {
        String tempName = template.getTempName();
        if (StrUtil.isEmpty(tempName)) {
            return ResponseData.FAIL(900400, "未填写合同模板名称");
        }
        Integer tempType = template.getTempType();
        if (tempType == null) {
            return ResponseData.FAIL(900400, "未设置合同模板类型!");
        }
        if (!(tempType == 1 || tempType == 2 || tempType == 3 || tempType == 4)) {
            return ResponseData.FAIL(120002, "合同模板类型错误!");
        }
        Integer tempState = template.getTempState();
        if (tempState == null) {
            return ResponseData.FAIL(900400, "未设置合同模板状态!");
        }
        if (!(tempState == 1 || tempState == 2 || tempState == 3)) {
            return ResponseData.FAIL(120004, "合同模板状态错误!");
        }
        template.setCreateTime(new Date());
        int rows = contractTemplateMapper.insert(template);
        return ResponseData.SUCCESS(rows);
    }

    @Override
    public ResponseData updateById(ContractTemplate template) {
        Integer tempType = template.getTempType();
        if (tempType != null && !(tempType == 1 || tempType == 2 || tempType == 3 || tempType == 4)) {
            return ResponseData.FAIL(120002, "合同模板类型错误!");
        }
        Integer tempState = template.getTempState();
        if (tempState != null && !(tempState == 1 || tempState == 2 || tempState == 3)) {
            return ResponseData.FAIL(120004, "合同模板状态错误!");
        }
        template.setModifyTime(new Date());
        int rows = contractTemplateMapper.updateById(template);
        return ResponseData.SUCCESS(rows);
    }

    @Override
    public ResponseData uploadTemplateFile(String tempName, MultipartFile[] tempFiles) throws Exception {
        if (StrUtil.isEmpty(tempName)) {
            return ResponseData.FAIL(900400, "缺少参数");
        }
        if (tempFiles.length > 1) {
            return ResponseData.FAIL(100401, "目前系统仅支持上传单个合同模板文件");
        }
        MultipartFile tempFile = tempFiles[0];
        if (tempFile.isEmpty()) {
            return ResponseData.FAIL(100400, "未上传任何合同模板文件");
        }
        String originalFilename = tempFile.getOriginalFilename();
        String extName = FileUtil.getSuffix(originalFilename).toLowerCase();
        if (!"pdf".equals(extName)) {
            return ResponseData.FAIL(100402, "合同模板文件格式错误,只可以上传*.pdf格式文件");
        }
        String relativeDirPath = File.separator + DateUtil.format(new Date(), "yyyyDDD");
        File uploadDir = new File(uploadDirPath, relativeDirPath);
        FileUtil.mkdir(uploadDir);
        //文件名(不含扩展名)
        String prefix = FileUtil.getPrefix(originalFilename);
        String fileName = URLEncoder.encode(prefix, "UTF-8") + '.' + extName;
        File uploadFile = new File(uploadDir, fileName);
        if (!uploadFile.isFile())
            uploadFile.createNewFile();
        tempFile.transferTo(uploadFile);
        String tempRelativeURL = relativeDirPath.replace("\\", "/") + '/' + fileName;
        String key = DES.KEY;
        String tempFilePath = DES.encode(key, tempRelativeURL);//加密
        //将%->%25
        tempRelativeURL = tempRelativeURL.replace("%","%25");
        String tempURL = tempServerPath + tempRelativeURL;
        ContractTemplateVO template = new ContractTemplateVO();
        template.setTempURL(tempURL);
        template.setTempFilePath(tempFilePath);
        template.setTempName(tempName);
        return ResponseData.SUCCESS(template);
    }

    @Override
    public ResponseData getTemplateURL(int tempId) {
        ContractTemplate template = contractTemplateMapper.selectById(tempId);
        if (template == null) {
            return ResponseData.FAIL(100404, "合同模板不存在或已被删除");
        }
        String tempFilePath = template.getTempFilePath();
        String key = DES.KEY;
        tempFilePath = DES.decode(key, tempFilePath);//解密
        //将%->%25
        tempFilePath = tempFilePath.replace("%","%25");
        String tempURL = tempServerPath + tempFilePath;
        return ResponseData.SUCCESS(tempURL);
    }
}