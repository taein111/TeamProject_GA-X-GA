package com.teamproject.gaxga.service;

import com.teamproject.gaxga.dto.JoinMembershipForm;
import com.teamproject.gaxga.entity.User;
import com.teamproject.gaxga.entity.UserDetail;
import com.teamproject.gaxga.entity.gabojago.Jjim;
import com.teamproject.gaxga.repository.UserRepository;
import com.teamproject.gaxga.repository.gabojago.JjimRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
@Slf4j
public class MyPageService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private JjimRepository jjimRepository;

    public String showMyPage(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetail userDetail = (UserDetail) auth.getPrincipal();
        model.addAttribute("userDetail", userDetail);

        //가보자고
        User user = userDetail.getUser();
        Long userId = user.getUserCode();
        Long countOfJjim = jjimRepository.countByUserId(userId);
        List<Jjim> myList = jjimRepository.findByJjim();
        for(Jjim jjim : myList){
            log.info("=====================================================================myList" + jjim.getGpid());
        }
        List<User> userCode = userRepository.findAll();
        model.addAttribute("jjimCount", countOfJjim);
        //로그인을 한 사람의 userCode
        model.addAttribute("userCode", userCode);
        model.addAttribute("myList", myList);
        log.info("=====================================================userId = " + userId);

        return "private/accountManagement/myPage";
    }

    public String fixMyInfo(JoinMembershipForm joinMembershipForm){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetail userDetail = (UserDetail) auth.getPrincipal();
        User user = userDetail.getUser();

        if(!joinMembershipForm.getGaNick().equals(user.getGaNick())){
            if (joinMembershipForm.getGaNick().isEmpty()) {
                log.info("joinInfo : " + joinMembershipForm.getGaNick());
            } else {
                user.setGaNick(joinMembershipForm.getGaNick());
            }
        }
        if (!joinMembershipForm.getGaPhone().equals(user.getGaPhone())){
            if(joinMembershipForm.getGaPhone().isEmpty()) {
                log.info("joinInfo : " + joinMembershipForm.getGaPhone());
            } else {
                user.setGaPhone(joinMembershipForm.getGaPhone());
            }
        }
        if (!joinMembershipForm.getGaPass().equals(user.getGaPass())){
            if(joinMembershipForm.getGaPass().isEmpty()) {
                log.info("joinInfo : " + joinMembershipForm.getGaPass());
            } else {
                String changePass = joinMembershipForm.getGaPass();
                String encodedPass = bCryptPasswordEncoder.encode(changePass);
                user.setGaPass(encodedPass);
            }
        }
        if (!joinMembershipForm.getGaEmail().equals(user.getGaEmail())){
            if(joinMembershipForm.getGaEmail().isEmpty()) {
                log.info("joinInfo : " + joinMembershipForm.getGaEmail());
            } else {
                user.setGaEmail(joinMembershipForm.getGaEmail());
            }
        }
        userRepository.save(user);
        return "redirect:/myPage";
    }
}
