/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbusinesstier.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author User
 */
public class Rental {
 
	private Reservation reservation;
        private float cost;

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
                return Integer.valueOf(getReservation().getNumber() + String.valueOf(getCost()));
	}

	/**
	 * 
	 * @param obj
	 */
        @Override
	public boolean equals(Object o) {
            boolean result = false;
            if (getReservation().getNumber() == ((Rental) o).getReservation().getNumber())
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
