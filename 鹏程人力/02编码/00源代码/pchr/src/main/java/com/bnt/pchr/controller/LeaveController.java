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
@RequestMapping("leave")
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
     * 查询请假申请表列表
     * @param leave
     * @return
     */
    @RequestMapping("select_list")
    @ResponseBody
    public ResponseData selectByEmpId(Leave leave)
    {
        List<Leave> leaveList=leaveService.selectList(leave);
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
        return ResponseData.SUCCESS(leaveService.selectPage(pageData));
    }

    /**
     * 根据申请状态查询请假表
     * @param applyState
     * @param current
     * @param size
     * @param orderRules
     * @return
     */
    @RequestMapping("select_by_apply_state")
    @ResponseBody
    public ResponseData selectByApplyState(Integer applyState,long current,long size,@RequestParam(required = false) String[] orderRules)
    {
        if(applyState==null)
        {
            return ResponseData.FAIL(400,"缺少申请状态参数");
        }
        PageData<Leave> pageData=new PageData<>();
        pageData.setSize(size);
        pageData.setCurrent(current);
        pageData.setOrderRuleList(orderRules);
        pageData.addCriteria("applyState",applyState);
        return ResponseData.SUCCESS(leaveService.selectPage(pageData));
    }

    /**
     * 根据请假类型查询请假表
     * @param leaveType
     * @param current
     * @param size
     * @param orderRules
     * @return
     */
    @RequestMapping("select_by_leave_type")
    @ResponseBody
    public ResponseData selectByLeaveType(Integer leaveType,long current,long size,@RequestParam(required = false) String[] orderRules)
    {
        if(leaveType==null)
        {
            return ResponseData.FAIL(400,"缺少请假类型参数");
        }
        PageData<Leave> pageData=new PageData<>();
        pageData.setSize(size);
        pageData.setCurrent(current);
        pageData.setOrderRuleList(orderRules);
        pageData.addCriteria("leaveType",leaveType);
        return ResponseData.SUCCESS(leaveService.selectPage(pageData));
    }

    /**
     * 根据销假状态查询请假表
     * @param destoryState
     * @param current
     * @param size
     * @param orderRules
     * @return
     */
    @RequestMapping("select_by_destory_state")
    @ResponseBody
    public ResponseData selectByDestoryState(Integer destoryState,long current,long size,@RequestParam(required = false) String[] orderRules)
    {
        if(destoryState==null)
        {
            return ResponseData.FAIL(400,"缺少销假状态参数");
        }
        PageData<Leave> pageData=new PageData<>();
        pageData.setSize(size);
        pageData.setCurrent(current);
        pageData.setOrderRuleList(orderRules);
        pageData.addCriteria("destoryState",destoryState);
        return ResponseData.SUCCESS(leaveService.selectPage(pageData));
    }

}