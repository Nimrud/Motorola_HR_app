//package com.example.Motorola_HR_app.security.registration;
//
//import lombok.AllArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/v1/registration")
//@AllArgsConstructor
//public class RegistrationController {
//
//    private final RegistrationService registrationService;
//
//    @PostMapping()
//    public ResponseEntity<Void> addUser(@RequestBody AppUserDto user){
//        Optional<AppUser> exists = registrationService.findByEmail(user.getEmail());
//        if(exists.isEmpty()){
//            registrationService.register(user);
//            return new ResponseEntity<Void>(HttpStatus.CREATED);
//
//        }
//        return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//    }
//
//    @GetMapping()
//    public List<AppUser> findAll(){
//        return registrationService.findAll();
//    }
//
//}
