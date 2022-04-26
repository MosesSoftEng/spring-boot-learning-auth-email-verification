package com.example.demo.register.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {

    private final ConfirmationTokenRepository confirmationTokenRepository;

    /**
     * Save token
     * @param token
     */
    public void saveConfirmationToken(ConfirmationToken token){
        confirmationTokenRepository.save(token);
    }
}
