//package com.teamproject.gaxga.controller.gabojago;
//
//import com.teamproject.gaxga.repository.gabojago.GpRepository;
//import com.teamproject.gaxga.repository.gabojago.GrRepository;
//import com.teamproject.gaxga.repository.gabojago.GtRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import java.util.List;
//
//@Slf4j
//@Controller
//public class GabojagoController {
//
//    @Autowired
//    private GrRepository grRepository;
//
//    @Autowired
//    private GtRepository gtRepository;
//
//    @Autowired
//    private GpRepository gpRepository;
//
//    @GetMapping("/gabojago")
//    public String loc(Model model){
//        List<String> location = grRepository.findAllNames();
//        List<String> thema = gtRepository.findAllNames();
//        model.addAttribute("themas", thema);
//        model.addAttribute("locations", location);
//        return "gabojago/gabojago";
//    }
//}
//
//
//
//
