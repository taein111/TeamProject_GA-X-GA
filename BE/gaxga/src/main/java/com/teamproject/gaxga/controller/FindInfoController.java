package com.teamproject.gaxga.controller;

import com.teamproject.gaxga.entity.User;
import com.teamproject.gaxga.service.FindInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
public class FindInfoController {

    @Autowired
    private FindInfoService findInfoService;

    @GetMapping("/findInfo")
    public String showFindInfo() {
        return "public/accountManagement/findInfo";
    }


    @PostMapping("/findInfo/ID")
    public String findId(User user, RedirectAttributes redirectAttributes){
        User data = findInfoService.findUserInfo(user);
        if(data == null){
            redirectAttributes.addFlashAttribute("msg", "회원정보가 없습니다.");
            return "redirect:/findInfo";
        } else{
            redirectAttributes.addFlashAttribute("msg", "회원님의 ID는 : " + data.getGaId());
            return "redirect:/findInfo";
        }
    }
    @PostMapping("/findInfo/Pass")
    public String findPass(User user, RedirectAttributes redirectAttributes){
        User data = findInfoService.findUserInfo(user);
        if(data == null){
            redirectAttributes.addFlashAttribute("msg", "회원정보가 없습니다.");
            return "redirect:/findInfo";
        } else{
            redirectAttributes.addFlashAttribute("msg", "회원님의 ID는 : " + data.getGaId());
            return "redirect:/findInfo";
        }
    }
}