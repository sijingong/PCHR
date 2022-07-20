package com.bnt.pchr.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bnt.pchr.commons.util.DES;
import com.bnt.pchr.commons.util.FileUtils;
import com.bnt.pchr.commons.vo.ResponseData;
import com.bnt.pchr.entity.Emp;
import com.bnt.pchr.mapper.EmpMapper;
import com.bnt.pchr.vo.ResumeVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.bnt.pchr.entity.Resume;
import com.bnt.pchr.mapper.ResumeMapper;
import com.bnt.pchr.service.IResumeService;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;

@Log4j2
@Service("resumeService")
public class ResumeServiceImpl implements IResumeService {
    /**
     * 上传文件基本路径
     */
    @Value("${config.resume.upload-dir}")
    private String uploadDirPath;
    /**
     * 简历服务器上下文路径
     */
    @Value("${config.resume.server-path}")
    private String resumeServerPath;
    @Autowired
    @Qualifier("resumeMapper")
    private ResumeMapper resumeMapper;

    @Autowired
    @Qualifier("empMapper")
    private EmpMapper empMapper;


    @Override
    public ResponseData insert(Resume resume) {
        Integer empId = resume.getEmpId();
        String resumeFilePath = resume.getResumeFilePath();
        Integer fileType = resume.getFileType();
        if (resume.getEmpId() == null || StrUtil.isEmpty(resumeFilePath) || fileType == null) {
            return ResponseData.FAIL(900400, "缺少参数");
        }
        if (!(1 == fileType || 2 == fileType)) {
            return ResponseData.FAIL(110001, "简历格式错误");
        }
        QueryWrapper<Resume> qw = new QueryWrapper<>();
        qw.eq("emp_id", empId);
        long count = resumeMapper.selectCount(qw);
        if (count >= 1) {
            return ResponseData.FAIL(110002, "该员工简历已删除,请删除后,重新上传");
        }
        resume.setUploadTime(new Date());
        int rows = resumeMapper.insert(resume);
        return ResponseData.SUCCESS(rows);
    }

    @Override
    public ResponseData uploadResumeFile(int empId, MultipartFile[] resumeFiles) throws Exception {
        Emp emp = empMapper.selectById(empId);
        if (emp == null) {
            return ResponseData.FAIL(100403, "未查询到当前上传简历的员工信息");
        }
        if (resumeFiles.length > 1) {
            return ResponseData.FAIL(100401, "目前系统仅支持单个简历文件上传");
        }
        MultipartFile resumeFile = resumeFiles[0];
        if (resumeFile.isEmpty()) {
            return ResponseData.FAIL(100400, "未上传任何简历文件");
        }
        //原始简历文件名称
        String originalFilename = resumeFile.getOriginalFilename();
        if (!FileUtils.isResumeFile(originalFilename)) {
            return ResponseData.FAIL(100402, "简历文件格式错误,只可以上传*.pdf或*.doc格式文件");
        }

        //简历相对路径:/用户ID/yyyyDDD(四位年份+三位年中的天)
        String relativeDirPath = File.separator + empId + File.separator + DateUtil.format(new Date(), "yyyyDDD");
        File uploadDir = new File(uploadDirPath, relativeDirPath);
        FileUtil.mkdir(uploadDir);
        //上传后简历文件的名字.格式:V_+UUID+简历文件扩展名
        String fileName = FileUtils.getUploadFileName('R', originalFilename);
        File uploadFile = new File(uploadDir, fileName);
        if (!uploadFile.isFile())
            uploadFile.createNewFile();
        resumeFile.transferTo(uploadFile);
        //简历文件服务器本地相对URL
        String resumeRelativeURL = relativeDirPath.replace("\\", "/") + '/' + fileName;
        String key = DES.KEY + empId;
        ///简历文件服务器本地项目路径
        String resumeFilePath = DES.encode(key, resumeRelativeURL);//加密
        String extName = originalFilename.substring(originalFilename.lastIndexOf('.')).toLowerCase();
        int fileType = 1;
        if (".pdf".equals(extName)) {
            fileType = 2;
        }
        //简历URL
        String resumeURL = resumeServerPath + resumeRelativeURL;
        //简历名称
        String resumeName = emp.getEmpName() + "个人简历" + extName;
        ResumeVO resumeVO = new ResumeVO();
        resumeVO.setResumeFilePath(resumeFilePath);
        resumeVO.setFileType(fileType);
        resumeVO.setResumeName(resumeName);
        resumeVO.setResumeURL(resumeURL);
        return ResponseData.SUCCESS(resumeVO);
    }

    @Override
    public ResponseData getResumeURL(int empId) {
        Emp emp = empMapper.selectById(empId);
        if (emp == null) {
            return ResponseData.FAIL(100404, "简历所属员工不存在或已被删除");
        }
        QueryWrapper<Resume> qw=new QueryWrapper<>();
        qw.eq("emp_id",empId);
        Resume resume=resumeMapper.selectOne(qw);
        if(resume==null)
        {
            return ResponseData.FAIL(100405, "未查询到员工简历信息");
        }
        String resumeFilePath=resume.getResumeFilePath();
        String key = DES.KEY + empId;
        resumeFilePath = DES.decode(key, resumeFilePath);//解密
        //简历URL
        String resumeURL = resumeServerPath + resumeFilePath;
        return ResponseData.SUCCESS(resumeURL);
    }

    @Override
    public int deleteById(int resumeId) {
        return resumeMapper.deleteById(resumeId);
    }
}