package subbusinesstier.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * PU:
 * Dodaj_tytu�_nagrania, Wyszukaj_tytu�_nagrania, Operacje_na_nagraniach, Dodawanie_nagrania, Modyfikacja_nagrania, Wyszukaj_nagrania, Usuwanie_nagrania, Publikuj, Wy�lij_komunikat, Rezerwacja_nagrania,Zwrot_nagrania, Odebranie_nagrania
 */
public class Record {

    private int number;
    private TitleRecord titleRecord;
    private ArrayList<Reservation> reservations = new ArrayList();

    public Record(int number) {
        this.number = number;
        this.titleRecord = new TitleRecord();
    }


    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Record record = (Record) o;

        return number == record.getNumber();
    }

    @Override
    public int hashCode() {
        return number;
    }


    @Override
    public String toString() {
        String help = titleRecord.toString();
        help += " Number: " + getNumber();
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