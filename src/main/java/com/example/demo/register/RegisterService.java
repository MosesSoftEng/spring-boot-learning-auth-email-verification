package com.example.demo.register;

import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    public String register(RegisterRequest registerRequest) {
        return "it works";
    }
}