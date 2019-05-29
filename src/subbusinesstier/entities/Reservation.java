package subbusinesstier.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import subbusinesstier.Factory;

/**
 * PU: Wy�lij_komunikat, Wyszukaj_klienta,
 * Rezerwacja_nagrania,Zwrot_nagrania,Wyszukaj_rezerwacje, Usuwanie_rezerwacji,
 * Op�acenie_rezerwacji,Odebranie_nagrania
 */
@Entity
public class Reservation implements Serializable {

    private static final long serialVersionUID = 1L;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private Long number;

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long id) {
        this.number = id;
    }

    @ManyToOne
    private Client client;
    @ManyToOne
    private Record record;

    //@Transient
    private Rental rental;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Reservation(Long id, LocalDate dateStart, LocalDate dateEnd) {
        this.number = id;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public Reservation(long id) {

        this.id = id;
        this.dateStart = LocalDate.now();
        this.dateEnd = LocalDate.now().plusDays(1L);

        this.number = id;

    }

    public Reservation() {
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
        return number.intValue();
    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;

        if (getNumber().equals(((Reservation) o).getNumber())) {
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
            return "Id: " + getNumber().toString() + " Start date: " + getDateStart().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + " End date: " + getDateEnd().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        }
        return "Id: " + getNumber().toString();
    }

    public String[] toString_() {
        String help[] = new String[4];
        help[0] = getNumber().toString();
        help[1] = getClient().toString();
        help[2] = getRecord().toString();
        help[3] = getDateStart().toString();
        help[4] = getDateEnd().toString();
        help[5] = getRental().toString();
        return help;
    }

}
