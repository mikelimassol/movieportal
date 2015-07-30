package com.movie.portal.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * 
 * @author Michael Papamichael
 *
 */
@Entity
@Table(name="movies")
public class Movie implements Serializable{

    private static final long serialVersionUID = 215735653132984571L;
    
    private static final Integer PRIME_NUMBNER = 31;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "title")
    private String title;
    
    @Column(name = "price")
    private Double price;
    
    @Column(name = "discounted_price")
    private Double discountedPrice;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "released_date")
    private Date releasedDate;
    
    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender gender;
    
    
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<MoviePurchase> moviePurchases;
    
    /**
     * 
     */
    public Movie() {}
    
    /**
     * 
     * @param id
     */
    public Movie(Integer id) {
        super();
        this.id = id;
    }

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
     * @return the title
     */
    public final String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public final void setTitle(final String title) {
        this.title = title;
    }

    /**
     * @return the releasedDate
     */
    public final Date getReleasedDate() {
        return releasedDate;
    }

    /**
     * @param releasedDate the releasedDate to set
     */
    public final void setReleasedDate(final Date releasedDate) {
        this.releasedDate = releasedDate;
    }

    /**
     * @return the gender
     */
    public final Gender getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public final void setGender(final Gender gender) {
        this.gender = gender;
    }
    
    /**
     * @return the price
     */
    public final Double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public final void setPrice(Double price) {
        this.price = price;
    }

    /**
     * @return the discountedPrice
     */
    @JsonIgnore
    public final Double getDiscountedPrice() {
        return discountedPrice;
    }

    /**
     * @param discountedPrice the discountedPrice to set
     */
    public final void setDiscountedPrice(Double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    /**
     * @return the gender
     */
    @Column(name = "Year")
    public final Integer getYear() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(this.releasedDate);
        return cal.get(Calendar.YEAR);
    }
    
    
    public void setDiscountedPriceToPrice(){
        this.price = this.discountedPrice;
    }
    
    
    /**
     * @return the moviePurchases
     */
    @JsonIgnore
    public final Set<MoviePurchase> getMoviePurchases() {
        return moviePurchases;
    }

    /**
     * @param moviePurchase the moviePurchases to set
     */
    public final void setMoviePurchases(Set<MoviePurchase> moviePurchases) {
        this.moviePurchases = moviePurchases;
    }
   

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = PRIME_NUMBNER;
        int result = 1;
        result = prime * result + ((gender == null) ? 0 : gender.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result
                + ((releasedDate == null) ? 0 : releasedDate.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Movie)) {
            return false;
        }
        Movie other = (Movie) obj;
        if (gender == null) {
            if (other.gender != null) {
                return false;
            }
        } else if (!gender.equals(other.gender)) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (releasedDate == null) {
            if (other.releasedDate != null) {
                return false;
            }
        } else if (!releasedDate.equals(other.releasedDate)) {
            return false;
        }
        if (title == null) {
            if (other.title != null) {
                return false;
            }
        } else if (!title.equals(other.title)) {
            return false;
        }
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Movie [id=" + id + ", title=" + title + ", releasedDate="
                + releasedDate + ", gender=" + gender + "]";
    }
    
}
