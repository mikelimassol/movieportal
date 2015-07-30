package com.movie.portal.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.movie.portal.auth.user.AuthenticatedUser;

public interface AuthenticationUserService {
    
    /**
     * 
     * @return  authenticated user 
     */
    public AuthenticatedUser getAuthenticatedUser();

}
