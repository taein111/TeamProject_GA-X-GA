package com.teamproject.gaxga.controller;

import com.teamproject.gaxga.dto.JoinMembershipForm;
import com.teamproject.gaxga.entity.JoinMembership;
import com.teamproject.gaxga.repository.JoinMembershipRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class JoinMembershipController {
    @Autowired
    private JoinMembershipRepository joinMembershipRepository;

    @GetMapping("/joinMembership")
    public String showJoinMembership(){
        return "accountManagement/joinMembership";
    }

    @PostMapping("/joinMembership/create")
    public String createJoinMembership(JoinMembershipForm joinMembershipForm, Model model){
        log.info("==============" + joinMembershipForm.toString());
        if(joinMembershipRepository.existsByGaId(joinMembershipForm.toEntity().getGaId())) {
            model.addAttribute("message", "중복된 아이디가 있습니다.");

            log.info(joinMembershipForm.toString());
            return "accountManagement/failCreate";
        }else {
            JoinMembership joinMembership = joinMembershipForm.toEntity();
            JoinMembership savedJoinMembership = joinMembershipRepository.save(joinMembership);
            log.info(joinMembershipForm.toString());
            log.info(joinMembership.toString());
            log.info(savedJoinMembership.toString());
            model.addAttribute("message", "회원가입이 완료되었습니다.");


            return "accountManagement/passCreate";
        }
    }

    @GetMapping("/joinMembership/create/result")
    public String resultCreate(@PathVariable Long id, Model model){
        log.info("==========id: " + id);
        log.info("==========model: " + model.toString());

        return "";
    }
}
