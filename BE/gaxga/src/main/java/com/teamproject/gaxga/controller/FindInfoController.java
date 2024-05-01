package com.teamproject.gaxga.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FindInfoController {

    @GetMapping("/findInfo")
    public String showFindInfo() {
        return "public/accountManagement/findInfo";
    }
}
