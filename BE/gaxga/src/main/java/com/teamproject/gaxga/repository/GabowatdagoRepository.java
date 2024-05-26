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

    //특정 기간기준 이벤트 당첨자 - likeCount 당첨자 : 중복 제거를위해 같은 userCode를 그룹화 todo 왜 새로운 게시글이 만들어지고 좋아요 1위가 되면 출력에서 제외되는지 확인
    @Query(value = "SELECT * FROM (SELECT g.*, ROW_NUMBER() OVER (PARTITION BY g.user_code ORDER BY g.like_count DESC) as rn FROM gabowatdago g WHERE g.reg_date BETWEEN TO_TIMESTAMP('2024-05-22 00:00:00.000', 'YYYY-MM-DD HH24:MI:SS.FF3') AND TO_TIMESTAMP('2024-05-31 23:59:59.999', 'YYYY-MM-DD HH24:MI:SS.FF3')) sub WHERE sub.rn = 1 AND ROWNUM <= 3 ORDER BY sub.like_count DESC", nativeQuery = true)
    List<Gabowatdago> findTop3ByLikeCountAndDateRangeWithoutDuplicateWinners();

    //특정 기간 기준 이벤트 당첨자 - 게시글 수 당첨자 : todo 부적합한 열이름 수정 해야함
    @Query(value = "SELECT * FROM (SELECT user_Code, COUNT(*) as post_count FROM gabowatdago WHERE reg_date BETWEEN TO_TIMESTAMP('2024-05-22 00:00:00.000', 'YYYY-MM-DD HH24:MI:SS.FF3') AND TO_TIMESTAMP('2024-05-31 23:59:59.999', 'YYYY-MM-DD HH24:MI:SS.FF3') GROUP BY user_code ORDER BY post_count DESC) WHERE ROWNUM <= 3", nativeQuery = true)
    List<Gabowatdago> findTop3UsersByPostCount();



    List<Gabowatdago> findByGaNick(String gaNick);
/*

COALESCE는 "코얼레스크"라고 읽음.
COALESCE 함수는 SQL에서 사용되며, 주어진 표현식들 중에서 첫 번째로 NULL이 아닌 값을 반환.
예를 들어, COALESCE(column1, column2, 0)는 column1이 NULL이 아니면 column1의 값을 반환,
NULL이면 column2의 값을 반환하며, 둘 다 NULL이면 0을 반환

*/

/*
*****like 이벤트 당첨자 쿼리문 해석
1. 서브쿼리
ROW_NUMBER() OVER (PARTITION BY g.user_code ORDER BY g.like_count DESC) as rn:
 각 user_code 별로 데이터를 그룹화하고, 그룹 내에서 like_count가 높은 순서대로 순위를 매긴다.
  각 그룹의 가장 높은 like_count를 가진 행은 rn 값이 1이 된다.

TO_TIMESTAMP : 문자열을 타임 스탬프로 변환한다.
'YYYY-MM-DD HH24:MI:SS.FF3' 포맷은 년도, 월, 일, 시간, 분, 초, 및 밀리초(3자리)를 나타낸다.
이 함수는 지정된 기간의 시작과 끝을 정확히 표현하여, 해당 기간에 등록된 게시글만 필터링한다.
기존에 TO_DATE를 썼었는데, 이는 regDate의 날짜-시간 포맷과 일치하지않아 TO_TIMESTAMP로 바꿨다

2. 외부커리
WHERE sub.rn = 1 AND ROWNUM <= 3: 서브쿼리의 결과 중 rn 값이 1인 행, 즉 각 사용자별로 가장 높은 like_count를 가진 행만 선택하고,그 중에서도 상위 3개의 결과만 가져온다.
ORDER BY sub.like_count DESC: 최종적으로 선택된 행들을 like_count의 내림차순으로 정렬한다.

 */

}
