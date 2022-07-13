package com.bnt.pchr.config.web.handler;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

@Controller
@RequestMapping("${server.error.path:${error.path:/error}}")
public class CustomErrorController extends BasicErrorController {

    @Autowired
    public CustomErrorController(ServerProperties serverProperties) {
        super(new DefaultErrorAttributes(), serverProperties.getError());
    }

    /**
     * 覆盖默认的JSON响应
     */
    @Override
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        HttpStatus status = getStatus(request);
        Map<String, Object> map = getErrorData(request);
        return new ResponseEntity<Map<String, Object>>(map, status);
    }

    /**
     * 覆盖默认的HTML响应
     */
    @Override
    public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView  mv=new ModelAndView();
        mv.setViewName("error");
        return mv;
    }

    /**
     * 获取错误信息
     *
     * @param request
     */
    private Map<String, Object> getErrorData(HttpServletRequest request) {
        HttpStatus httpStatus = getStatus(request);
        ErrorAttributeOptions options = ErrorAttributeOptions.of(
                ErrorAttributeOptions.Include.BINDING_ERRORS,
                ErrorAttributeOptions.Include.EXCEPTION,
                ErrorAttributeOptions.Include.MESSAGE,
                ErrorAttributeOptions.Include.STACK_TRACE);
        Map<String, Object> originalMsgMap = getErrorAttributes(request, options);
        String path = (String) originalMsgMap.get("path");
        String error = (String) originalMsgMap.get("error");
        String message = (String) originalMsgMap.get("message");
        StringJoiner joiner = new StringJoiner(",", "[", "]");
        joiner.add(path).add(error).add(message);
        int status = httpStatus.value();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", httpStatus.value());
        map.put("message", joiner.toString());
        return map;
    }
}
