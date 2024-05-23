package com.teamproject.gaxga.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginPage(){
        return "public/accountManagement/login";
    }

    @GetMapping("/login/Result")
    public String loginResult(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "exception", required = false) String exception,
                              Model model){
        log.info("=======error : " + error + ", exception : " + exception);
        model.addAttribute("error", error);
        model.addAttribute("exception", exception);
        return "redirect:/login";
    }
}