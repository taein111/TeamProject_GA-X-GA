package com.teamproject.gaxga.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FindInfo {

    @GetMapping("/findInfo")
    public String findInfo() {
        return "findInfo";
    }
}
