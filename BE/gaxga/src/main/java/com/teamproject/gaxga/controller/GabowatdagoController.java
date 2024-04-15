package com.teamproject.gaxga.controller;

import com.teamproject.gaxga.dto.GabowatdagoForm;
import com.teamproject.gaxga.entity.Gabowatdago;
import com.teamproject.gaxga.repository.GabowatdagoRepository;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@Controller
public class GabowatdagoController {
    @Autowired
    private GabowatdagoRepository gabowatdagoRepository;
    @GetMapping("/gabowatdago/gabowatdagoing_p")
    public String newForm(){
        return "gabowatdago/gabowatdagoing_p";
    }

    @PostMapping("/gabowatdago/create")
    public String create(GabowatdagoForm form) {
        log.info(form.toString());
        //1. DTO를 엔티티로
        Gabowatdago gabowatdago = form.toEntity();
        log.info(gabowatdago.toString());
        //2. 레퍼지토리로 엔티티를 DB에 저장
        Gabowatdago saved = gabowatdagoRepository.save(gabowatdago);
        log.info(saved.toString());
    return "";
    }
    @GetMapping("/gabowatdago/{id}")
    public String show(@PathVariable Long id, Model model) {
        //1. id를 조회해 데이터 가져오기
        Gabowatdago gabowatdagoEntity = gabowatdagoRepository.findById(id).orElse(null);
        //2. 가져온 데이터를 모델에 등록하기
        model.addAttribute("gabowatdago", gabowatdagoEntity);
        log.info(model.toString());
        //3. 조회한 데이터를 사용자에게 보여주기 위한 뷰 페이지 만들고 반환하기
        return "gabowatdago/gabowatdagoing";
    }

    @GetMapping("/gabowatdago")
    public String index(Model model){
        //1. 모든 데이터 가져오기
        List<Gabowatdago> gabowatdagoEntityList = gabowatdagoRepository.findAll();
        //2. 모델에 데이터 등록하기
        model.addAttribute("gabowatdagoList", gabowatdagoEntityList);
        //3. 뷰 페이지 등록하기
        return "gabowatdago/gabowatdago";
    }
}
