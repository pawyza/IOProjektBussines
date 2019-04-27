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
	private LocalDate returnDate;

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

        public LocalDate getReturnDate() {
            return returnDate;
        }

	/**
	 * 
	 * @param returnDate
	 */
        public void setReturnDate(LocalDate returnDate) {
            this.returnDate = returnDate;
        }

        @Override
	public int hashCode() {
                return Integer.valueOf(reservation.getNumber() + returnDate.format(DateTimeFormatter.ofPattern("yyMMdd")));
	}

	/**
	 * 
	 * @param obj
	 */
        @Override
	public boolean equals(Object o) {
            boolean result = false;
            if (getReservation().getNumber() == ((Rental) o).getReservation().getNumber())
                if (getReturnDate().equals(((Rental) o).getReturnDate())) {
                result = true;
            }
            return result;
	}

        @Override
	public String toString() {
		return reservation.toString() + " Return date: " + returnDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	}  
}
