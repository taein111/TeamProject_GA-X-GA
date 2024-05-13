package com.teamproject.gaxga.service;

import com.teamproject.gaxga.dto.JoinMembershipForm;
import com.teamproject.gaxga.entity.User;
import com.teamproject.gaxga.entity.UserDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
@Slf4j
public class MyPageService {

    public String showMyPage(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetail userDetail = (UserDetail) auth.getPrincipal();
        model.addAttribute("userDetail", userDetail);
        return "private/accountManagement/myPage";
    }

    public String fixMyInfo(JoinMembershipForm joinMembershipForm, User user){
        log.info("service 시작");
        if(joinMembershipForm.getGaNick() != null){
            log.info("======join2:"+joinMembershipForm.getGaNick() +"======user2:"+user.getGaNick());
        } else if (joinMembershipForm.getGaPhone() != null) {
            log.info("GaPhone is set to " + joinMembershipForm.getGaPhone());
        } else if (joinMembershipForm.getGaAddress() != null) {
            log.info("GaAddress is set to " + joinMembershipForm.getGaAddress());
        } else if (joinMembershipForm.getGaEmail() != null) {
            log.info("GaEmail is set to " + joinMembershipForm.getGaEmail());
        }
        return "redirect:/myPage";
    }
}
