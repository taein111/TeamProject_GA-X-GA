package com.teamproject.gaxga.service;

import com.teamproject.gaxga.dto.JoinMembershipForm;
import com.teamproject.gaxga.entity.User;
import com.teamproject.gaxga.entity.UserDetail;
import com.teamproject.gaxga.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
@Slf4j
public class MyPageService {

    @Autowired
    private UserRepository userRepository;

    public String showMyPage(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetail userDetail = (UserDetail) auth.getPrincipal();
        model.addAttribute("userDetail", userDetail);
        return "private/accountManagement/myPage";
    }

    public String fixMyInfo(JoinMembershipForm joinMembershipForm){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetail userDetail = (UserDetail) auth.getPrincipal();
        User user = userDetail.getUser();
        log.info("userInfo : " + user.getGaNick() + " " + user.getGaPhone() + " " + user.getGaEmail() + " " + user.getGaPass());
        log.info("joinInfo : " + joinMembershipForm.getGaNick() + " " + joinMembershipForm.getGaPhone() + " " + joinMembershipForm.getGaEmail() + " " + joinMembershipForm.getGaPass());
        if(!joinMembershipForm.getGaNick().equals(user.getGaNick())){
            if (joinMembershipForm.getGaNick().isEmpty()) {
                log.info("joinInfo : " + joinMembershipForm.getGaNick());
            } else {
                log.info("GaNick is after " + user.getGaNick());
                user.setGaNick(joinMembershipForm.getGaNick());
                log.info("GaNick is before " + user.getGaNick());
            }
        }
        if (!joinMembershipForm.getGaPhone().equals(user.getGaPhone())){
            if(joinMembershipForm.getGaPhone().isEmpty()) {
                log.info("joinInfo : " + joinMembershipForm.getGaPhone());
            } else {
                log.info("GaPhone is after " + user.getGaPhone());
                user.setGaPhone(joinMembershipForm.getGaPhone());
                log.info("GaPhone is before " + user.getGaPhone());
            }
        }
        if (!joinMembershipForm.getGaPass().equals(user.getGaPass())){
            if(joinMembershipForm.getGaPass().isEmpty()) {
                log.info("joinInfo : " + joinMembershipForm.getGaPass());
            } else {
                log.info("GaPass is after " + user.getGaPass());
                user.setGaPass(joinMembershipForm.getGaPass());
                log.info("GaPass is before " + user.getGaPass());
            }
        }
        if (!joinMembershipForm.getGaEmail().equals(user.getGaEmail())){
            if(joinMembershipForm.getGaEmail().isEmpty()) {
                log.info("joinInfo : " + joinMembershipForm.getGaEmail());
            } else {
                log.info("GaEmail is after " + user.getGaEmail());
                user.setGaEmail(joinMembershipForm.getGaEmail());
                log.info("GaEmail is before " + user.getGaEmail());
            }
        }
        userRepository.save(user);
        return "redirect:/myPage";
    }
}
