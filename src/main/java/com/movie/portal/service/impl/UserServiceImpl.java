package com.movie.portal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.portal.auth.user.AuthenticatedUser;
import com.movie.portal.entity.Movie;
import com.movie.portal.entity.User;
import com.movie.portal.repository.UserRepository;
import com.movie.portal.service.AuthenticationUserService;
import com.movie.portal.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepository;
    
 
    
    @Autowired
    private AuthenticationUserService authenticatedUserService;

    @Override
    public User findUserByEmail(final String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public User findUserByEmailAndPassword(final String email, final String password) {
        return userRepository.findUserByEmailAndPassword(email, password);
    }
    
    
    @Override
    public User getAuthenticatedUserProfile() {
        AuthenticatedUser authUser = authenticatedUserService.getAuthenticatedUser();
        if(authUser != null){
            return userRepository.findOne(authUser.getUser().getId());
        }
        return null;
    }

    @Override
    public List<User> findUsersByMovie(Movie movie) {
        return userRepository.findUsersByMovie(movie);
    }

    @Override
    public void subscribeUser(User user) {
        userRepository.save(user);
    }


    
    
 
    


}
