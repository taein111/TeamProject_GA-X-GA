package com.teamproject.gaxga.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class GabojagoController {
    @GetMapping("/gabojago")
    public String start(){
        return "gabojago/gabojago";
    }

}
