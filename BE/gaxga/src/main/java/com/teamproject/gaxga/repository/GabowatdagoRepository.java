package com.teamproject.gaxga.repository;

import com.teamproject.gaxga.entity.Gabowatdago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface GabowatdagoRepository extends JpaRepository<Gabowatdago, Long> {
    @Override
    ArrayList<Gabowatdago> findAll();

    @Query(value = "SELECT * FROM Gabowatdago ORDER BY like_Count DESC", nativeQuery = true)
    List<Gabowatdago> findByUserCode_UserCode(Long gabowatdagoWriter);

//    @Query(value = "SELECT title FROM Gabowatdago ORDER BY likeCount DESC", nativeQuery = true)
//    List<Gabowatdago> findByOrderByLikeCount();
}
