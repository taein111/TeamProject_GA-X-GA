package com.teamproject.gaxga.controller.gabojago;

import com.teamproject.gaxga.repository.gabojago.GiRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Controller
public class GabojagoController {
    @GetMapping("/gabojago")
    public String start(){
        return "gabojago/gabojago";
    }
    @Autowired
    private GiRepository giRepository;

    @GetMapping("/images")
    public String Img(Model model){
        List<String> name = giRepository.findAllNames();
        model.addAttribute("names", name);
        return "gabojago/images";
    }


}
