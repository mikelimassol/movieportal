package com.movie.portal.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.movie.portal.auth.user.AuthenticatedUser;
import com.movie.portal.entity.Movie;
import com.movie.portal.entity.User;
import com.movie.portal.repository.MovieRepository;
import com.movie.portal.service.AuthenticationUserService;


/**
 * 
 * @author Michael Papamichael
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class MovieServiceImplTest {
    
    
    @InjectMocks
    MovieServiceImpl service = new MovieServiceImpl();
    
    @Mock
    private MovieRepository movieRepository;
    
    @Mock
    private AuthenticationUserService userService;
    
    private List<Movie> movies;
   
    /**
     * 
     */
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        setObjects();
    }
    
    @Test
    public void shouldFinAllAndSetDiscountedPrices(){
        when(userService.getAuthenticatedUser()).thenReturn(new AuthenticatedUser());
        when(movieRepository.findAll()).thenReturn(movies);
        
        List<Movie> moviesList =  service.findAll();
        
        assertEquals(movies.get(0).getDiscountedPrice(), moviesList.get(0).getPrice());
        verify(movieRepository, times(1)).findAll();
        verify(userService, times(1)).getAuthenticatedUser();
       
    }
    
    @Test
    public void shouldFinAllAndNotSetDiscountedPrices(){
        when(userService.getAuthenticatedUser()).thenReturn(null);
        when(movieRepository.findAll()).thenReturn(movies);
        
        List<Movie> moviesList =  service.findAll();
        
        assertEquals(movies.get(0).getPrice(), moviesList.get(0).getPrice());
        verify(movieRepository, times(1)).findAll();
        verify(userService, times(1)).getAuthenticatedUser();
       
    }
    
    
    @Test
    public void shouldFindMoviesByUser(){
        when(movieRepository.findMoviesByUser(Matchers.any(User.class))).thenReturn(movies);
        List<Movie> movies =  service.findMoviesByUser(new User());
        verify(movieRepository, times(1)).findMoviesByUser(Matchers.any(User.class));
    }
    
    public void setObjects(){
        movies = new ArrayList<Movie>();
        Movie movie = new Movie();
        movie.setTitle("Back To the Future");
        movie.setPrice(10.00);
        movie.setDiscountedPrice(8.00);
        movies.add(movie);
       
    }
    
}
