package com.bnt.pchr.controller;
import com.bnt.pchr.commons.vo.PageData;
import com.bnt.pchr.commons.vo.ResponseData;
import com.bnt.pchr.entity.WorkApply;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.bnt.pchr.service.IWorkApplyService;
import org.springframework.web.servlet.ModelAndView;


@Slf4j
@RequestMapping("workApply")
@Controller
@Api(value = "控制器")
public class WorkApplyController  {

    @Autowired
    @Qualifier("workApplyService")
    private IWorkApplyService workApplyService;

    /**
     * 提交申请
     * @param workApply
     * @return
     */
    @PostMapping("add_apply")
    @ResponseBody
    public ResponseData addApply(WorkApply workApply){
        int rows=workApplyService.insert(workApply);
        if(rows==9){
            return ResponseData.FAIL(10012,"开始时间和结束时间设置错误");
        }else {
            return ResponseData.SUCCESS(rows);
        }
    }

    /**
     * 根据id取消申请状态
     * @param applyId
     * @return
     */
    @GetMapping("cancel_by_id")
    @ResponseBody
    public ResponseData cancelApply(int applyId){
        WorkApply apply=new WorkApply();
        apply.setApplyId(applyId);
        int rows=workApplyService.updateById(apply);
        return ResponseData.SUCCESS(rows);
    }

    /**
     * 修改审批信息
     * @param workApply
     * @return
     */
    @PostMapping("update")
    @ResponseBody
    public ResponseData updateApply(WorkApply workApply){
        int rows=workApplyService.update(workApply);
        if(rows==4){
            return ResponseData.FAIL(10036,"已取消状态不可以再修改,该状态实现");
        }else if(rows==9){
            return ResponseData.FAIL(10035,"审批状态为已通过,无需修改");
        }
        return ResponseData.SUCCESS(rows);
    }
    /**
     * 根据员工id、关键字查询员工请假申请列表信息
     * @param empId
     * @param pageData
     * @param kd
     * @return
     */
    @PostMapping("select_page")
    @ResponseBody
    public ResponseData selectPage(int empId, PageData<WorkApply> pageData, String kd, int current, int size, ModelAndView mv,Integer applyState,Integer overtimeType,Integer costType){
        pageData.addCriteria("kd",kd);
        pageData.addCriteria("empId",empId);
        pageData.addCriteria("costType",costType);
        pageData.addCriteria("applyState",applyState);
        pageData.addCriteria("overtimeType",overtimeType);
        pageData.setCurrent(current);
        pageData.setSize(size);
        mv.addObject("workApplyList",workApplyService.selectPage(pageData));
        return ResponseData.SUCCESS(workApplyService.selectPage(pageData).getRecords());
    }
}