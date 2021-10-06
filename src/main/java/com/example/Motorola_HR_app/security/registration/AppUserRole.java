package com.example.Motorola_HR_app.security.registration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AppUserRole {
    USER("USER"),
    ADMIN("ADMIN");

    private String name;

}
