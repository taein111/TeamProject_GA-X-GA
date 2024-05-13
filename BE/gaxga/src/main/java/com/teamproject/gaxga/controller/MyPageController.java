package com.teamproject.gaxga.controller;

import com.teamproject.gaxga.dto.JoinMembershipForm;
import com.teamproject.gaxga.entity.User;
import com.teamproject.gaxga.entity.UserDetail;
import com.teamproject.gaxga.service.MyPageService;
import com.teamproject.gaxga.service.UserDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class MyPageController {

    @Autowired
    UserDetailService userDetailService;
    @Autowired
    MyPageService myPageService;

    @GetMapping("/myPage")
    public String showMyPage(Model model){
        return myPageService.showMyPage(model);
    }

    @PostMapping("/myPage")
    public String fixMyInfo(JoinMembershipForm joinMembershipForm, User user){
        log.info("======join:"+joinMembershipForm.getGaNick() +"======user:"+user.getGaNick());
        return myPageService.fixMyInfo(joinMembershipForm, user);
    }
}
