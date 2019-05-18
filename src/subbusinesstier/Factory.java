package subbusinesstier;

import subbusinesstier.entities.*;

import java.time.LocalDate;
import java.util.IllegalFormatCodePointException;

/**
 * PU:
 * Dodaj_tytu�_nagrania Operacje_na_nagraniach, Dodawanie_nagrania Logowanie, Rejestracja_klienta, Rezerwacja_nagrania
 */
public class Factory {

    /**
     * @param data
     */
    public TitleRecord createTitleRecord(String[] data) {
        TitleRecord titleRecord = null;
        switch (Integer.parseInt(data[0])) {
            case 0:
                titleRecord = new TitleRecord();
                titleRecord.setId(data[1]);
                titleRecord.setTitle(data[2]);
                break;
            case 1:
                titleRecord = new TitleRecord();
                titleRecord.setId(data[1]);
                titleRecord.setTitle(data[2]);
                titleRecord.setAuthor(data[3]);
                break;
            case 2:
                titleRecord = new TitleRecord();
                titleRecord.setId(data[1]);
                titleRecord.setTitle(data[2]);
                titleRecord.setAuthor(data[3]);
                titleRecord.setCast(data[4]);
                break;
            case 3:
                titleRecord = new TitleRecord();
                titleRecord.setId(data[1]);
                titleRecord.setTitle(data[2]);
                titleRecord.setAuthor(data[3]);
                titleRecord.setCast(data[4]);
                titleRecord.setGenre(data[5]);
                break;
            default:
                throw new IllegalFormatCodePointException(0);
        }


        return titleRecord;


    }

    /**
     * @param data
     */
    public Record createRecord(String[] data) {
        Record record = null;

        switch (Integer.parseInt(data[0]))
        {
            case 0:
                record = new Record();
                record.setNumber(Integer.parseInt(data[1]));
                break;
        }
        return record;
    }

    /**
     * @param data
     */
    public Client createClient(String[] data) {
        Client client = null;
        client = new Client();
        client.setNumberCard(data[0]);
        client.setLogin(data[1]);
        client.setNumber(Integer.parseInt(data[2]));
        client.setPassword(data[3]);
        return client;
    }



    /**
     * @param number
     * @param date
     */
    public Reservation createReservation(int number) {
        
        Reservation reservation = null;
        reservation = new Reservation();
        reservation.setNumber(number);
        return reservation;
    }

     /**
     * @param reservation
     * @param returnDate
     */
    public Rental creatRental(Reservation reservation, Float cost){
        Rental rental = null;
        rental = new Rental();
        rental.setReservation(reservation);
        rental.setCost(cost);
        return rental;
    }
}