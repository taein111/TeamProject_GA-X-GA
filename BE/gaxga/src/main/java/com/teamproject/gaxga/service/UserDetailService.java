package com.teamproject.gaxga.service;

import com.teamproject.gaxga.entity.User;
import com.teamproject.gaxga.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public User loadUserByUsername(String gaId){
        return userRepository.findByGaId(gaId)
                .orElseThrow(() -> new IllegalArgumentException((gaId)));
    }
}
