package com.ms.vn.vndao.controller;

import com.ms.vn.vndao.model.GxHappyTen;
import com.ms.vn.vndao.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;
    @RequestMapping("/get")
    public GxHappyTen createUser() {
        GxHappyTen findUser = testService.findUser(2L);
        System.out.println(findUser.hashCode());
        return findUser;
    }
}
