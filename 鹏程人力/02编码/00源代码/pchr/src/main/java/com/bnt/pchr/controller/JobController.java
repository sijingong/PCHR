package com.bnt.pchr.controller;
import com.bnt.pchr.commons.vo.ResponseData;
import com.bnt.pchr.entity.Job;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.bnt.pchr.service.IJobService;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@RequestMapping("api/job")
@Controller
@Api(value = "职位控制器")
public class JobController {

    @Autowired
    @Qualifier("jobService")
    private IJobService jobService;

    @PostMapping("select_list")
    @ResponseBody
    public ResponseData selectList(){
        List<Job> jobList = jobService.selectList();
        return ResponseData.SUCCESS(jobList);
    }

    @PostMapping("job_info")
    public ModelAndView jobInfo(Integer jobId,ModelAndView modelAndView){
        Job job = jobService.selectOne(jobId);
        modelAndView.addObject("job",job);
        modelAndView.setViewName("job/job_info");
        return modelAndView;
    }

    @PostMapping("create_job")
    @ResponseBody
    public ResponseData createJob(Job job){
        int check = jobService.check(job.getJobNo());
        if(check>0){
            return ResponseData.FAIL(-1,"该职位已存在");
        }
        int rows = jobService.insert(job);
        return ResponseData.SUCCESS(rows);
    }

    @PostMapping("update_job")
    @ResponseBody
    public ResponseData updateJob(Job job){
        int check = jobService.check(job.getJobNo());
        if(check>0){
            return ResponseData.FAIL(-1,"该职位已存在");
        }
        int rows = jobService.updateById(job);
        return ResponseData.SUCCESS(rows);
    }

    @PostMapping("delete_job")
    @ResponseBody
    public ResponseData deleteJob(Integer jobId){
        int rows = jobService.deleteById(jobId);
        return ResponseData.SUCCESS(rows);
    }
}