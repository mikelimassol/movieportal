package com.movie.portal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.movie.portal.entity.Movie;
import com.movie.portal.entity.User;

/**
 * 
 * @author Michael Papamichael
 *
 */
public interface MovieService {
    
    /**
     * 
     * @return a list of all the movies in the database
     */
    List<Movie> findAll();
    
    /**
     * 
     * @param user of whom movies to be found
     * @return list of movies
     */
    List<Movie> findMoviesByUser(User user);
    

}
