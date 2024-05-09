package com.teamproject.gaxga.repository;


import com.teamproject.gaxga.entity.Gabowatdago;
import com.teamproject.gaxga.entity.Like;
import com.teamproject.gaxga.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findByGabowatdagoAndUser(Gabowatdago gabowatdago, User user);

    @Modifying//update쿼리를 주기 위해서는 Modifying 필요
    @Query(value = "update Gabowatdago g set g.likeCount=g.likeCount+1 where g.likeCount>=0", nativeQuery = true )
    void likeCountAdd();
}
