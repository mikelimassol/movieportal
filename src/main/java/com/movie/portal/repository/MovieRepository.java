package com.movie.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.movie.portal.entity.Movie;
import com.movie.portal.entity.User;

/**
 * 
 * @author Michael Papamichael
 *
 */
@Repository
public interface  MovieRepository extends  JpaRepository<Movie, Integer>{
   
    @Query("select m from Movie m  join m.moviePurchases mp where mp.user = :user ")
    List<Movie> findMoviesByUser(@Param("user") User user);

}
