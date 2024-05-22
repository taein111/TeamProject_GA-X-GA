package com.teamproject.gaxga.handler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import java.io.IOException;


public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());

        String errorMsg;

        if (e instanceof BadCredentialsException) {
            errorMsg = "아이디 또는 비밀번호를 틀렸습니다. 다시 확인해주세요.";
        } else{
            errorMsg = "";
        }

        setDefaultFailureUrl("/login/Result" + errorMsg);

        super.onAuthenticationFailure(httpServletRequest, httpServletResponse, e);
        //httpServletResponse.getOutputStream().println(String.format(jsonPayload, e.getMessage(), Calendar.getInstance().getTime()));
    }
}
