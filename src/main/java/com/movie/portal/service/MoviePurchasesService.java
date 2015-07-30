package com.movie.portal.service;

import java.util.List;

import com.movie.portal.entity.Movie;
import com.movie.portal.entity.MoviePurchase;
import com.movie.portal.entity.User;

public interface MoviePurchasesService {
    /**
     * 
     * @param user
     *            object
     * @return MoviePurchases
     */
    List<MoviePurchase> findAllByUser(User user);

    /**
     * 
     * @param movie
     *            object
     * @return MoviePurchases
     */
    List<MoviePurchase> findAllByMovie(Movie movie);
    
    /**
     * 
     */
    void subscribeMovieToRegisteredUser(Movie movie);
    
    /**
     * 
     */
    void subscribeMovieToNonRegisteredUser(MoviePurchase moviePurchase);
}
