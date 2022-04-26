package com.example.demo.register;
/*
 *  User registration business layer.
 */

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//* Annotations
@RestController //  For making restful web services.
@RequestMapping(path = "api/v1.0/register") // Maps web requests onto specific handler classes and/or handler methods
@AllArgsConstructor // Auto generate an all argument constructor.

public class RegisterController {
    RegisterService registerService;

    /*
     * Constructor or use lombock.
     */

    /**
     * User register endpoint.
     */
    @PostMapping
    public String register(
            @RequestBody
                    RegisterRequest registerRequest // The structure of the request.
    ){
        return registerService.register(registerRequest);
    }
}
