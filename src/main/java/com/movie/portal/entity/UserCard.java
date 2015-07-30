package com.movie.portal.entity;

import java.io.Serializable;
import java.util.Date;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author Michael Papamichael
 *
 */
@Entity
@Table(name = "cards")
public class UserCard implements Serializable {

    private static final long serialVersionUID = -5268596474668310903L;
    
    private static final Integer PRIME_NUMBNER = 31;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "number")
    private String number;
    
    @Column(name = "cvv")
    private String cvv;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "expiry_date")
    private Date expiryDate;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

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
     * @return the number
     */
    public final String getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public final void setNumber(final String number) {
        this.number = number;
    }

    /**
     * @return the cvv
     */
    public final String getCvv() {
        return cvv;
    }

    /**
     * @param cvv the cvv to set
     */
    public final void setCvv(final String cvv) {
        this.cvv = cvv;
    }

    /**
     * @return the expiryDate
     */
    public final Date getExpiryDate() {
        return expiryDate;
    }

    /**
     * @param expiryDate the expiryDate to set
     */
    public final void setExpiryDate(final Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * @return the user
     */
    @JsonIgnore
    public final User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public final void setUser(final User user) {
        this.user = user;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = PRIME_NUMBNER;
        int result = 1;
        result = prime * result + ((number == null) ? 0 : number.hashCode());
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
        if (!(obj instanceof UserCard)) {
            return false;
        }
        UserCard other = (UserCard) obj;
        if (number == null) {
            if (other.number != null) {
                return false;
            }
        } else if (!number.equals(other.number)) {
            return false;
        }
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "UserCard [id=" + id + ", number=" + number + ", cvv=" + cvv
                + ", expiryDate=" + expiryDate + "]";
    }
    
}
