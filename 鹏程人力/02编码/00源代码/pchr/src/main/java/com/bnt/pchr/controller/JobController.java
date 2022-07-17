package com.bnt.pchr.controller;
import com.bnt.pchr.commons.vo.ResponseData;
import com.bnt.pchr.entity.Department;
import com.bnt.pchr.entity.Job;
import com.bnt.pchr.service.IDepartmentService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.bnt.pchr.service.IJobService;

import java.util.List;

@Slf4j
@RequestMapping("job")
@Controller
@Api(value = "职位控制器")
public class JobController {

    @Autowired
    @Qualifier("jobService")
    private IJobService jobService;

    @Autowired
    @Qualifier("departmentService")
    private IDepartmentService departmentService;

    @PostMapping("select_list")
    @ResponseBody
    public ResponseData selectList(Integer depState){
        List<Job> jobList = jobService.selectList(depState);
        for(Job job:jobList){
            if(job.getDepId()!=null){
                Department dep = departmentService.selectOne(job.getDepId());
                job.setDep(dep);
            }
        }
        return ResponseData.SUCCESS(jobList);
    }

    @PostMapping("select_one")
    @ResponseBody
    public ResponseData selectOne(Integer jobId){
        Job job = jobService.selectOne(jobId);
        return ResponseData.SUCCESS(job);
    }

    @PostMapping("to_select")
    public String toSelect(Integer jobState,Model model){
        List<Job> jobList = jobService.selectList(jobState);
        for(Job job:jobList){
            if(job.getDepId()!=null){
                Department dep = departmentService.selectOne(job.getDepId());
                job.setDep(dep);
            }
        }
        model.addAttribute("jobList",jobList);
        return "job/job_list";
    }

    @PostMapping("create_job")
    @ResponseBody
    public ResponseData createJob(Job job,Integer userId){
        int check = jobService.check(job.getJobNo(),job.getJobId());
        if(check>0){
            return ResponseData.FAIL(-1,"该职位已存在");
        }
        int rows = jobService.insert(job);
        job.setCreateEmpId(userId);
        return ResponseData.SUCCESS(rows);
    }

    @PostMapping("update_job")
    @ResponseBody
    public ResponseData updateJob(Job job,Integer userId){
        int check = jobService.check(job.getJobNo(),job.getJobId());
        if(check!=0){
            return ResponseData.FAIL(-1,"该职位已存在");
        }
        int rows = jobService.updateById(job);
        job.setModifyEmpId(userId);
        return ResponseData.SUCCESS(rows);
    }

    @PostMapping("delete_job")
    @ResponseBody
    public ResponseData deleteJob(Integer jobId){
        int rows = jobService.deleteById(jobId);
        return ResponseData.SUCCESS(rows);
    }
}