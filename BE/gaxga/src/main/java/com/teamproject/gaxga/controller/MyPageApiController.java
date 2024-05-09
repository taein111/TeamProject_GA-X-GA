package com.teamproject.gaxga.controller;

import com.teamproject.gaxga.dto.JoinMembershipForm;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/myPage")
public class MyPageApiController {

    @PutMapping("/api/myPage")
    public String updateUserInfo(@RequestBody JoinMembershipForm form){

        return "";
    }
}