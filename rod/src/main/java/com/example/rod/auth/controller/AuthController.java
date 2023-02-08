
package com.example.rod.auth.controller;

import com.example.rod.auth.dto.SigninRequestDto;
import com.example.rod.auth.dto.SignupRequestDto;
import com.example.rod.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private final AuthService authService;

    @PostMapping("/signup")
    public void signUp(@RequestBody @Validated SignupRequestDto signupRequestDto){
        authService.signUp(signupRequestDto);
    }

    @PostMapping("/signin")
    public void signIn(@RequestBody @Validated SigninRequestDto signinRequestDto){
        authService.signIn(signinRequestDto);
    }
}

