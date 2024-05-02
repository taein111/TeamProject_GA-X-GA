package com.teamproject.gaxga.controller;

import lombok.ToString;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@ToString
@Controller
public class GabojagoingController {
    @GetMapping("/gabojagoing")
    public String showGabojagoing() {
        return "public/gabojagoing/gabojagoing";
    }
}
