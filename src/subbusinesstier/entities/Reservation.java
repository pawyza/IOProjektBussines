package subbusinesstier.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import subbusinesstier.Factory;

/**
 * PU:
 * Wy�lij_komunikat, Wyszukaj_klienta, Rezerwacja_nagrania,Zwrot_nagrania,Wyszukaj_rezerwacje, Usuwanie_rezerwacji, Op�acenie_rezerwacji,Odebranie_nagrania
 */
public class Reservation {
        
        public static int nextNumber =1;
	private Record record;
	private Client client;
	private int number;
	private LocalDate date;
        private Rental rental;

	public Record getRecord() {
		return this.record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public LocalDate getDate() {
		return this.date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

        public Rental getRental() {
            return rental;
        }

        public void setRental(Rental rental) {
            this.rental = rental;
        }
        
        public String addRental(Reservation reservation, LocalDate returnDate){
        Factory factory = new Factory();
        Rental newRental;
        newRental = factory.creatRental(reservation, returnDate);
        rental = newRental;
        return newRental.toString();
        }
        
        @Override
	public int hashCode() {
            return number;
	}

	/**
	 * 
	 * @param o
	 */
        @Override
	public boolean equals(Object o) {
            boolean result = false;
            if (getNumber() == ((Reservation) o).getNumber()) {
                result = true;
            }
            return result;
	}

	/**
	 * 
	 * @param date
	 */
	public boolean isFree(LocalDate date) {
            if (rental != null){
                if(rental.getReturnDate().isBefore(date)){
                    return true;
                }
            } 
            return false;
	}

        @Override
	public String toString() {
		return " Number: " + getNumber()  + " Date: " + date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))  + " Number: " + getNumber();
	}

}