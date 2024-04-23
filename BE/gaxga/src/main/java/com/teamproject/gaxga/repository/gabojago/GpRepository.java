package com.teamproject.gaxga.repository.gabojago;

import com.teamproject.gaxga.entity.gabojago.GP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GpRepository extends JpaRepository<GP, Long> {
    @Query("SELECT name FROM GP WHERE ")
    List<String> findAllNames();
}
