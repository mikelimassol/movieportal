package com.movie.portal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.portal.auth.user.AuthenticatedUser;
import com.movie.portal.entity.Movie;
import com.movie.portal.entity.User;
import com.movie.portal.repository.MovieRepository;
import com.movie.portal.service.AuthenticationUserService;
import com.movie.portal.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
    
    @Autowired
    private MovieRepository movieRepository;
    
    @Autowired
    private AuthenticationUserService userService;

    @Override
    public List<Movie> findAll() {
        AuthenticatedUser authUser = userService.getAuthenticatedUser();
        List<Movie> movies = movieRepository.findAll();
      
        if(authUser != null){
            for(Movie movie: movies){
                movie.setDiscountedPriceToPrice();
            }
        }
       
        return movies;
    }

    @Override
    public List<Movie> findMoviesByUser(User user) {
        return movieRepository.findMoviesByUser(user);
    }

}
