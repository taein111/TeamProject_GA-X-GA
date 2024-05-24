package com.teamproject.gaxga.service;

import com.teamproject.gaxga.entity.User;
import com.teamproject.gaxga.entity.UserDetail;
import com.teamproject.gaxga.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("username : " + username);
        User userData = userRepository.findByGaId(username);

        if (userData != null) {
            log.info("======userData.toString()) : " + userData.toString());
            return new UserDetail(userData);
        } else {
            log.error("User not found with username: " + username);
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
