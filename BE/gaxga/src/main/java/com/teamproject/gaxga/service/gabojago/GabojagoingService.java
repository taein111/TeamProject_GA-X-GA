package com.teamproject.gaxga.service.gabojago;

import com.teamproject.gaxga.entity.Gabowatdago;
import com.teamproject.gaxga.entity.gabojago.GP;
import com.teamproject.gaxga.repository.gabojago.GpRepository;
import com.teamproject.gaxga.repository.gabojago.GrRepository;
import com.teamproject.gaxga.repository.gabojago.GtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class GabojagoingService {
    @Autowired
    private GpRepository gpRepository;
    private GrRepository grRepository;
    private GtRepository gtRepository;

    public String show(Long id, Model model) {
        GP gabojagoingEntity = gpRepository.findById(id).orElse(null);
        model.addAttribute("gabojagoing", gabojagoingEntity);
        return "public/gabojagoing/gabojagoing";
    }

    public String index(Model model) {
        //1. 모든 데이터 가져오기
        List<GP> gabojagoingEntityList = gpRepository.findAll();
        List<String> locList = grRepository.findAllNames();
        List<String> themaList = gtRepository.findAllNames();
        //2. 모델에 데이터 등록하기
        model.addAttribute("gabojagoingList", gabojagoingEntityList);
        model.addAttribute("locList", locList);
        model.addAttribute("themaList", themaList);
        //3. 뷰 페이지 등록하기
        return "private/gabojagoing/gabojagoing";
    }
}
