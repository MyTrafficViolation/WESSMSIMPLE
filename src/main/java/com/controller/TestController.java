package com.controller;

import com.bean.Test;
import com.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018/9/7.
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/selectByKey")
    public Test selectByKey(HttpServletRequest request){
        return testService.selectByPrimaryKey(1);
    }

    @RequestMapping("/updateTestHp")
    public int updateTestHp(HttpServletRequest request){
        return testService.uodateTestHp(testService.selectByPrimaryKey(1));
    }

}
