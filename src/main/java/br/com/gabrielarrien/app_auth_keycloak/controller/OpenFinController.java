package br.com.gabrielarrien.app_auth_keycloak.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/openfin")
public class OpenFinController {

    @GetMapping("/termsandconditions")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public String list(){
        return "Terms and Conditions";
    }

    @GetMapping("/termsandconditions/organisations")
    @PreAuthorize("hasRole('ADMIN')")
    public String create(){
        return "Terms and Conditions for Organisations";
    }
}
