package com.bnt.pchr.controller;
import com.bnt.pchr.commons.vo.ResponseData;
import com.bnt.pchr.entity.Department;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.bnt.pchr.service.IDepartmentService;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@RequestMapping("api/dep")
@Controller
@Api(value = "部门控制器")
public class DepartmentController  {

    @Autowired
    @Qualifier("departmentService")
    private IDepartmentService departmentService;

    @PostMapping("select_list")
    @ResponseBody
    public ResponseData selectList(){
        List<Department> depList = departmentService.selectList();
        return ResponseData.SUCCESS(depList);
    }

    @PostMapping("dep_info")
    public ModelAndView depInfo(Integer depId,ModelAndView modelAndView){
        Department dep = departmentService.selectOne(depId);
        modelAndView.addObject("dep",dep);
        modelAndView.setViewName("dep/dep_info");
        return modelAndView;
    }

    @PostMapping("create_dep")
    @ResponseBody
    public ResponseData createDep(Department dep){
        int check = departmentService.check(dep.getDepNo());
        if(check>0){
            return ResponseData.FAIL(-1,"该员工已存在");
        }
        int rows = departmentService.insert(dep);
        return ResponseData.SUCCESS(rows);
    }

    @PostMapping("update_dep")
    @ResponseBody
    public ResponseData updateDep(Department dep){
        int check = departmentService.check(dep.getDepNo());
        if(check>0){
            return ResponseData.FAIL(-1,"该员工已存在");
        }
        int rows = departmentService.updateById(dep);
        return ResponseData.SUCCESS(rows);
    }

    @PostMapping("delete_dep")
    @ResponseBody
    public ResponseData deleteDep(Integer depId){
        int rows = departmentService.deleteById(depId);
        return ResponseData.SUCCESS(rows);
    }
}