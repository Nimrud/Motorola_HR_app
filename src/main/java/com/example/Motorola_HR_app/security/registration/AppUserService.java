package com.example.Motorola_HR_app.security.registration;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    private final AppUserRepository repository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return repository
                .findByEmail(email)
                .orElseThrow(()->
                        new UsernameNotFoundException(
                                "User with email " + email + " not found"));
    }

    public void signUpUser(AppUser appUser){
        boolean userExists = repository
                .findByEmail(appUser.getEmail())
                .isPresent();

        if(userExists){
            throw new IllegalStateException("User already exists");
        }

        String encodedPassword = passwordEncoder
                .encode(appUser.getPassword());
        appUser.setPassword(encodedPassword);
        repository.save(appUser);
    }

    public AppUser getLoggedUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AppUser loggedUser = (AppUser) authentication.getPrincipal();
        return loggedUser;
    }


}
