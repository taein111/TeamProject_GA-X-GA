package com.teamproject.gaxga.repository;

import com.teamproject.gaxga.entity.Gabowatdago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface GabowatdagoRepository extends JpaRepository<Gabowatdago, Long> {
    @Override
    ArrayList<Gabowatdago> findAll();

    List<Gabowatdago> findByUserCode_UserCode(Long gabowatdagoWriter);

    List<Gabowatdago> findByUserCode_UserCodeOrderByLikeCountDesc(Long gabowatdagoWriter);

    @Query(value = "SELECT COALESCE(SUM(g.like_Count), 0) FROM gabowatdago g WHERE g.user_Code = :userCode", nativeQuery = true)
    Long sumLikeCountByUserCode(@Param("userCode") Long userCode);
/*

COALESCE는 "코얼레스크"라고 읽음.
COALESCE 함수는 SQL에서 사용되며, 주어진 표현식들 중에서 첫 번째로 NULL이 아닌 값을 반환.
예를 들어, COALESCE(column1, column2, 0)는 column1이 NULL이 아니면 column1의 값을 반환,
NULL이면 column2의 값을 반환하며, 둘 다 NULL이면 0을 반환

*/

}
