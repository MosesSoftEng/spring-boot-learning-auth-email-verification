package com.example.demo.RegisterController;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/*Lombok annotations*/
@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString

/**
 * define the structure of register request.
 */
public class RegisterRequest {
    private final String firstName, lastName, email, password;

    /*
     * Constructors or lombok
     */

    /*
     * Getters or lombok
     */
}
