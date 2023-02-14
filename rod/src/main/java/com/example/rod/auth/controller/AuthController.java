
package com.example.rod.auth.controller;

import com.example.rod.auth.dto.SigninRequestDto;
import com.example.rod.auth.dto.SignupRequestDto;
import com.example.rod.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signUp(@RequestBody @Validated SignupRequestDto signupRequestDto){
        authService.signUp(signupRequestDto);
    }

    @PostMapping("/signin")
    @ResponseStatus(HttpStatus.OK)
    public void signIn(@RequestBody SigninRequestDto signinRequestDto, HttpServletResponse response){
        authService.signIn(signinRequestDto, response);
    }
}

