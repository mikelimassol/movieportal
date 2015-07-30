package com.movie.portal.service.impl;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

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
import com.movie.portal.entity.MoviePurchase;
import com.movie.portal.entity.User;
import com.movie.portal.repository.MoviePurchasesRepository;
import com.movie.portal.service.AuthenticationUserService;
import com.movie.portal.service.UserService;


/**
 * 
 * @author Michael Papamichael
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class MoviePurchasesServiceImplTest {
    
    @InjectMocks
    MoviePurchasesServiceImpl service = new MoviePurchasesServiceImpl();
    
    @Mock
    private MoviePurchasesRepository moviePurchasesRepository;
    
    @Mock
    private AuthenticationUserService authenticatedUserService;
    
    
    @Mock
    private UserService userService;
    
   
    /**
     * 
     */
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void shouldFindAllByUserTest(){
        when(moviePurchasesRepository.findAllByUser(Matchers.any(User.class))).thenReturn(new ArrayList<MoviePurchase>());
        service.findAllByUser(new User());
        verify(moviePurchasesRepository, times(1)).findAllByUser(Matchers.any(User.class));
    }
    
    @Test
    public void shouldFindAllByMovieTest(){
        when(moviePurchasesRepository.findAllByMovie(Matchers.any(Movie.class))).thenReturn(new ArrayList<MoviePurchase>());
        service.findAllByMovie(new Movie());
        verify(moviePurchasesRepository, times(1)).findAllByMovie(Matchers.any(Movie.class));
    }
    
    
    @Test
    public void shouldSubscribeMovieToRegisteredUser(){
        when(authenticatedUserService.getAuthenticatedUser()).thenReturn(new AuthenticatedUser());
        service.subscribeMovieToRegisteredUser(new Movie());
        verify(moviePurchasesRepository, times(1)).save(Matchers.any(MoviePurchase.class));
        verify(moviePurchasesRepository, times(1)).flush();
    }
    
    @Test
    public void shouldNotSubscribeMovieToRegisteredUser(){
        when(authenticatedUserService.getAuthenticatedUser()).thenReturn(null);
        service.subscribeMovieToRegisteredUser(new Movie());
        verifyZeroInteractions(moviePurchasesRepository);
    }
    
    
    @Test
    public void shouldSubscribeMovieToNonRegisteredUser(){
        service.subscribeMovieToNonRegisteredUser(new MoviePurchase()); 
        verify(moviePurchasesRepository, times(1)).save(Matchers.any(MoviePurchase.class));
        verify(moviePurchasesRepository, times(1)).flush();
    }
    
}
