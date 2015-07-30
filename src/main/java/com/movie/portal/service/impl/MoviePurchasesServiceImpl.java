package com.movie.portal.service.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.portal.auth.user.AuthenticatedUser;
import com.movie.portal.entity.Movie;
import com.movie.portal.entity.MoviePurchase;
import com.movie.portal.entity.User;
import com.movie.portal.repository.MoviePurchasesRepository;
import com.movie.portal.repository.UserRepository;
import com.movie.portal.service.AuthenticationUserService;
import com.movie.portal.service.MoviePurchasesService;
import com.movie.portal.service.UserService;

/**
 * 
 * @author Michael Papamichael
 *
 */
@Service
public class MoviePurchasesServiceImpl implements MoviePurchasesService {
    
    @Autowired
    private MoviePurchasesRepository moviePurchasesRepository;
    
    @Autowired
    private AuthenticationUserService authenticatedUserService;
    
    
    @Autowired
    private UserService userService;
    


    @Override
    public List<MoviePurchase> findAllByUser(User user) {
        return moviePurchasesRepository.findAllByUser(user);
    }

    @Override
    public List<MoviePurchase> findAllByMovie(Movie movie) {
        return moviePurchasesRepository.findAllByMovie(movie);
    }
    
    
    @Override
    public void subscribeMovieToRegisteredUser(Movie movie) {
        AuthenticatedUser authUser = authenticatedUserService.getAuthenticatedUser();
        if(authUser != null){
            Calendar cal = Calendar.getInstance();
            MoviePurchase moviePurchase = new MoviePurchase();
            moviePurchase.setUser(authUser.getUser());
            moviePurchase.setMovie(movie);
            moviePurchase.setPurchasedDate(cal.getTime());
            moviePurchasesRepository.save(moviePurchase);
            moviePurchasesRepository.flush();
        }
    }

    @Override
    public void subscribeMovieToNonRegisteredUser(MoviePurchase moviePurchase) {
        moviePurchasesRepository.save(moviePurchase);
        moviePurchasesRepository.flush();
    }
    
}
