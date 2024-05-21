package com.teamproject.gaxga.repository;

import com.teamproject.gaxga.entity.Gabowatdago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface GabowatdagoRepository extends JpaRepository<Gabowatdago, Long> {
    @Override
    ArrayList<Gabowatdago> findAll();

    List<Gabowatdago> findByUserCode_UserCode(Long gabowatdagoWriter);

    List<Gabowatdago> findByUserCode_UserCodeOrderByLikeCountDesc(Long gabowatdagoWriter);

    Long countLikeCountByUserCode_UserCode(Long gabowatdagoWriter);


}
