package com.bnt.pchr.controller;
import com.bnt.pchr.commons.vo.ResponseData;
import com.bnt.pchr.entity.Department;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.bnt.pchr.service.IDepartmentService;

import java.util.List;

@Slf4j
@RequestMapping("dep")
@Controller
@Api(value = "部门控制器")
public class DepartmentController  {

    @Autowired
    @Qualifier("departmentService")
    private IDepartmentService departmentService;

    @PostMapping("select_list")
    @ResponseBody
    public ResponseData selectList(Integer depState){
        List<Department> depList = departmentService.selectList(depState);
        return ResponseData.SUCCESS(depList);
    }

    @PostMapping("to_select")
    public String toSelect(Integer depState,Model model){
        List<Department> depList = departmentService.selectList(depState);
        model.addAttribute("depList",depList);
        return "dep/dep_list";
    }

    @PostMapping("select_one")
    @ResponseBody
    public ResponseData selectOne(Integer depId){
        Department dep = departmentService.selectOne(depId);
        return ResponseData.SUCCESS(dep);
    }

    @PostMapping("create_dep")
    @ResponseBody
    public ResponseData createDep(Department dep,Integer userId){
        int check = departmentService.check(dep.getDepNo(),dep.getDepId());
        if(check>0){
            return ResponseData.FAIL(-1,"该员工已存在");
        }
        int rows = departmentService.insert(dep);
        dep.setCreateUserId(userId);
        return ResponseData.SUCCESS(rows);
    }

    @PostMapping("update_dep")
    @ResponseBody
    public ResponseData updateDep(Department dep,Integer userId){
        int check = departmentService.check(dep.getDepNo(),dep.getDepId());
        if(check>0){
            return ResponseData.FAIL(-1,"该员工已存在");
        }
        int rows = departmentService.updateById(dep);
        dep.setModifyUserId(userId);
        return ResponseData.SUCCESS(rows);
    }

    @PostMapping("delete_dep")
    @ResponseBody
    public ResponseData deleteDep(Integer depId){
        int rows = departmentService.deleteById(depId);
        return ResponseData.SUCCESS(rows);
    }
}