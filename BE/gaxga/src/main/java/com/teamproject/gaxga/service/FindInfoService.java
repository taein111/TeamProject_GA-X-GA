package com.teamproject.gaxga.service;

import com.teamproject.gaxga.entity.User;
import com.teamproject.gaxga.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class FindInfoService {

    @Autowired
    private UserRepository userRepository;

    public User findUserInfoId(User user){
        User data = userRepository.findByGaNickAndGaPhone(user.getGaNick(), user.getGaPhone());
        if(data == null){
            System.out.println("회원정보가 없습니다.");
            return null;
        }else{
            System.out.println("회원정보 ID : " + data.getGaId());
            return data;
        }
    }

    public User findUserInfoPass(User user){
        User data = userRepository.findByGaIdAndGaPhone(user.getGaId(), user.getGaPhone());
        if(data == null){
            System.out.println("아이디나 비밀번호가 틀렸습니다. id :  " +user.getGaId() + ", phone :  " +user.getGaPhone());
            return null;
        }else{
            System.out.println("비밀번호 찾기 임시이메일 발송");
            return data;
        }
    }

//    public void findPassSendEmail() throws Exception{
//        // Mail Server 설정
//        String charSet = "UTF-8";
//        String hostSMTP = "smtp.naver.com";
//        String hostSMTPid = "dlstjs940806@naver.com";
//        String hostSMTPpwd = "wq940806";
//        // 보내는 사람 Email, 제목, 내용
//        String fromEmail = "dlstjs940806@naver.com";
//        String fromName = "GA X GA";
//        String subject = "GA X GA 임시 번호입니다.";
//        String msg = "";
//
//        msg += "<p>임시 비밀번호</p>";
//
//        // 받는 사람 Email 주소
//        String mail = "dlstjs940806@naver.com"; // 사용자로부터 입력받은 이메일 주소로
//        try{
//
//        }
//    }

}
