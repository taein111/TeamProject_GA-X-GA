package com.teamproject.gaxga.service;

import com.teamproject.gaxga.dto.CmtDto;
import com.teamproject.gaxga.dto.GabowatdagoForm;
import com.teamproject.gaxga.dto.LikeDto;
import com.teamproject.gaxga.entity.Gabowatdago;
import com.teamproject.gaxga.entity.User;
import com.teamproject.gaxga.entity.UserDetail;
import com.teamproject.gaxga.entity.gabojago.GP;
import com.teamproject.gaxga.repository.GabowatdagoRepository;
import com.teamproject.gaxga.repository.UserRepository;
import com.teamproject.gaxga.repository.gabojago.GpRepository;
import com.teamproject.gaxga.repository.gabojago.GrRepository;
import com.teamproject.gaxga.repository.gabojago.GtRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
public class GabowatdagoService {
    @Autowired
    private GabowatdagoRepository gabowatdagoRepository;
    @Autowired
    private CmtService cmtService;
    @Autowired
    private GrRepository grRepository;
    @Autowired
    private GtRepository gtRepository;
    @Autowired
    private GpRepository gpRepository;


    public String newForm(Model model){
        List<String> locList = grRepository.findAllNames();
        List<String> themaList = gtRepository.findAllNames();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetail userDetail = (UserDetail) auth.getPrincipal();
        String gaId = userDetail.getUser().getGaId(); // 로그인한사람 gaId 가져오기
        String userNick = userDetail.getUser().getGaNick(); // 로그인한 사람 ganick 가져오기
        model.addAttribute("locList", locList);
        model.addAttribute("themaList", themaList);
        model.addAttribute("userNick", userNick);
        model.addAttribute("gaId", gaId);
        return "private/gabowatdago/gabowatdagoing_p";
    }

    @Transactional
    public String create(GabowatdagoForm form) {
        //1. DTO를 엔티티로
        Gabowatdago gabowatdago = form.toEntity();
        //2. 레퍼지토리로 엔티티를 DB에 저장
        Gabowatdago saved = gabowatdagoRepository.save(gabowatdago);
        return "redirect:/gabowatdago/" + saved.getId();
    }
    public String show(Long id, Model model) {
        //1. id를 조회해 데이터 가져오기
        //게시글 엔티티
        Gabowatdago gabowatdagoEntity = gabowatdagoRepository.findById(id).orElse(null);

        //댓글 엔티티
        List<CmtDto> cmtDtos = cmtService.comments(id);
        //로그인한 회원 정보
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();// 로그인한사람 userCode 가져오기
        UserDetail userDetail = (UserDetail) auth.getPrincipal();
        Long likeDtos = userDetail.getUser().getUserCode();
        String gaId = userDetail.getUser().getGaId(); // 로그인한사람 gaId 가져오기

        //데이터 모델에 등록하기
        model.addAttribute("gabowatdago", gabowatdagoEntity);
        model.addAttribute("cmtDtos", cmtDtos);
        model.addAttribute("user", likeDtos);
        model.addAttribute("gaId", gaId);


        //--- 작성한 글의 지역 카테고리에 맞는 가보자고의 지역 맞춤 추천리스트 출력
        List<GP> Gangwon = gpRepository.findByGangwon();
        List<GP> Gyeonggi = gpRepository.findByGyeonggi();
        List<GP> Gyeongnam = gpRepository.findByGyeongnam();
        List<GP> Gyeongbuk = gpRepository.findByGyeongbuk();
        List<GP> Gwangju = gpRepository.findByGwangju();
        List<GP> Daejeon = gpRepository.findByDaejeon();
        List<GP> Daegu = gpRepository.findByDaegu();
        List<GP> Busan = gpRepository.findByBusan();
        List<GP> Seoul = gpRepository.findBySeoul();
        List<GP> Sejong = gpRepository.findBySejong();
        List<GP> Ulsan  = gpRepository.findByUlsan();
        List<GP> Incheon = gpRepository.findByIncheon();
        List<GP> Jeonnam = gpRepository.findByJeonnam();
        List<GP> Jeonbuk = gpRepository.findByJeonbuk();
        List<GP> Jeju = gpRepository.findByJeju();
        List<GP> Chungnam = gpRepository.findByChungnam();
        List<GP> Chungbuk = gpRepository.findByChungbuk();

        //자신이 조회한 게시글의 지역 카테고리와 일치하는 지역추천목록 출력
        String boardLocal= gabowatdagoEntity.getLocal();
        switch (boardLocal) {
            case "강원":
                model.addAttribute("Gangwon", Gangwon);
                break;
            case "경기":
                model.addAttribute("Gyeonggi", Gyeonggi);
                break;
            case "경남":
                model.addAttribute("Gyeongnam", Gyeongnam);
                break;
            case "경북":
                model.addAttribute("Gyeongbuk", Gyeongbuk);
                break;
            case "광주":
                model.addAttribute("Gwangju", Gwangju);
                break;
            case "대전":
                model.addAttribute("Daejeon", Daejeon);
                break;
            case "대구":
                model.addAttribute("Daegu", Daegu);
                break;
            case "부산":
                model.addAttribute("Busan", Busan);
                break;
            case "서울":
                model.addAttribute("Seoul", Seoul);
                break;
            case "세종":
                model.addAttribute("Sejong", Sejong);
                break;
            case "울산":
                model.addAttribute("Ulsan", Ulsan);
                break;
            case "인천":
                model.addAttribute("Incheon", Incheon);
                break;
            case "전남":
                model.addAttribute("Jeonnam", Jeonnam);
                break;
            case "전북":
                model.addAttribute("Jeonbuk", Jeonbuk);
                break;
            case "제주":
                model.addAttribute("Jeju", Jeju);
                break;
            case "충남":
                model.addAttribute("Chungnam", Chungnam);
                break;
            case "충북":
                model.addAttribute("Chungbuk", Chungbuk);
                break;
            default:
                break;
        }

        //3. 조회한 데이터를 사용자에게 보여주기 위한 뷰 페이지 만들고 반환하기
        return "private/gabowatdago/gabowatdagoing";
    }

    public String index(Model model){
        //1. 모든 데이터 가져오기
        List<Gabowatdago> gabowatdagoEntityList = gabowatdagoRepository.findAll();
        List<String> locList = grRepository.findAllNames();
        List<String> themaList = gtRepository.findAllNames();
        //2. 모델에 데이터 등록하기
        model.addAttribute("gabowatdagoList", gabowatdagoEntityList);
        model.addAttribute("locList", locList);
        model.addAttribute("themaList", themaList);
        //3. 뷰 페이지 등록하기
        return "private/gabowatdago/gabowatdago";
    }
    public String edit(@PathVariable("id") Long id, Model model){
        //수정할 데이터 가져오기
        Gabowatdago gabowatdagoEntity = gabowatdagoRepository.findById(id).orElse(null);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetail userDetail = (UserDetail) auth.getPrincipal();
        String gaId = userDetail.getUser().getGaId(); // 로그인한사람 gaId 가져오기
        String userNick = userDetail.getUser().getGaNick(); // 로그인한 사람 ganick 가져오기
        //모델에 데이터 등록하기
        model.addAttribute("gabowatdago", gabowatdagoEntity);
        model.addAttribute("userNick", userNick);
        model.addAttribute("gaId", gaId);
        //뷰 페이지 설정하기
        return "private/gabowatdago/gabowatdago_edit";
    }

    @Transactional
    public String update(GabowatdagoForm form){
        //1. dto를 엔티티로 변환하기
        Gabowatdago gabowatdagoEntity = form.toEntity();
        //2. 엔티티 db 저장하기
        //2-1 . db에서 기존 데이터 가져오기
        Gabowatdago target = gabowatdagoRepository.findById(gabowatdagoEntity.getId()).orElse(null);

        //2-2 . 기존 데이터 값 갱신하기
        if(target != null){
            gabowatdagoRepository.save(gabowatdagoEntity); //엔티티를 db에 저장(갱신)
        }
        //3. 수정 결과 페이지로 리다이렉트하기
        return "redirect:/gabowatdago/"+gabowatdagoEntity.getId();
    }

    @Transactional
    public String delete(@PathVariable("id") Long id){
        //1. 삭제 대상 가져오기
        Gabowatdago target = gabowatdagoRepository.findById(id).orElse(null);
        //2. 대상 엔티티 삭제하기
        if(target != null){
            gabowatdagoRepository.delete(target);
        }
        return "redirect:/gabowatdago";
    }


//    public String getAuthorNickname(Long gabowatdagoId) {
//        Gabowatdago gabowatdago = gabowatdagoRepository.findById(gabowatdagoId).orElse(null);
//        if (gabowatdago != null && gabowatdago.getUserCode() != null) {
//            return gabowatdago.getUserCode().getGaNick();
//        }
//        return null;
//    }
}