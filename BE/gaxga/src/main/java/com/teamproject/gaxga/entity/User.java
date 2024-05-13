package com.teamproject.gaxga.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "users")
@Getter
@Setter
@Entity
public class User{
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

    public void patch(User user){
        if(user.gaId != null){
            this.gaId = user.gaId;
        }
        if(user.gaPass != null){
            this.gaPass = user.gaPass;
        }
        if(user.gaNick != null){
            this.gaNick = user.gaNick;
        }
        if(user.gaPhone != null){
            this.gaPhone = user.gaPhone;
        }
        if(user.gaAddress != null){
            this.gaAddress = user.gaAddress;
        }
        if(user.gaDetailAddress != null){
            this.gaDetailAddress = user.gaDetailAddress;
        }
        if(user.gaEmail != null){
            this.gaEmail = user.gaEmail;
        }
        if(user.gaP_Image != null){
            this.gaP_Image = user.gaP_Image;
        }
    }
}
