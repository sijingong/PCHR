package com.bnt.pchr.controller;
import com.bnt.pchr.commons.vo.ResponseData;
import com.bnt.pchr.entity.DayAttend;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.bnt.pchr.service.IDayAttendService;

@Slf4j
@RequestMapping("api/dayAttend")
@Controller
@Api(value = "控制器")
public class DayAttendController {

    @Autowired
    @Qualifier("dayAttendService")
    private IDayAttendService dayAttendService;

    /**
     * 创建上下班打卡记录
     * @param dayAttend
     * @return
     */
    @PostMapping("create")
    @ResponseBody
    public ResponseData createDayAttend(DayAttend dayAttend){
        int rows= dayAttendService.insert(dayAttend);
        if(0==rows){
            return ResponseData.FAIL(100301,"您无法在下班后进行打卡!");
        }
        return ResponseData.SUCCESS(rows);
    }

    /**
     * 创建补卡记录
     * @param dayAttend
     * @return
     */
    @PostMapping("compensate")
    @ResponseBody
    public ResponseData insertCompensate(DayAttend dayAttend){
        int rows=dayAttendService.compensateCard(dayAttend);
        if(rows==9){
            return ResponseData.FAIL(10035,"您的补卡次数已超过3次，不可以再补卡");
        }
        return ResponseData.SUCCESS(rows);
    }
}