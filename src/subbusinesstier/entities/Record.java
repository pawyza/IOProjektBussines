package subbusinesstier.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 * PU: Dodaj_tytu�_nagrania, Wyszukaj_tytu�_nagrania, Operacje_na_nagraniach,
 * Dodawanie_nagrania, Modyfikacja_nagrania, Wyszukaj_nagrania,
 * Usuwanie_nagrania, Publikuj, Wy�lij_komunikat,
 * Rezerwacja_nagrania,Zwrot_nagrania, Odebranie_nagrania
 */
@Entity
public class Record {

    private static final long serialVersionUID = 1L;
    private Long number;

    public Long getNumber() {
        return number;

    }

    public void setNumber(Long id) {
        this.number = id;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    private TitleRecord titleRecord;

    @Transient
    private List<Reservation> reservations = new ArrayList<>();

    public Record(long id) {
        this.number = id;
    }

    public TitleRecord getTitleRecord() {

        return this.titleRecord;
    }

    public void setTitleRecord(TitleRecord titleRecord) {
        this.titleRecord = titleRecord;
    }

    public Record() {
        
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(ArrayList reservations) {
        this.reservations = reservations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Record record = (Record) o;

        return number.equals(record.getNumber());
    }

    @Override
    public int hashCode() {
        return number.intValue();
    }

    @Override
    public String toString() {
        String help = titleRecord.toString();
        help += " Number: " + getNumber().toString();
        return help;
    }

    /**
     * @param reservation
     */
    public void addReservation(Reservation reservation) {
        reservation.setRecord(this);
        reservations.add(reservation);
    }

    /**
     * @param date
     * @return
     */
    public boolean isFree(LocalDate dateStart, LocalDate dateEnd) {
        Reservation reservation;
        for (int i = 0; i < reservations.size(); i++) {
            reservation = reservations.get(i);
            if (!reservation.isFree(dateStart, dateEnd)) {
                return false;
            }
        }
        return true;
    }

    public String[] _toString_() {
        String help[] = new String[4];
        help[0] = String.valueOf(getNumber());
        help[1] = getTitleRecord().toString();
        return help;

    }

}
