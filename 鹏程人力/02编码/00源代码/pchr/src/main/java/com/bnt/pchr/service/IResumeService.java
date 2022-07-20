package com.bnt.pchr.service;

import com.bnt.pchr.commons.vo.ResponseData;
import com.bnt.pchr.entity.Resume;
import org.springframework.web.multipart.MultipartFile;


/**
 * Author bnt
 * Date   2022-07-13 16:05:23
 */
public interface IResumeService {


    /**
     * 添加
     *
     * @param resume
     * @return
     */
    ResponseData insert(Resume resume);

    /**
     * 根据ID删除简历
     * @param resumeId
     * @return
     */
    int deleteById(int resumeId);

    /**
     * 上传简历
     *
     * @param empId       员工ID
     * @param resumeFiles 简历文件数组
     * @return
     */
    ResponseData uploadResumeFile(int empId, MultipartFile[] resumeFiles) throws Exception;

    /**
     * 获取员工简历URL
     *
     * @param empId
     * @return
     */
    ResponseData getResumeURL(int empId);
}