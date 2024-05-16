package com.teamproject.gaxga.controller.gabojago;

import com.teamproject.gaxga.entity.gabojago.GP;
import com.teamproject.gaxga.entity.gabojago.Jjim;
import com.teamproject.gaxga.entity.User;
import com.teamproject.gaxga.service.UserDetailService;
import com.teamproject.gaxga.service.gabojago.GabojagoingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class GabojagoingController {

    @Autowired
    private GabojagoingService gabojagoingService;

    @Autowired
    private UserDetailService userService;

    @GetMapping("/gabojago")
    public String index(Model model) {
        Optional<GP> gp = gabojagoingService.findById(1L); // 예시로 ID 1을 사용
        if (gp.isPresent()) {
            model.addAttribute("gabojagoing", gp.get());

            // 현재 로그인한 사용자 정보 가져오기
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User user = null;
            if (principal instanceof UserDetails) {
                String username = ((UserDetails) principal).getUsername();
                user = userService.findByUsername(username); // 사용자 정보를 가져오는 로직
            }

            Optional<Jjim> jjim = gabojagoingService.findJjimByGp(gp.get(), user);
            if (jjim.isPresent()) {
                model.addAttribute("jjim", jjim.get());
                System.out.println("Jjim count: " + jjim.get().getCount());
            } else {
                model.addAttribute("jjim", null);
                System.out.println("Jjim is null");
            }
        } else {
            model.addAttribute("gabojagoing", null);
            model.addAttribute("jjim", null);
        }
        return "public/gabojagoing/gabojagoing";
    }
}



