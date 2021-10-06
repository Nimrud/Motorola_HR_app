package com.example.Motorola_HR_app.security.registration;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;
    private AppUserRepository appUserRepository;

    public void register(AppUserDto request) {
        appUserService.signUpUser(
                new AppUser(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        request.getRole()

                ));

    }

    public List<AppUser> findAll(){
        return appUserRepository.findAll();
    }

    public Optional<AppUser> findByEmail(String email){
        return appUserRepository.findByEmail(email);
    }



}
