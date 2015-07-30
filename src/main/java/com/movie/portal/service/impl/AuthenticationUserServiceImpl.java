package com.movie.portal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.movie.portal.auth.user.AuthenticatedUser;
import com.movie.portal.entity.User;
import com.movie.portal.service.AuthenticationUserService;
import com.movie.portal.service.UserService;

@Service
public class AuthenticationUserServiceImpl implements UserDetailsService, AuthenticationUserService {

    @Autowired
    private UserService userService;
    
    /**
     * @param userName String
     * @return UserDetails
     * @throws  UsernameNotFoundException Exception
     * 
     */
    @Override
    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException {
        User user = userService.findUserByEmail(userName);
        if (user == null) {
            throw new UsernameNotFoundException("UserName " + userName + " not found");
        }
        return new AuthenticatedUser(user);
    }
    
    
    /**
     * 
     * @return  authenticated user 
     */
    @Override
    public AuthenticatedUser getAuthenticatedUser(){
         try{
             return  ((AuthenticatedUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
         } catch (Exception ex) {
             return null;
         }
    }

}
