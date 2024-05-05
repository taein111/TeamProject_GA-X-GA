package com.teamproject.gaxga.service;

import com.sun.jdi.request.DuplicateRequestException;
import com.teamproject.gaxga.dto.LikeDto;
import com.teamproject.gaxga.entity.Gabowatdago;
import com.teamproject.gaxga.entity.Like;
import com.teamproject.gaxga.entity.User;
import com.teamproject.gaxga.repository.GabowatdagoRepository;
import com.teamproject.gaxga.repository.LikeRepository;
import com.teamproject.gaxga.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeService {
    private final LikeRepository likeRepository;
    private final GabowatdagoRepository gabowatdagoRepository;
    private final UserRepository userRepository;

    //전달받은 userId와 gabowatdagoId를 통해 member와 board를 조회하고 저장 혹은 삭제를 진행
    //좋아요 추가 메서드
    @Transactional
    public void insert(LikeDto likeDto) throws Exception {
        Gabowatdago gabowatdago = gabowatdagoRepository.findById(likeDto.getGabowatdagoId())
                .orElseThrow(() -> new Exception("Gabowatdago not found: " + likeDto.getGabowatdagoId()));
        User user = userRepository.findById(likeDto.getUserId())
                .orElseThrow(() -> new Exception("User not found:" + likeDto.getUserId()));
        //이미 좋아요 있으면 에러 반환
        if(likeRepository.findByGabowatdagoAndUser(gabowatdago, user).isPresent()){
            throw new DuplicateRequestException("already exist data my user id : " + user.getGaId()
            + " ," + "gabowatdago id : " + gabowatdago.getId());
        }
        Like like = Like.builder()
                .gabowatdago(gabowatdago)
                .user(user)
                .build();
        likeRepository.save(like);
    }

    @Transactional
    public void delete(LikeDto likeDto) throws Exception {
        User user = userRepository.findById(likeDto.getUserId())
                .orElseThrow(() -> new Exception("Could not found User id : " + likeDto.getUserId()));

        Gabowatdago gabowatdago = gabowatdagoRepository.findById(likeDto.getGabowatdagoId())
                .orElseThrow(() -> new Exception("Could not found Gabowtdago id : " + likeDto.getGabowatdagoId()));

        Like like = likeRepository.findByGabowatdagoAndUser(gabowatdago, user)
                        .orElseThrow(() -> new Exception("Could not found like id"));

        likeRepository.delete(like);
    }



}
