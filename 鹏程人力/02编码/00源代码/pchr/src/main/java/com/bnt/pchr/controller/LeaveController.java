package com.bnt.pchr.controller;
import com.bnt.pchr.commons.vo.PageData;
import com.bnt.pchr.commons.vo.ResponseData;
import com.bnt.pchr.entity.Leave;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.bnt.pchr.service.ILeaveService;

import java.util.List;

@Slf4j
@RequestMapping("api/leave")
@Controller
@Api(value = "请假申请控制器")
public class LeaveController  {

    @Autowired
    @Qualifier("leaveService")
    private ILeaveService leaveService;

    /**
     * 创建请假申请
     * @param leave
     * @return
     */
    @RequestMapping("create")
    @ResponseBody
    public ResponseData createLeave(Leave leave)
    {
        int rows=leaveService.insert(leave);
        return ResponseData.SUCCESS(rows);
    }

    /**
     * 根据ID删除请假申请表
     * @param leaveId
     * @return
     */
    @PostMapping("delete")
    @ResponseBody
    public ResponseData deleteById(Integer leaveId)
    {
        int rows=leaveService.deleteById(leaveId);
        return ResponseData.SUCCESS(rows);
    }

    /**
     * 根据ID查询请假申请表
     * @param leaveId
     * @return
     */
    @PostMapping("load_by_id")
    @ResponseBody
    public ResponseData selectById(Integer leaveId){
        Leave leave=leaveService.selectOne(leaveId);
        return  ResponseData.SUCCESS(leave);
    }

    /**
     * 根据ID修改请假申请表
      * @param leave
     * @return
     */
    @RequestMapping("modify")
    @ResponseBody
    public ResponseData updateById(Leave leave){
         int rows= leaveService.updateById(leave);
         return ResponseData.SUCCESS(rows);
    }

    /**
     * 根据员工ID查询请假申请表
     * @param leave
     * @return
     */
    @RequestMapping("select_list")
    @ResponseBody
    public ResponseData selectByEmpId(Leave leave)
    {
        List<Leave> leaveList=leaveService.selectByEmpId(leave);
        return ResponseData.SUCCESS(leaveList);
    }

    /**
     * 根据员工ID分页查询请假申请表
     * @param empId
     * @param current
     * @param size
     * @param orderRules
     * @return
     */
    @RequestMapping("select_by_emp_id")
    @ResponseBody
    public ResponseData selectByEmpId(Integer empId,long current,long size,@RequestParam(required = false) String[] orderRules ){
        if(empId==null)
        {
            return ResponseData.FAIL(400,"缺少用户ID参数");
        }
        PageData<Leave> pageData=new PageData<>();
        pageData.setCurrent(current);
        pageData.setSize(size);
        pageData.setOrderRuleList(orderRules);
        pageData.addCriteria("empId",empId);
        return ResponseData.SUCCESS(leaveService.selectByEmpId(pageData));
    }
}