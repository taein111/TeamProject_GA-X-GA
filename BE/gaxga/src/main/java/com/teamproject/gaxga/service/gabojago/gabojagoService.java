package com.teamproject.gaxga.service.gabojago;

import com.teamproject.gaxga.entity.gabojago.GP;
import com.teamproject.gaxga.repository.gabojago.GpRepository;
import com.teamproject.gaxga.repository.gabojago.GrRepository;
import com.teamproject.gaxga.repository.gabojago.GtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
@Service
public class gabojagoService{

    @Autowired
    private GpRepository gpRepository;

    @Autowired
    private GtRepository gtRepository;

    @Autowired
    private GrRepository grRepository;

    public String gaboShow(Model model){
        List<String> location = grRepository.findAllNames();
        List<String> thema = gtRepository.findAllNames();
        List<GP> GPList = gpRepository.findAll();
        List<GP> Gangwon = gpRepository.findByGangwon();
        model.addAttribute("GPList", GPList);
        model.addAttribute("Gangwon", Gangwon);
        model.addAttribute("locations", location);
        model.addAttribute("themas", thema);
        return "public/gabojago/gabojago";
    }
}
