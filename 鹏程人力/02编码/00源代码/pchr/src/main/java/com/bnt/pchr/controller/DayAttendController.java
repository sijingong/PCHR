package com.bnt.pchr.controller;

import com.bnt.pchr.commons.vo.PageData;
import com.bnt.pchr.commons.vo.ResponseData;
import com.bnt.pchr.entity.DayAttend;
import com.bnt.pchr.entity.Department;
import com.bnt.pchr.entity.Emp;
import com.bnt.pchr.entity.Job;
import com.bnt.pchr.service.IDepartmentService;
import com.bnt.pchr.service.IEmpService;
import com.bnt.pchr.service.IJobService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.bnt.pchr.service.IDayAttendService;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Slf4j
@RequestMapping("dayAttend")
@Controller
@Api(value = "控制器")
public class DayAttendController {

    @Autowired
    @Qualifier("dayAttendService")
    private IDayAttendService dayAttendService;

    @Autowired
    @Qualifier("empService")
    private IEmpService empService;

    @Autowired
    @Qualifier("jobService")
    private IJobService jobService;

    @Autowired
    @Qualifier("departmentService")
    private IDepartmentService departmentService;

    /**
     * 创建上下班打卡记录
     *
     * @param dayAttend
     * @return
     */
    @PostMapping("create")
    @ResponseBody
    public ResponseData createDayAttend(DayAttend dayAttend) {
        int rows = dayAttendService.insert(dayAttend);
        if (-1 == rows) {
            return ResponseData.FAIL(100301, "您无法在下班后进行打卡!");
        } else if (9 == rows) {
            return ResponseData.FAIL(100302, "未到下班打卡时间，不可以重复打卡");
        }
        return ResponseData.SUCCESS(rows);
    }

    /**
     * 创建补卡记录
     *
     * @param dayAttend
     * @return
     */
    @PostMapping("compensate")
    @ResponseBody
    public ResponseData insertCompensate(DayAttend dayAttend) {
        int rows = dayAttendService.compensateCard(dayAttend);
        if (rows == 9) {
            return ResponseData.FAIL(10035, "您的补卡次数已超过3次，不可以再补卡");
        }
        return ResponseData.SUCCESS(rows);
    }

    /**
     * 修改打卡状态----失效
     *
     * @param dayAttend
     * @return
     */
    @PostMapping("modify")
    @ResponseBody
    public ResponseData modifyDayAttend(DayAttend dayAttend) {
        int rows = dayAttendService.update(dayAttend);
        if (rows == -1) {
            return ResponseData.FAIL(10036, "您未对打卡状态进行修改");
        }
        return ResponseData.SUCCESS(rows);
    }

    /**
     * 查询补卡次数和员工数据
     *
     * @param dayAttend
     * @return
     */
    @RequestMapping("query_count")
    public ModelAndView queryCompensateCount(DayAttend dayAttend, ModelAndView mv) {
        int rows = dayAttendService.queryCompensateCount(dayAttend);
        Emp emp = empService.selectOne(dayAttend.getEmpId());
        Job job = jobService.selectOne(emp.getJobId());
        emp.setJob(job);
        Department dep = departmentService.selectOne(emp.getDepId());
        emp.setDep(dep);
        mv.addObject("emp", emp);
        mv.addObject("rows", rows);
        mv.setViewName("/dayAttend/compensate_card");
        return mv;
    }

    /**
     * 查询打卡记录
     *
     * @param kd          关键字检索
     * @param attendState 打卡状态
     * @param empId       员工id
     * @param startTime   开始时间
     * @param endTime     截至时间
     * @param pageData
     * @return
     */
    @PostMapping("select_list")
    public ModelAndView selectDayAttendByTime(String kd, Integer attendState, Integer empId, Date startTime, Date endTime, PageData pageData, int current, int size) {
        pageData.addCriteria("kd", kd);
        pageData.addCriteria("attendState", attendState);
        pageData.addCriteria("empId", empId);
        pageData.addCriteria("startTime", startTime);
        pageData.addCriteria("endTime", endTime);
        pageData.setCurrent(current);
        pageData.setSize(size);
        //进行分页查询
        PageData<DayAttend> attendVOList = dayAttendService.selectPage(pageData);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("attendVOList", attendVOList);
        modelAndView.setViewName("/dayAttend/attend_list");
        return modelAndView;
    }

    /**
     * 查询当前打卡状态
     *
     * @param empId
     * @param times
     * @return
     */
    @PostMapping("select_one")
    @ResponseBody
    public ResponseData selectOne(int empId, String times) {
        int rows = dayAttendService.selectOne(empId, times);
        if (rows == 6) {//今日完成上下班打卡
            return ResponseData.FAIL(10020, "今日上下班打卡已完成,请勿重新打卡");
        }
        if (rows == -2) {//今日尚未打卡
            DayAttend dayAttend = new DayAttend();
            dayAttend.setEmpId(empId);
            dayAttend.setAttendTime(new Date());
            int row = dayAttendService.insert(dayAttend);
            if (-1 == row) {
                return ResponseData.FAIL(100301, "您无法在下班后进行打卡!");
            } else if (9 == row) {
                return ResponseData.FAIL(100302, "未到下班打卡时间，不可以重复打卡");
            } else {//添加成功
                return ResponseData.SUCCESS(2);
            }
        }
        return ResponseData.SUCCESS(rows);
    }

    /**
     * 查询已经打卡的列表
     *
     * @param dayAttend
     * @return
     */
    @PostMapping("select_attended")
    @ResponseBody
    public ResponseData Attended(DayAttend dayAttend) {
        List<Date> dateList = new ArrayList<>();
        List<DayAttend> dayAttendList = dayAttendService.isAttended(dayAttend);
        for (DayAttend day : dayAttendList) {
            Date date = day.getAttendTime();
            dateList.add(date);
        }
        return ResponseData.SUCCESS(dayAttendList);
    }
}