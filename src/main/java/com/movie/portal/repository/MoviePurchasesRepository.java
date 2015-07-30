package com.movie.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.movie.portal.entity.Movie;
import com.movie.portal.entity.MoviePurchase;
import com.movie.portal.entity.User;

@Repository
public interface MoviePurchasesRepository extends
        JpaRepository<MoviePurchase, Integer> {

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
   
   
}
