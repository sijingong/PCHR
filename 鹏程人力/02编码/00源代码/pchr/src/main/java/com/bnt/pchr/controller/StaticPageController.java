package com.bnt.pchr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("v")
public class StaticPageController {
    /**
     * 跳转页面模板
     *
     *
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
     *
     *
     * @return
     */
    @GetMapping("{page}")
    public String forwardPage(@PathVariable("page") String page) {
        return  page;
    }

}
