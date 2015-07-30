package com.movie.portal.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author Michael Papamichael
 *
 */
@Entity
@Table(name = "movie_purchases")
public class MoviePurchase implements Serializable {

    private static final long serialVersionUID = 215735653132984571L;

    private static final Integer PRIME_NUMBNER = 31;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "purchased_date")
    private Date purchasedDate;
    
    @Column(name = "ip_address")
    private String ipAddress;
    
    

    /**
     * @return the id
     */
    public final Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public final void setId(final Integer id) {
        this.id = id;
    }

    /**
     * @return the user
     */
    public final User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public final void setUser(final User user) {
        this.user = user;
    }

    /**
     * @return the movie
     */
    public final Movie getMovie() {
        return movie;
    }

    /**
     * @param movie the movie to set
     */
    public final void setMovie(Movie movie) {
        this.movie = movie;
    }

    /**
     * @return the purchasedDate
     */
    public final Date getPurchasedDate() {
        return purchasedDate;
    }

    /**
     * @param purchasedDate the purchasedDate to set
     */
    public final void setPurchasedDate(final Date purchasedDate) {
        this.purchasedDate = purchasedDate;
    }

    /**
     * @return the ipAddress
     */
    public final String getIpAddress() {
        return ipAddress;
    }

    /**
     * @param ipAddress the ipAddress to set
     */
    public final void setIpAddress(final String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = PRIME_NUMBNER;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result
                + ((ipAddress == null) ? 0 : ipAddress.hashCode());
        result = prime * result + ((movie == null) ? 0 : movie.hashCode());
        result = prime * result
                + ((purchasedDate == null) ? 0 : purchasedDate.hashCode());
        result = prime * result + ((user == null) ? 0 : user.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof MoviePurchase)) {
            return false;
        }
        MoviePurchase other = (MoviePurchase) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (ipAddress == null) {
            if (other.ipAddress != null) {
                return false;
            }
        } else if (!ipAddress.equals(other.ipAddress)) {
            return false;
        }
        if (movie == null) {
            if (other.movie != null) {
                return false;
            }
        } else if (!movie.equals(other.movie)) {
            return false;
        }
        if (purchasedDate == null) {
            if (other.purchasedDate != null) {
                return false;
            }
        } else if (!purchasedDate.equals(other.purchasedDate)) {
            return false;
        }
        if (user == null) {
            if (other.user != null) {
                return false;
            }
        } else if (!user.equals(other.user)) {
            return false;
        }
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "MoviePurchases [id=" + id + ", user=" + user + ", movie="
                + movie + ", purchasedDate=" + purchasedDate + ", ipAddress="
                + ipAddress + "]";
    }
    
    

    
    

}
