package com.teamproject.gaxga.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long userCode;
    @Column(unique = true, nullable = false)
    private String gaId;
    @Column(nullable = false)
    private String gaPass;
    @Column(nullable = false)
    private String gaNick;
    @Column(nullable = false)
    private String gaPhone;
    @Column(nullable = false)
    private String gaAddress;
    @Column(nullable = false)
    private String gaDetailAddress;
    @Column(nullable = false)
    private String gaEmail;
    @Column
    private String gaP_Image;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return "gaPass";
    }

    @Override
    public String getUsername() {
        return "gaId";
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
