package com.example.hilay_app.util.security;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.nio.file.AccessDeniedException;

public class SecurityUtils {

    public static String getUsername() throws AccessDeniedException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            throw new AccessDeniedException("You must be authenticated to send a message.");
        }

        //get username
        String currentUsername = null;
        if (authentication.getPrincipal() instanceof UserDetails) {
            currentUsername = ((UserDetails) authentication.getPrincipal()).getUsername();
        } else {
            currentUsername = authentication.getName();
        }
        return currentUsername;
    }

}
