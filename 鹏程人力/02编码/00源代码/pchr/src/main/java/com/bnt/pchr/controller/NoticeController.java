package com.bnt.pchr.controller;
import com.bnt.pchr.commons.util.Remind;
import com.bnt.pchr.commons.vo.ResponseData;
import com.bnt.pchr.entity.Emp;
import com.bnt.pchr.entity.EmpContract;
import com.bnt.pchr.entity.Notice;
import com.bnt.pchr.service.IEmpContractService;
import com.bnt.pchr.service.IEmpService;
import com.bnt.pchr.service.WebSocket;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.bnt.pchr.service.INoticeService;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@RequestMapping("notice")
@Controller
@Api(value = "公告控制器")
public class NoticeController  {

    @Autowired
    @Qualifier("noticeService")
    private INoticeService noticeService;
    @Autowired
    @Qualifier("empService")
    private IEmpService empService;
    @Autowired
    @Qualifier("empContractService")
    private IEmpContractService empContractService;
    @Autowired
    private WebSocket webSocket;



    @PostMapping("create_notice")
    @ResponseBody
    public ResponseData createNotice(Notice notice){
        int rows = noticeService.insert(notice);
        return ResponseData.SUCCESS(rows);
    }

    @GetMapping("delete_by_id")
    @ResponseBody
    public ResponseData deleteById(Integer noticeId){
        int rows = noticeService.deleteById(noticeId);
        return ResponseData.SUCCESS(rows);
    }

    @GetMapping("modify_by_id")
    @ResponseBody
    public ResponseData modifyById(Notice notice){
        int rows = noticeService.updateById(notice);
        return ResponseData.SUCCESS(rows);
    }

    @GetMapping("remind_birthday")
    @ResponseBody
    @Scheduled(cron = "0 0 10 * * ?")
    public ResponseData remindBirthday(){
        List<Emp> empList = empService.selectList();
        System.out.println(empList);
        List<String> messageList=new ArrayList<>();
        for (Emp emp:empList) {
            String remind = Remind.birthdayRemind(emp);
            if (remind!=null){
                messageList.add(remind);
            }
            webSocket.sendMessage(emp.getEmpName()+messageList);
        }
        return ResponseData.SUCCESS(messageList);
    }

    @GetMapping("remind_contract")
    @ResponseBody
    @Scheduled(cron = "0 0 9 * * ?")
    public ResponseData remindContract(){
        List<EmpContract> empContractList = empContractService.selectList();
        List<String> messageList=new ArrayList<>();
        for (EmpContract empContract:empContractList) {
            String remind = Remind.contractRemind(empContract);
            if (remind!=null){
                messageList.add(empContract.getEmp().getEmpName()+remind);
            }
        }
        return ResponseData.SUCCESS(messageList);
    }
}