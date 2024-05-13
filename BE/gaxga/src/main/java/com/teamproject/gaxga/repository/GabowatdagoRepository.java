package com.teamproject.gaxga.repository;

import com.teamproject.gaxga.entity.Gabowatdago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public interface GabowatdagoRepository extends JpaRepository<Gabowatdago, Long> {
    @Override
    ArrayList<Gabowatdago> findAll();

//    @Query(value = "SELECT title FROM Gabowatdago ORDER BY likeCount DESC", nativeQuery = true)
//    List<Gabowatdago> findByOrderByLikeCount();
}
