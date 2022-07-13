package com.bnt.pchr.config.web.Intereptor;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bnt.pchr.commons.util.HttpRequestUtils;
import com.bnt.pchr.commons.vo.ResponseData;
import com.bnt.pchr.entity.Emp;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Log4j2
public class LoginCheckedInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();
        log.debug("当前请求路径为:" + url);
        //登录检查
        HttpSession session = request.getSession();
        Emp emp = (Emp) session.getAttribute("user");
        if (emp != null) {//说明已经登录
            return true;
        }
        if (!HttpRequestUtils.isAjaxRequest(request)) {
            //重定向登录页面
            response.sendRedirect("/login");
            return false;
        }
        //AJAX请求返回JSON格式数据
        //这是用500表示服务器运行异常
        ResponseData responseData = ResponseData.FAIL(400, "未登录或会话已超时");
        String jsonData = JSONObject.toJSONString(responseData, SerializerFeature.BrowserCompatible,
                SerializerFeature.WriteDateUseDateFormat,//日期格式化
                SerializerFeature.WriteEnumUsingToString,
                SerializerFeature.WriteMapNullValue,//null属性也输出
                SerializerFeature.WriteNullStringAsEmpty,//""
                SerializerFeature.WriteNullNumberAsZero,//0
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullListAsEmpty);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(jsonData);
        return false;
    }
}
