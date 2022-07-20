package com.bnt.pchr.controller;

import com.bnt.pchr.commons.vo.ResponseData;
import com.bnt.pchr.entity.Resume;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.bnt.pchr.service.IResumeService;
import org.springframework.web.multipart.MultipartFile;

@Log4j2
@RequestMapping("resume")
@Controller
@Api(value = "控制器")
public class ResumeController {


    @Autowired
    @Qualifier("resumeService")
    private IResumeService resumeService;


    /**
     * 上传简历文件
     *
     * @param empId       员工ID
     * @param resumeFiles 上传简历文件数组
     * @param
     * @return
     */
    @PostMapping("upload")
    @ResponseBody
    public ResponseData uploadResumeFile(@RequestParam("emp_id") int empId, @RequestParam("resume_files") MultipartFile[] resumeFiles) throws Exception {
        return resumeService.uploadResumeFile(empId, resumeFiles);
    }

    /**
     * 创建员工简历
     *
     * @param resume
     * @return
     */
    @PostMapping("create")
    @ResponseBody
    public ResponseData createResume(Resume resume) {
        return resumeService.insert(resume);
    }

    /**
     * 获取员工简历URL
     *
     * @param empId 员工ID
     * @return
     */
    @GetMapping("get_url")
    @ResponseBody
    public ResponseData getResumeURL(int empId) {
        return resumeService.getResumeURL(empId);
    }

    /**
     * 删除简历
     *
     * @param resumeId 简历ID
     * @return
     */
    @GetMapping("remove")
    @ResponseBody
    public ResponseData removeResume(@RequestParam("resume_id") int resumeId) {
        int rows = resumeService.deleteById(resumeId);
        return ResponseData.SUCCESS(rows);
    }
}