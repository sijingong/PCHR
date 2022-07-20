package com.bnt.pchr.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

import com.bnt.pchr.commons.vo.PageData;
import com.bnt.pchr.commons.vo.ResponseData;
import com.bnt.pchr.entity.ContractTemplate;
import org.springframework.web.multipart.MultipartFile;


/**
 * Author bnt
 * Date   2022-07-13 16:05:23
 */
public interface IContractTemplateService {
    /**
     * 分页查询合同模板
     *
     * @param pageData
     * @return
     */
    PageData<ContractTemplate> selectPage(PageData<ContractTemplate> pageData);

    /**
     * 根据ID查询返回一个合同模板对象
     *
     * @param tempId
     * @return
     */
    ContractTemplate selectById(Integer tempId);

    /**
     * 根据ID删除
     *
     * @param tempId
     * @return
     */
    int deleteById(Integer tempId);


    /**
     * 添加
     *
     * @param  template
     * @return
     */
    ResponseData insert(ContractTemplate template);

    /**
     * 修改简历模板
     * @param template
     * @return
     */
    ResponseData updateById(ContractTemplate template);

    /**
     * 上传合同模板
     * @param  tempName 合同模板名称
     * @param tempFiles 合同模板文件数组
     * @return
     */
    ResponseData uploadTemplateFile(String tempName, MultipartFile[] tempFiles) throws Exception;


    /**
     * 获取合同模板URL
     * @param tempId 合同模板ID
     * @return
     */
    ResponseData getTemplateURL(int tempId);
}