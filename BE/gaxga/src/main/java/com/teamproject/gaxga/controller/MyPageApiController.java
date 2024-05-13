package com.teamproject.gaxga.controller;

import com.teamproject.gaxga.dto.JoinMembershipForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class MyPageApiController {

    @PostMapping("/api/myPage")
    public String updateUserInfo(@RequestBody JoinMembershipForm form){
        log.info("myPage gaNick : " + form.getGaNick() + " gaPhone : " + form.getGaPhone() + " gaPassword : " + form.getGaPass() + " gaEmail : " + form.getGaEmail() );
        return "";
    }
}