package com.bnt.pchr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("v")
public class StaticPageController {
    /**
     * 跳转多级目录
     *
     * @param dir
     * @return
     */
    @GetMapping("/{dir}/**")
    public String forwardPage1(@PathVariable("dir") String dir, HttpServletRequest request) {
        String url = request.getRequestURI();
        String path = url.replaceFirst("/v", "");
        return path;
    }

    /**
     * 跳转页面模板
     *
     * @return
     */
    @GetMapping("/{dir}/{page}")
    public String forwardPage(@PathVariable("dir") String dir, @PathVariable("page") String page) {
        return dir + "/" + page;
    }

    /**
     * 跳转页面模板
     *
     * @return
     */
    @GetMapping("{page}")
    public String forwardPage(@PathVariable("page") String page) {
        return page;
    }

}
