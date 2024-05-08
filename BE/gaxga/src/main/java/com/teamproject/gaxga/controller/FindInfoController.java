package com.teamproject.gaxga.controller;

import com.teamproject.gaxga.entity.User;
import com.teamproject.gaxga.service.FindInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class FindInfoController {

    @Autowired
    private FindInfoService findInfoService;

    @GetMapping("/findInfo")
    public String showFindInfo() {
        return "public/accountManagement/findInfo";
    }


    @PostMapping("/findInfo/ID")
    @ResponseBody
    public String findId(@RequestBody User user){

        return "public/accountManagement/findInfo";
    }
}