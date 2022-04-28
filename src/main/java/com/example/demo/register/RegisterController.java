package com.example.demo.register;
/*
 *  User registration business layer.
 */

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

//* Annotations
@RestController //  For making restful web services.
@RequestMapping(path = "api/v1.0/register") // Maps web requests onto specific handler classes and/or handler methods
@AllArgsConstructor // Auto generate an all argument constructor.

public class RegisterController {
    private final RegisterService registerService;

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

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token){
        return registerService.confirmToken(token);
    }
}
