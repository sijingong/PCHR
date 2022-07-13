package com.bnt.pchr.controller;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.bnt.pchr.service.IEmpContractService;

@Slf4j
@RequestMapping("empContract")
@Controller
@Api(value = "控制器")
public class EmpContractController  {

    @Autowired
    @Qualifier("empContractService")
    private IEmpContractService empContractService;

}