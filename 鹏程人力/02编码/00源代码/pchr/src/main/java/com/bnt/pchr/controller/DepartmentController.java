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

    /**
     * 可选部门状态查询部门列表
     * @param depState
     * @return
     */
    @PostMapping("select_list")
    @ResponseBody
    public ResponseData selectList(Integer depState){
        List<Department> depList = departmentService.selectList(depState);
        return ResponseData.SUCCESS(depList);
    }

    /**
     * 查询部门并跳转到部门列表
     * @param depState
     * @param model
     * @return
     */
    @PostMapping("to_select")
    public String toSelect(Integer depState,Model model){
        List<Department> depList = departmentService.selectList(depState);
        model.addAttribute("depList",depList);
        return "dep/dep_list";
    }

    /**
     * 根据id查询部门
     * @param depId
     * @return
     */
    @PostMapping("select_one")
    @ResponseBody
    public ResponseData selectOne(Integer depId){
        Department dep = departmentService.selectOne(depId);
        return ResponseData.SUCCESS(dep);
    }

    /**
     * 创建一个部门
     * @param dep
     * @param userId
     * @return
     */
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

    /**
     * 修改一个部门
     * @param dep
     * @param userId
     * @return
     */
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

    /**
     * 删除一个部门
     * @param depId
     * @return
     */
    @PostMapping("delete_dep")
    @ResponseBody
    public ResponseData deleteDep(Integer depId){
        int rows = departmentService.deleteById(depId);
        return ResponseData.SUCCESS(rows);
    }
}