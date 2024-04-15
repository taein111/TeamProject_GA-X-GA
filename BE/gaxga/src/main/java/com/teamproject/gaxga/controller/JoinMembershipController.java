package com.teamproject.gaxga.controller;

import com.teamproject.gaxga.dto.JoinMembershipForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class JoinMembershipController {

    @GetMapping("/joinMembership")
    public String showJoinMembership(){
        return "accountManagement/joinMembership";
    }

    @PostMapping("/joinMembership/create")
    public String createJoinMembership(JoinMembershipForm joinMembershipForm){
        log.info(joinMembershipForm.toString());
        return "";
    }
}
