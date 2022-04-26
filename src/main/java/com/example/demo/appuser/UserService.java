package com.example.demo.appuser;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

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

    /*
     * Register user
     */
    public String registerUser(AppUser appUser) {
        /*
         * Check if user exist.
         */
        boolean userExist = userRepository.findByEmail(appUser.getEmail()).isPresent();
        if (userExist) {
            throw new IllegalStateException("email exist");
        }

        /*
         * Encrypt password.
         */
        String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encodedPassword);

        /*
         * Save user to DB
         */
        userRepository.save(appUser);

        // TODO: 26-Apr-22 Send confirmation token

        return "It works";
    }
}
