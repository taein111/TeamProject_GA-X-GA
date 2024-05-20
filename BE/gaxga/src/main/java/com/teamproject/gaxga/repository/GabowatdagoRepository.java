package com.teamproject.gaxga.repository;

import com.teamproject.gaxga.entity.Gabowatdago;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface GabowatdagoRepository extends JpaRepository<Gabowatdago, Long> {
    @Override
    ArrayList<Gabowatdago> findAll();


    List<Gabowatdago> findByUserCode_UserCode(Long gabowatdagoWriter);

//    @Query(value = "SELECT title FROM Gabowatdago ORDER BY likeCount DESC", nativeQuery = true)
//    List<Gabowatdago> findByOrderByLikeCount();
}
