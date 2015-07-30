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
public interface UserRepository extends JpaRepository<User, Integer> {
    /**
     * 
     * @param email String
     * @return User
     */
    User findUserByEmail(String email);

    /**
     * 
     * @param email String  
     * @param password String
     * @return User
     */
    User findUserByEmailAndPassword(String email, String password);
    
    /**
     * 
     * @param user 
     * @return
     */
    @Query("select u from User u  join u.moviePurchases mp where mp.movie = :movie")
    List<User> findUsersByMovie(@Param("movie") Movie movie);
    
}
