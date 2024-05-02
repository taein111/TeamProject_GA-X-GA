package com.teamproject.gaxga.controller.gabojago;

import com.teamproject.gaxga.entity.gabojago.GP;
import com.teamproject.gaxga.repository.gabojago.GpRepository;
import com.teamproject.gaxga.repository.gabojago.GrRepository;
import com.teamproject.gaxga.repository.gabojago.GtRepository;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@ToString
@Slf4j
@Controller
public class GabojagoController {

    @Autowired
    private com.teamproject.gaxga.service.gabojago.gabojagoService gabojagoService;

    @GetMapping("/gabojago")
    public String loc(Model model){
        return gabojagoService.gaboShow(model);
    }
}
