package com.teamproject.gaxga.dto;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class JoinMembershipForm {
    private Long userCode;
    private String gaId;
    private String gaPass;
    private String gaName;
    private String gaNick;
    private String gaPhone;
    private String gaAddress;
    private String gaDetailAddress;
    private String gaEmail;
    private String gaP_Image;
}
