/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbusinesstier.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author User
 */
@Entity
public class Rental {
 
    private static final long serialVersionUID=1L;
    //private Reservation reservation;
    private float cost;

    public Rental(Reservation reservation, float cost) {
        this.reservation = reservation;
        this.cost = cost;
    }
    
    @OneToOne
    private Reservation reservation;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    public Rental() {
    }

    public Reservation getReservation() {
            return reservation;
        }

	/**
	 * 
	 * @param reservation
	 */
        public void setReservation(Reservation reservation) {
            this.reservation = reservation;
        }

        public float getCost() {
            return cost;
        }

        public void setCost(float cost) {
            this.cost = cost;
        }
        @Override
	public int hashCode() {
                return Integer.valueOf(getReservation().getId().intValue() + String.valueOf(getCost()));
	}

	/**
	 * 
	 * @param obj
	 */
        @Override
	public boolean equals(Object o) {
            boolean result = false;
            if (getReservation().getId().equals(((Rental) o).getReservation().getId()))
                if (getCost() == (((Rental) o).getCost())) {
                result = true;
            }
            return result;
	}

        @Override
	public String toString() {
		return reservation.toString() + " Cost: " + String.valueOf(getCost());
	}  
}
