package subbusinesstier.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import subbusinesstier.Factory;

/**
 * PU: Wy�lij_komunikat, Wyszukaj_klienta,
 * Rezerwacja_nagrania,Zwrot_nagrania,Wyszukaj_rezerwacje, Usuwanie_rezerwacji,
 * Op�acenie_rezerwacji,Odebranie_nagrania
 */
public class Reservation {

    private Record record;
    private Client client;
    private int number;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private Rental rental;

    public Reservation(int number, LocalDate dateStart, LocalDate dateEnd) {
        this.number = number;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public Reservation(int number) {
        this.number = number;
        this.dateStart = LocalDate.now();
        this.dateEnd = LocalDate.now().plusDays(1);
    }

    public Reservation() {
        this.number = 1;
        this.dateStart = LocalDate.now();
        this.dateEnd = LocalDate.now().plusDays(1);
    }

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

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    public String addRental(Reservation reservation, float dayCost) {
        Factory factory = new Factory();
        Rental newRental;
        float cost = (float) dateStart.until(dateEnd, ChronoUnit.DAYS) * dayCost;
        newRental = factory.creatRental(reservation, cost);
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
    public boolean isFree(LocalDate dateStart, LocalDate dateEnd) {
        if (this.dateStart.isAfter(dateEnd) || this.dateEnd.isBefore(dateStart)) {
            if (rental == null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        if (!(null == getDateStart())) {
            return " Number: " + getNumber() + " Start date: " + getDateStart().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + " End date: " + getDateEnd().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + " Number: " + getNumber();
        }
        return "Number: " + getNumber();
    }

    public String[] toString_() {
        String help[] = new String[4];
        help[0] = String.valueOf(getNumber());
        help[1] = getClient().toString();
        help[2] = getRecord().toString();
        help[3] = getDateStart().toString();
        help[4] = getDateEnd().toString();
        help[5] = getRental().toString();
        return help;
    }
}
