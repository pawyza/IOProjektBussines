    package subbusinesstier.entities;

import subbusinesstier.Factory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * PU:
 * Publikuj, Wy�lij_komunikat, Wyszukaj_klienta, Logowanie, Rejestracja_klienta, Rezerwacja_nagrania,Zwrot_nagrania,Wyszukaj_rezerwacje
 */
public class Client {

    private List<Reservation> reservations = new ArrayList<>();
    private String numberCard;
    private String login;
    private int number = 0;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumberCard() {
        return this.numberCard;
    }

    public void setNumberCard(String numberCard) {
        this.numberCard = numberCard;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Client() {
    }

    public Client(String numberCard, String login, int number, String password) {
        this.numberCard = numberCard;
        this.login = login;
        this.number = number;
        this.password = password;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
    
    /**
     * @param record
     * @param date
     */
    public void addReservation(Record record, int number, LocalDate dateStart, LocalDate dateEnd) {
        Factory factory = new Factory();
        Reservation reservation = factory.createReservation(number);
        reservation.setClient(this);
        reservation.setDateStart(dateStart);
        reservation.setDateEnd(dateEnd);
        record.addReservation(reservation);
        reservations.add(reservation);
    }

    public String addRental(int number, float dayCost) {
        Factory factory = new Factory();
        Reservation helpReservation = factory.createReservation(number), reservation;
        reservation = searchReservation(helpReservation);
        if (reservation != null) {
            reservation.addRental(reservation, dayCost);
            return "rented";
        } else return "no such reservation";
    }
    
      public ArrayList<Object[]> getReservationModel() {
        ArrayList<Object[]> reservationsModel = new ArrayList<>();
        for (Reservation reservation : reservations) {
                reservationsModel.add(reservation.toString_());
            }
        return reservationsModel;
    }
      
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        return number == client.getNumber();
    }
    
    public Reservation searchReservation(Reservation reservation){
        int index;
        if ((index = reservations.indexOf(reservation)) != -1) {
            return (Reservation) reservations.get(index);
        }
        return null;
    }
    
    public Reservation searchReservation(int number){
        for (Reservation reservation:reservations){
            if (reservation.getNumber()==number) return reservation;
        }
        return null;
    }
    
    public void deleteReservation(int number){
        Reservation reservation = searchReservation(number);
        reservations.remove(reservation);
    }
      
      public int getReservationNumber(Object object){
          Reservation reservation = (Reservation) object;
          return reservation.getNumber();
      }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public String toString() {
        String client = "Login: " + login + " Number: " + number + " NumberCard: " + numberCard + " Password: " + password + "\n";
        for(Reservation reservation : reservations){
            client += reservation.toString();
        }
        return client + "\n";
    }
    
        public String[] toString_() {
        String help[] = new String[4];
        help[2] = String.valueOf(getNumber());
        help[1] = getLogin();
        help[3] = getPassword();
        help[0] = getNumberCard();
        return help;
    }

}