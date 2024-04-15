package com.teamproject.gaxga.controller;

import com.teamproject.gaxga.dto.LoginForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginPage(){
        return "accountManagement/login";
    }

    @PostMapping("/login")
    public String postLoginForm(LoginForm loginForm){
        log.info(loginForm.toString());
        return "";
    }
}
