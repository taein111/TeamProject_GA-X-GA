package com.teamproject.gaxga.controller;

import lombok.ToString;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@ToString
@Controller
public class GabojagoingController {
    @GetMapping("/gabojagoing")
<<<<<<< HEAD
    public String showGabojagoing(){
        return "public/gabojagoing/gabojagoing";
=======
    public String Gabojagoing(){
        return "private/gabojagoing/gabojagoing";
>>>>>>> 7f143ff5c589f1efe99408f8c5a5c8be2580df71
    }
}
