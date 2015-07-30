package com.movie.portal.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.movie.portal.entity.Movie;
import com.movie.portal.entity.User;

public interface UserService {

    /**
     * 
     * @param email
     *            String
     * @return User
     */
    User findUserByEmail(String email);

    /**
     * 
     * @param email
     *            String
     * @param password
     *            String
     * @return User
     */
    User findUserByEmailAndPassword(String email, String password);

    /**
     * 
     * @return authenticated Users profile
     */
    User getAuthenticatedUserProfile();

    /**
     * 
     * @param movie
     *            to filter users from
     * @return list of Users
     */
    List<User> findUsersByMovie(Movie movie);
    
    /**
     * 
     */
    void subscribeUser(User user);

}
