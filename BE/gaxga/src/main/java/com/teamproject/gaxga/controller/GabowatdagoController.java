package com.teamproject.gaxga.controller;

import com.teamproject.gaxga.dto.GabowatdagoForm;
import com.teamproject.gaxga.entity.UserDetail;

import com.teamproject.gaxga.service.FileService;
import com.teamproject.gaxga.service.GabowatdagoService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@Controller
public class GabowatdagoController {

    @Autowired
    private GabowatdagoService gabowatdagoService;

    private final FileService fileService;

    @Autowired
    public GabowatdagoController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/gabowatdagoing_p")
    public String newForm(Model model){
     return gabowatdagoService.newForm(model);
    }
    @PostMapping("/gabowatdago/create")
    public String create(GabowatdagoForm form) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetail userDetail = (UserDetail) auth.getPrincipal(); //로그인한사람 정보 가져오기
        Long userCode = userDetail.getUser().getUserCode(); // 가져와서 userCode 추출


        // FileService의 saveFile 메서드 호출
        try {
            // MultipartFile을 어떻게 얻어오는지에 따라서 인자를 넘겨주어야 합니다.
            // 아래는 예시입니다. form.getFile()은 MultipartFile 객체를 리턴하는 것으로 가정합니다.
            Long fileId = fileService.saveFile(form.getImage());
            // 파일 저장에 성공한 경우 처리
        } catch (IOException e) {
            // 파일 저장에 실패한 경우 처리
        }

        return gabowatdagoService.create(form, userCode); // 게시글 작성 메서드로 보내기
    }

    @GetMapping("/gabowatdago/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        return gabowatdagoService.show(id, model);
    }

    @GetMapping("/gabowatdago")
    public String index(Model model){
        return gabowatdagoService.index(model);
    }

    @GetMapping("/gabowatdago/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model){
        return gabowatdagoService.edit(id, model);
    }

    @PostMapping("/gabowatdago/update")
    public String update(GabowatdagoForm form){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetail userDetail = (UserDetail) auth.getPrincipal(); //로그인한사람 정보 가져오기
        Long userCode = userDetail.getUser().getUserCode(); // 가져와서 userCode 추출
        return gabowatdagoService.update(form, userCode);
    }

    @GetMapping("gabowatdago/{id}/delete")
    public String delete(@PathVariable("id") Long id){
        return gabowatdagoService.delete(id);
    }
}
