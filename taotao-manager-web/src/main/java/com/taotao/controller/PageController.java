package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @Author: liuXuyang
 * @studentNo 15130110024
 * @Emailaddress 1187697635@qq.com
 * @Date: 2018/5/1 20:18
 */

@Controller
@RequestMapping("/")
public class PageController {

    /**
     * 首页
     * @return
     */

    @RequestMapping("/")
    public String index()
    {
        return "index";
    }

    /**
     * 子页面
     */
    @RequestMapping("/{page}")
    public String showPage(@PathVariable("page")String page)
    {
        return page;
    }
}
