package com.teamproject.gaxga.repository.gabojago;

import com.teamproject.gaxga.entity.User;
import com.teamproject.gaxga.entity.gabojago.GP;
import com.teamproject.gaxga.entity.gabojago.Jjim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface JjimRepository extends JpaRepository<Jjim, Long> {

    Optional<Jjim> findByGpidAndUser(GP gp,User user);

}