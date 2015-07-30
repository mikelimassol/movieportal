package com.movie.portal.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movie.portal.entity.Movie;
import com.movie.portal.entity.User;
import com.movie.portal.service.MovieService;
import com.movie.portal.service.UserService;

/**
 * Handles requests for the application home page.
 */
@RestController
public class MovieController {
	
	private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
    private UserService userService;
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
    @RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Movie> movies() {
        return movieService.findAll();
	}
    
    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/movie_users/{id}", method = RequestMethod.GET)
    public List<User> users(@PathVariable final Integer id) {
        return userService.findUsersByMovie(new Movie(id));
    }
	
}
