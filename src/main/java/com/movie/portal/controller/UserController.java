package com.movie.portal.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movie.portal.entity.Movie;
import com.movie.portal.entity.MoviePurchase;
import com.movie.portal.entity.User;
import com.movie.portal.service.MoviePurchasesService;
import com.movie.portal.service.MovieService;
import com.movie.portal.service.UserService;


/**
 * Handles requests for the application home page.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private MovieService movieService;
    
    @Autowired
    private MoviePurchasesService moviePurchasesService;
    
    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public User profile() {
        return userService.getAuthenticatedUserProfile();
    }
    
    
    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/profile/movies", method = RequestMethod.GET)
    public List<Movie> movies() {
        return movieService.findMoviesByUser(userService.getAuthenticatedUserProfile());
    }
    
    /**
     * Used to subscribe move to subscriber.
     */
    @RequestMapping(value = "/profile/movie/subcribe/", method = RequestMethod.POST)
    public void movieSubscriberSubscribe(@RequestBody Movie movie) {
        moviePurchasesService.subscribeMovieToRegisteredUser(movie);
    }
    
    
    
    /**
     * Used to subscribe move to subscriber.
     */
    @RequestMapping(value = "/movie/subcribe", method = RequestMethod.POST)
    public void movieSubscribe(@RequestBody  MoviePurchase moviePurchase) {
        moviePurchasesService.subscribeMovieToNonRegisteredUser(moviePurchase);
    }
    
    
    /**
     * Used to subscribe move to subscriber.
     */
    @RequestMapping(value = "/subcribe", method = RequestMethod.POST)   
    public void movieSubscribe(@RequestBody  User user) {
       userService.subscribeUser(user);
    }
    
}
