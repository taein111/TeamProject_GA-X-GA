package com.teamproject.gaxga.repository.gabojago;

import com.teamproject.gaxga.entity.gabojago.GP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
public interface GpRepository extends JpaRepository<GP, Long> {
    @Override
    ArrayList<GP> findAll();
    @Query(value ="SELECT R.GRid AS GRid, R.name AS GRname, T.GTid AS GTid, T.name AS GTname, P.GPid AS GPid, P.name AS GPname, P.img AS img, P.state AS state, P.text AS text, P.jjimcount AS jjimCount " +
            "FROM GP P " +
            "JOIN GR R ON R.GRid = P.GRid " +
            "JOIN GT T ON T.GTid = P.GTid " +
            "WHERE R.GRid=1", nativeQuery = true)
    List<GP> findByGangwon();

    @Query(value ="SELECT R.GRid AS GRid, R.name AS GRname, T.GTid AS GTid, T.name AS GTname, P.GPid AS GPid, P.name AS GPname, P.img AS img, P.state AS state, P.text AS text, P.jjimcount AS jjimCount " +
            "FROM GP P " +
            "JOIN GR R ON R.GRid = P.GRid " +
            "JOIN GT T ON T.GTid = P.GTid " +
            "WHERE R.GRid=2", nativeQuery = true)
    List<GP> findByGyeonggi();

    @Query(value ="SELECT R.GRid AS GRid, R.name AS GRname, T.GTid AS GTid, T.name AS GTname, P.GPid AS GPid, P.name AS GPname, P.img AS img, P.state AS state, P.text AS text, P.jjimcount AS jjimCount " +
            "FROM GP P " +
            "JOIN GR R ON R.GRid = P.GRid " +
            "JOIN GT T ON T.GTid = P.GTid " +
            "WHERE R.GRid=3", nativeQuery = true)
    List<GP> findByGyeongnam();

    @Query(value ="SELECT R.GRid AS GRid, R.name AS GRname, T.GTid AS GTid, T.name AS GTname, P.GPid AS GPid, P.name AS GPname, P.img AS img, P.state AS state, P.text AS text, P.jjimcount AS jjimCount " +
            "FROM GP P " +
            "JOIN GR R ON R.GRid = P.GRid " +
            "JOIN GT T ON T.GTid = P.GTid " +
            "WHERE R.GRid=4", nativeQuery = true)
    List<GP> findByGyeongbuk();

    @Query(value ="SELECT R.GRid AS GRid, R.name AS GRname, T.GTid AS GTid, T.name AS GTname, P.GPid AS GPid, P.name AS GPname, P.img AS img, P.state AS state, P.text AS text, P.jjimcount AS jjimCount " +
            "FROM GP P " +
            "JOIN GR R ON R.GRid = P.GRid " +
            "JOIN GT T ON T.GTid = P.GTid " +
            "WHERE R.GRid=5", nativeQuery = true)
    List<GP> findByGwangju();

    @Query(value ="SELECT R.GRid AS GRid, R.name AS GRname, T.GTid AS GTid, T.name AS GTname, P.GPid AS GPid, P.name AS GPname, P.img AS img, P.state AS state, P.text AS text, P.jjimcount AS jjimCount " +
            "FROM GP P " +
            "JOIN GR R ON R.GRid = P.GRid " +
            "JOIN GT T ON T.GTid = P.GTid " +
            "WHERE R.GRid=6", nativeQuery = true)
    List<GP> findByDaegu();

    @Query(value ="SELECT R.GRid AS GRid, R.name AS GRname, T.GTid AS GTid, T.name AS GTname, P.GPid AS GPid, P.name AS GPname, P.img AS img, P.state AS state, P.text AS text, P.jjimcount AS jjimCount " +
            "FROM GP P " +
            "JOIN GR R ON R.GRid = P.GRid " +
            "JOIN GT T ON T.GTid = P.GTid " +
            "WHERE R.GRid=7", nativeQuery = true)
    List<GP> findByDaejeon();

    @Query(value ="SELECT R.GRid AS GRid, R.name AS GRname, T.GTid AS GTid, T.name AS GTname, P.GPid AS GPid, P.name AS GPname, P.img AS img, P.state AS state, P.text AS text, P.jjimcount AS jjimCount " +
            "FROM GP P " +
            "JOIN GR R ON R.GRid = P.GRid " +
            "JOIN GT T ON T.GTid = P.GTid " +
            "WHERE R.GRid=8", nativeQuery = true)
    List<GP> findByBusan();

    @Query(value ="SELECT R.GRid AS GRid, R.name AS GRname, T.GTid AS GTid, T.name AS GTname, P.GPid AS GPid, P.name AS GPname, P.img AS img, P.state AS state, P.text AS text, P.jjimcount AS jjimCount " +
            "FROM GP P " +
            "JOIN GR R ON R.GRid = P.GRid " +
            "JOIN GT T ON T.GTid = P.GTid " +
            "WHERE R.GRid=9", nativeQuery = true)
    List<GP> findBySeoul();

    @Query(value ="SELECT R.GRid AS GRid, R.name AS GRname, T.GTid AS GTid, T.name AS GTname, P.GPid AS GPid, P.name AS GPname, P.img AS img, P.state AS state, P.text AS text, P.jjimcount AS jjimCount " +
            "FROM GP P " +
            "JOIN GR R ON R.GRid = P.GRid " +
            "JOIN GT T ON T.GTid = P.GTid " +
            "WHERE R.GRid=10", nativeQuery = true)
    List<GP> findBySejong();

    @Query(value ="SELECT R.GRid AS GRid, R.name AS GRname, T.GTid AS GTid, T.name AS GTname, P.GPid AS GPid, P.name AS GPname, P.img AS img, P.state AS state, P.text AS text, P.jjimcount AS jjimCount " +
            "FROM GP P " +
            "JOIN GR R ON R.GRid = P.GRid " +
            "JOIN GT T ON T.GTid = P.GTid " +
            "WHERE R.GRid=11", nativeQuery = true)
    List<GP> findByUlsan();

    @Query(value ="SELECT R.GRid AS GRid, R.name AS GRname, T.GTid AS GTid, T.name AS GTname, P.GPid AS GPid, P.name AS GPname, P.img AS img, P.state AS state, P.text AS text, P.jjimcount AS jjimCount " +
            "FROM GP P " +
            "JOIN GR R ON R.GRid = P.GRid " +
            "JOIN GT T ON T.GTid = P.GTid " +
            "WHERE R.GRid=12", nativeQuery = true)
    List<GP> findByIncheon();

    @Query(value ="SELECT R.GRid AS GRid, R.name AS GRname, T.GTid AS GTid, T.name AS GTname, P.GPid AS GPid, P.name AS GPname, P.img AS img, P.state AS state, P.text AS text, P.jjimcount AS jjimCount " +
            "FROM GP P " +
            "JOIN GR R ON R.GRid = P.GRid " +
            "JOIN GT T ON T.GTid = P.GTid " +
            "WHERE R.GRid=13", nativeQuery = true)
    List<GP> findByJeonnam();

    @Query(value ="SELECT R.GRid AS GRid, R.name AS GRname, T.GTid AS GTid, T.name AS GTname, P.GPid AS GPid, P.name AS GPname, P.img AS img, P.state AS state, P.text AS text, P.jjimcount AS jjimCount " +
            "FROM GP P " +
            "JOIN GR R ON R.GRid = P.GRid " +
            "JOIN GT T ON T.GTid = P.GTid " +
            "WHERE R.GRid=14", nativeQuery = true)
    List<GP> findByJeonbuk();

    @Query(value ="SELECT R.GRid AS GRid, R.name AS GRname, T.GTid AS GTid, T.name AS GTname, P.GPid AS GPid, P.name AS GPname, P.img AS img, P.state AS state, P.text AS text, P.jjimcount AS jjimCount " +
            "FROM GP P " +
            "JOIN GR R ON R.GRid = P.GRid " +
            "JOIN GT T ON T.GTid = P.GTid " +
            "WHERE R.GRid=15", nativeQuery = true)
    List<GP> findByJeju();

    @Query(value ="SELECT R.GRid AS GRid, R.name AS GRname, T.GTid AS GTid, T.name AS GTname, P.GPid AS GPid, P.name AS GPname, P.img AS img, P.state AS state, P.text AS text, P.jjimcount AS jjimCount " +
            "FROM GP P " +
            "JOIN GR R ON R.GRid = P.GRid " +
            "JOIN GT T ON T.GTid = P.GTid " +
            "WHERE R.GRid=16", nativeQuery = true)
    List<GP> findByChungnam();

    @Query(value ="SELECT R.GRid AS GRid, R.name AS GRname, T.GTid AS GTid, T.name AS GTname, P.GPid AS GPid, P.name AS GPname, P.img AS img, P.state AS state, P.text AS text, P.jjimcount AS jjimCount " +
            "FROM GP P " +
            "JOIN GR R ON R.GRid = P.GRid " +
            "JOIN GT T ON T.GTid = P.GTid " +
            "WHERE R.GRid=17", nativeQuery = true)
    List<GP> findByChungbuk();
}

//    @Query(value ="SELECT R.GRid AS GRid, R.name AS GRname, T.GTid AS GTid, T.name AS GTname, P.GPid AS GPid, P.name AS GPname, P.img AS img, P.state AS state, P.text AS text, U.userCode AS userCode " +
//            "FROM GP P " +
//            "JOIN GR R ON R.GRid = P.GRid " +
//            "JOIN GT T ON T.GTid = P.GTid " +
//            "JOIN USER U ON U.userCode = P.userCode " +
//            "WHERE R.GRid=1", nativeQuery = true)
//    List<GP> findByGangwon();
//
//    @Query(value ="SELECT R.GRid AS GRid, R.name AS GRname, T.GTid AS GTid, T.name AS GTname, P.GPid AS GPid, P.name AS GPname, P.img AS img, P.state AS state, P.text AS text, U.userCode AS userCode " +
//            "FROM GP P " +
//            "JOIN GR R ON R.GRid = P.GRid " +
//            "JOIN GT T ON T.GTid = P.GTid " +
//            "JOIN USER U ON U.userCode = P.userCode " +
//            "WHERE R.GRid=2", nativeQuery = true)
//    List<GP> findByGyeonggi();
//
//    @Query(value ="SELECT R.GRid AS GRid, R.name AS GRname, T.GTid AS GTid, T.name AS GTname, P.GPid AS GPid, P.name AS GPname, P.img AS img, P.state AS state, P.text AS text, U.userCode AS userCode " +
//            "FROM GP P " +
//            "JOIN GR R ON R.GRid = P.GRid " +
//            "JOIN GT T ON T.GTid = P.GTid " +
//            "JOIN USER U ON U.userCode = P.userCode " +
//            "WHERE R.GRid=3", nativeQuery = true)
//    List<GP> findByGyeongnam();
//
//    @Query(value ="SELECT R.GRid AS GRid, R.name AS GRname, T.GTid AS GTid, T.name AS GTname, P.GPid AS GPid, P.name AS GPname, P.img AS img, P.state AS state, P.text AS text, U.userCode AS userCode " +
//            "FROM GP P " +
//            "JOIN GR R ON R.GRid = P.GRid " +
//            "JOIN GT T ON T.GTid = P.GTid " +
//            "JOIN USER U ON U.userCode = P.userCode " +
//            "WHERE R.GRid=4", nativeQuery = true)
//    List<GP> findByGyeongbuk();
//
//    @Query(value ="SELECT R.GRid AS GRid, R.name AS GRname, T.GTid AS GTid, T.name AS GTname, P.GPid AS GPid, P.name AS GPname, P.img AS img, P.state AS state, P.text AS text, U.userCode AS userCode " +
//            "FROM GP P " +
//            "JOIN GR R ON R.GRid = P.GRid " +
//            "JOIN GT T ON T.GTid = P.GTid " +
//            "JOIN USER U ON U.userCode = P.userCode " +
//            "WHERE R.GRid=5", nativeQuery = true)
//    List<GP> findByGwangju();
//
//    @Query(value ="SELECT R.GRid AS GRid, R.name AS GRname, T.GTid AS GTid, T.name AS GTname, P.GPid AS GPid, P.name AS GPname, P.img AS img, P.state AS state, P.text AS text, U.userCode AS userCode " +
//            "FROM GP P " +
//            "JOIN GR R ON R.GRid = P.GRid " +
//            "JOIN GT T ON T.GTid = P.GTid " +
//            "JOIN USER U ON U.userCode = P.userCode " +
//            "WHERE R.GRid=6", nativeQuery = true)
//    List<GP> findByDaegu();
//
//    @Query(value ="SELECT R.GRid AS GRid, R.name AS GRname, T.GTid AS GTid, T.name AS GTname, P.GPid AS GPid, P.name AS GPname, P.img AS img, P.state AS state, P.text AS text, U.userCode AS userCode " +
//            "FROM GP P " +
//            "JOIN GR R ON R.GRid = P.GRid " +
//            "JOIN GT T ON T.GTid = P.GTid " +
//            "JOIN USER U ON U.userCode = P.userCode " +
//            "WHERE R.GRid=7", nativeQuery = true)
//    List<GP> findByDaejeon();
//
//    @Query(value ="SELECT R.GRid AS GRid, R.name AS GRname, T.GTid AS GTid, T.name AS GTname, P.GPid AS GPid, P.name AS GPname, P.img AS img, P.state AS state, P.text AS text, U.userCode AS userCode " +
//            "FROM GP P " +
//            "JOIN GR R ON R.GRid = P.GRid " +
//            "JOIN GT T ON T.GTid = P.GTid " +
//            "JOIN USER U ON U.userCode = P.userCode " +
//            "WHERE R.GRid=8", nativeQuery = true)
//    List<GP> findByBusan();
//
//    @Query(value ="SELECT R.GRid AS GRid, R.name AS GRname, T.GTid AS GTid, T.name AS GTname, P.GPid AS GPid, P.name AS GPname, P.img AS img, P.state AS state, P.text AS text, U.userCode AS userCode " +
//            "FROM GP P " +
//            "JOIN GR R ON R.GRid = P.GRid " +
//            "JOIN GT T ON T.GTid = P.GTid " +
//            "JOIN USER U ON U.userCode = P.userCode" +
//            "WHERE R.GRid=9", nativeQuery = true)
//    List<GP> findBySeoul();
//
//    @Query(value ="SELECT R.GRid AS GRid, R.name AS GRname, T.GTid AS GTid, T.name AS GTname, P.GPid AS GPid, P.name AS GPname, P.img AS img, P.state AS state, P.text AS text, U.userCode AS userCode " +
//            "FROM GP P " +
//            "JOIN GR R ON R.GRid = P.GRid " +
//            "JOIN GT T ON T.GTid = P.GTid " +
//            "JOIN USER U ON U.userCode = P.userCode" +
//            "WHERE R.GRid=10", nativeQuery = true)
//    List<GP> findBySejong();
//
//    @Query(value ="SELECT R.GRid AS GRid, R.name AS GRname, T.GTid AS GTid, T.name AS GTname, P.GPid AS GPid, P.name AS GPname, P.img AS img, P.state AS state, P.text AS text, U.userCode AS userCode " +
//            "FROM GP P " +
//            "JOIN GR R ON R.GRid = P.GRid " +
//            "JOIN GT T ON T.GTid = P.GTid " +
//            "JOIN USER U ON U.userCode = P.userCode" +
//            "WHERE R.GRid=11", nativeQuery = true)
//    List<GP> findByUlsan();
//
//    @Query(value ="SELECT R.GRid AS GRid, R.name AS GRname, T.GTid AS GTid, T.name AS GTname, P.GPid AS GPid, P.name AS GPname, P.img AS img, P.state AS state, P.text AS text, U.userCode AS userCode " +
//            "FROM GP P " +
//            "JOIN GR R ON R.GRid = P.GRid " +
//            "JOIN GT T ON T.GTid = P.GTid " +
//            "JOIN USER U ON U.userCode = P.userCode" +
//            "WHERE R.GRid=12", nativeQuery = true)
//    List<GP> findByIncheon();
//
//    @Query(value ="SELECT R.GRid AS GRid, R.name AS GRname, T.GTid AS GTid, T.name AS GTname, P.GPid AS GPid, P.name AS GPname, P.img AS img, P.state AS state, P.text AS text, U.userCode AS userCode " +
//            "FROM GP P " +
//            "JOIN GR R ON R.GRid = P.GRid " +
//            "JOIN GT T ON T.GTid = P.GTid " +
//            "JOIN USER U ON U.userCode = P.userCode" +
//            "WHERE R.GRid=13", nativeQuery = true)
//    List<GP> findByJeonnam();
//
//    @Query(value ="SELECT R.GRid AS GRid, R.name AS GRname, T.GTid AS GTid, T.name AS GTname, P.GPid AS GPid, P.name AS GPname, P.img AS img, P.state AS state, P.text AS text, U.userCode AS userCode " +
//            "FROM GP P " +
//            "JOIN GR R ON R.GRid = P.GRid " +
//            "JOIN GT T ON T.GTid = P.GTid " +
//            "JOIN USER U ON U.userCode = P.userCode" +
//            "WHERE R.GRid=14", nativeQuery = true)
//    List<GP> findByJeonbuk();
//
//    @Query(value ="SELECT R.GRid AS GRid, R.name AS GRname, T.GTid AS GTid, T.name AS GTname, P.GPid AS GPid, P.name AS GPname, P.img AS img, P.state AS state, P.text AS text, U.userCode AS userCode " +
//            "FROM GP P " +
//            "JOIN GR R ON R.GRid = P.GRid " +
//            "JOIN GT T ON T.GTid = P.GTid " +
//            "JOIN USER U ON U.userCode = P.userCode" +
//            "WHERE R.GRid=15", nativeQuery = true)
//    List<GP> findByJeju();
//
//    @Query(value ="SELECT R.GRid AS GRid, R.name AS GRname, T.GTid AS GTid, T.name AS GTname, P.GPid AS GPid, P.name AS GPname, P.img AS img, P.state AS state, P.text AS text, U.userCode AS userCode " +
//            "FROM GP P " +
//            "JOIN GR R ON R.GRid = P.GRid " +
//            "JOIN GT T ON T.GTid = P.GTid " +
//            "JOIN USER U ON U.userCode = P.userCode" +
//            "WHERE R.GRid=16", nativeQuery = true)
//    List<GP> findByChungnam();
//
//    @Query(value ="SELECT R.GRid AS GRid, R.name AS GRname, T.GTid AS GTid, T.name AS GTname, P.GPid AS GPid, P.name AS GPname, P.img AS img, P.state AS state, P.text AS text, U.userCode AS userCode " +
//            "FROM GP P " +
//            "JOIN GR R ON R.GRid = P.GRid " +
//            "JOIN GT T ON T.GTid = P.GTid " +
//            "JOIN USER U ON U.userCode = P.userCode" +
//            "WHERE R.GRid=17", nativeQuery = true)
//    List<GP> findByChungbuk();
