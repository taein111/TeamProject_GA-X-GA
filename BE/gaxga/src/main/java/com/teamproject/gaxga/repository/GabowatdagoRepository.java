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

    //마이페이지 나의 베스트 게시글
    @Query(value = "SELECT COALESCE(SUM(g.like_Count), 0) FROM gabowatdago g WHERE g.user_Code = :userCode", nativeQuery = true)
    Long sumLikeCountByUserCode(@Param("userCode") Long userCode);

    //특정 기간기준 이벤트 당첨자 - likeCount 당첨자 : 중복 제거를위해 같은 userCode를 그룹화했으며,  당첨자 중에 like카운트가 동일한 유저가 있을 경우 먼저 게시글을 등록한 사람이 당첨되도록 선정한다.
    @Query(value = "SELECT * FROM " +
            "(SELECT sub.*, ROWNUM rnum FROM " +
            "(SELECT g.*, ROW_NUMBER() OVER (PARTITION BY g.user_code ORDER BY g.like_count DESC, g.reg_date ASC) as rn FROM " +
            "gabowatdago g WHERE g.reg_date BETWEEN TO_TIMESTAMP('2024-05-22 00:00:00.000', 'YYYY-MM-DD HH24:MI:SS.FF3') AND TO_TIMESTAMP('2024-05-31 23:59:59.999', 'YYYY-MM-DD HH24:MI:SS.FF3') " +
            "ORDER BY g.like_count DESC, g.reg_date ASC) sub WHERE sub.rn = 1) WHERE rnum <= 3", nativeQuery = true)
    List<Gabowatdago> findTop3ByLikeCountAndDateRangeWithoutDuplicateWinners();

    //특정 기간 기준 이벤트 당첨자 - 게시글 수 당첨자 :
    @Query(value = "SELECT g.gaNick, COUNT(g) AS postCount FROM Gabowatdago g GROUP BY g.gaNick ORDER BY postCount DESC")
    List<Object[]> findTop3UsersByPostCountIncludingNick();


    List<Gabowatdago> findByGaNick(String gaNick);
/*

COALESCE는 "코얼레스크"라고 읽음.
COALESCE 함수는 SQL에서 사용되며, 주어진 표현식들 중에서 첫 번째로 NULL이 아닌 값을 반환.
예를 들어, COALESCE(column1, column2, 0)는 column1이 NULL이 아니면 column1의 값을 반환,
NULL이면 column2의 값을 반환하며, 둘 다 NULL이면 0을 반환

*/

/*
*****like 이벤트 당첨자 쿼리문 해석
 1. 내부 서브쿼리(가장 안쪽 쿼리)
SELECT g.*, ROW_NUMBER() OVER (PARTITION BY g.user_code ORDER BY g.like_count DESC, g.reg_date ASC) as rn
FROM gabowatdago g
WHERE g.reg_date BETWEEN TO_TIMESTAMP('2024-05-22 00:00:00.000', 'YYYY-MM-DD HH24:MI:SS.FF3')
AND TO_TIMESTAMP('2024-05-31 23:59:59.999', 'YYYY-MM-DD HH24:MI:SS.FF3')
    - gabowatdago 테이블에서 지정된 날짜 범위 내의 모든 게시물을 선택
    - ROW_NUMBER(): 각 user_code별로 like_count가 높은 순서대로 순위를 매긴다. like_count가 같을 경우, reg_date가 빠른 게시물이 우선 순위를 갖는다
    - 결과: 각 게시물에는 사용자 코드별로 순위(rn)가 매겨진다.

 2. 중간 서브쿼리
SELECT sub.*, ROWNUM rnum
FROM (...) sub
WHERE sub.rn = 1
    - 목적: 가장 안쪽 쿼리의 결과에서 각 사용자별로 like_count가 가장 높은 게시물(즉, rn = 1인 게시물)만을 선택
    - ROWNUM: 오라클에서 결과의 순서에 따라 각 행에 고유 번호를 부여

 3. 외부 커리
SELECT *
FROM (...)
WHERE rnum <= 3
    - 목적: 중간 서브쿼리의 결과에서 ROWNUM이 3 이하인 행만을 선택하여, 전체적으로 like_count가 가장 높은 상위 3개의 게시물을 최종적으로 반환
    - 결과: 최종 사용자에게 보여질 데이터는 각 사용자별로 like_count가 가장 높은 게시물 중에서 전체적으로 상위 3개의 게시물이다.


 */

}
