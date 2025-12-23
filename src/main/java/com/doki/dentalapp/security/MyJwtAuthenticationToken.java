package com.doki.dentalapp.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

public class MyJwtAuthenticationToken extends AbstractAuthenticationToken {

 //   private final String userId;
    private final String username;
    private final String role;
    private final String clinicId;

    public MyJwtAuthenticationToken(
            String username,
            String role,
            String clinicId,
            boolean authenticated
    ) {
        super(List.of(new SimpleGrantedAuthority("ROLE_" + role.toUpperCase())));
        this.username = username;
        this.role = role;
        this.clinicId = clinicId;
        setAuthenticated(authenticated);
    }

    @Override
    public Object getCredentials() {
        return null; // password not needed for JWT
    }

    @Override
    public Object getPrincipal() {
        return username;
    }


    public String getClinicId() {
        return clinicId;
    }

    public String getRole() {
        return role;
    }
}
