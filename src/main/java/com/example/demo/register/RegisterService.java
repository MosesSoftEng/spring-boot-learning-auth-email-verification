package com.example.demo.register;

import com.example.demo.appuser.AppUser;
import com.example.demo.appuser.UserRole;
import com.example.demo.appuser.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegisterService {
    private final UserService userService;
    /*
     * For email validation.
     */
    private final EmailValidator emailValidator;

    public String register(RegisterRequest registerRequest) {
        boolean isEmailValid = emailValidator.test(registerRequest.getEmail());

        if (!isEmailValid) {
            throw new IllegalStateException("email is not valid");
        }

        return userService.registerUser(
                new AppUser(
                        registerRequest.getFirstName(),
                        registerRequest.getLastName(),
                        registerRequest.getEmail(),
                        registerRequest.getPassword(),
                        UserRole.USER
                )
        );
    }
}
