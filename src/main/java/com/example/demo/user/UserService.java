package com.example.demo.user;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/*
 * Service to manage login/ register.
 */
@Service // Used with classes that provide some business functionalities.

// * Lombok annotations
@AllArgsConstructor // Auto generate an all argument constructor.
public class UserService implements
        UserDetailsService // Add Spring security service
{
    private final UserRepository userRepository;

    /*
     * Constructor or use lombok
     */

    //! Username is email in this case.
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format("No user with email %s.", email)
                ));
    }
}
