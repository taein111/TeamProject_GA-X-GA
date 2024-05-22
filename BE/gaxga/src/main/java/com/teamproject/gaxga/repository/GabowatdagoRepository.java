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

    //특정 기간기준 이벤트 당첨자
    @Query(value = "SELECT * FROM (SELECT g.*, ROW_NUMBER() OVER (ORDER BY g.like_Count DESC) as rn FROM gabowatdago g WHERE g.reg_Date BETWEEN TO_TIMESTAMP('2024-05-22 00:00:00.000', 'YYYY-MM-DD HH24:MI:SS.FF3') AND TO_TIMESTAMP('2024-05-31 23:59:59.999', 'YYYY-MM-DD HH24:MI:SS.FF3')) WHERE rn <= 3", nativeQuery = true)
    List<Gabowatdago> findTop3ByLikeCountAndDateRange();

    List<Gabowatdago> findByGaNick(String gaNick);
/*

COALESCE는 "코얼레스크"라고 읽음.
COALESCE 함수는 SQL에서 사용되며, 주어진 표현식들 중에서 첫 번째로 NULL이 아닌 값을 반환.
예를 들어, COALESCE(column1, column2, 0)는 column1이 NULL이 아니면 column1의 값을 반환,
NULL이면 column2의 값을 반환하며, 둘 다 NULL이면 0을 반환

*/

/*
TO_TIMESTAMP : 문자열을 타임 스탬프로 변환한다.
'YYYY-MM-DD HH24:MI:SS.FF3' 포맷은 년도, 월, 일, 시간, 분, 초, 및 밀리초(3자리)를 나타낸다.
이 함수는 지정된 기간의 시작과 끝을 정확히 표현하여, 해당 기간에 등록된 게시글만 필터링한다.
기존에 TO_DATE를 썼었는데, 이는 regDate의 날짜-시간 포맷과 일치하지않아 TO_TIMESTAMP로 바꿨다

ROW_NUMBER() 윈도우 함수 :
ROW_NUMBER() OVER(ORDER BY g.like_Count DESCC) 는 like_Count 필드의 내림차순으로
각 행에 순서 번호를 할당한다.
이 함수로 인해 각 게시글에 대해 좋아요 수에 따라 순위를 매기고, 이 순위를 rn이라는 새로운 열에 저장한다.

 */

    //이벤트 당첨자
//    @Query(value = "SELECT * FROM (SELECT g.* FROM gabowatdago g ORDER BY g.like_Count DESC) WHERE ROWNUM <= 3", nativeQuery = true)
//    List<Gabowatdago> findTop3ByLikeCount();
}
