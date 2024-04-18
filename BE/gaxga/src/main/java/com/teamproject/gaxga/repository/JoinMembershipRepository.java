package com.teamproject.gaxga.repository;

import com.teamproject.gaxga.entity.JoinMembership;
import org.springframework.data.repository.CrudRepository;

public interface JoinMembershipRepository extends CrudRepository<JoinMembership, Long> {
    boolean existsByGaId(String gaId);
}
