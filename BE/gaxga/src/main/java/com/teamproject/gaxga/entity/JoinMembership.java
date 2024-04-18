package com.teamproject.gaxga.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Getter
public class JoinMembership {
    @Id
    @GeneratedValue
    private Long userCode;
    @Column
    private String gaId;
    @Column
    private String gaPass;
    @Column
    private String gaNick;
    @Column
    private String gaPhone;
    @Column
    private String gaAddress;
    @Column
    private String gaDetailAddress;
    @Column
    private String gaEmail;
    @Column
    private String gaP_Image;

}
