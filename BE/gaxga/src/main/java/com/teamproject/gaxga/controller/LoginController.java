package com.teamproject.gaxga.controller;

import com.teamproject.gaxga.dto.LoginForm;
import com.teamproject.gaxga.entity.Login;
import com.teamproject.gaxga.repository.JoinMembershipRepository;
import com.teamproject.gaxga.repository.LoginRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Slf4j
@Controller
public class LoginController {
    @Autowired
    private JoinMembershipRepository joinMembershipRepository;
    @Autowired
    private LoginRepository loginRepository;

    @GetMapping("/login")
    public String showLoginPage(){
        return "accountManagement/login";
    }

    @PostMapping("/login")
    public String postLoginForm(LoginForm loginForm, Model model){
        log.info("==============" + loginForm.toString());
        Optional<Login> optionalLogin = loginRepository.findByGaIdAndGaPass(loginForm.toEntity().getGaId(), loginForm.toEntity().getGaPass());

        log.info("============="+optionalLogin.toString());

        if(optionalLogin.isPresent()){
            return "main.html";
        }else {
            model.addAttribute("message", "아이디 또는 비밀번호가 올바르지 않습니다.");
            return "login";
        }
    }
}
