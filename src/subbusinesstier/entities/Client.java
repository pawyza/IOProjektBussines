package subbusinesstier.entities;

import java.io.Serializable;
import subbusinesstier.Factory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 * PU: Publikuj, Wy�lij_komunikat, Wyszukaj_klienta, Logowanie,
 * Rejestracja_klienta, Rezerwacja_nagrania,Zwrot_nagrania,Wyszukaj_rezerwacje
 */
@Entity
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long number;
    private String numberCard;
    private String login;
    private String password;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }
    //@Transient
    @OneToMany(mappedBy = "client", cascade = ALL)
    private List<Reservation> reservations = new ArrayList<>();

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

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

    public Client() {
    }

    public Client(String numberCard, String login, Long number, String password) {
        this.numberCard = numberCard;
        this.login = login;
        //this.number = number;
        this.number = number;
        this.password = password;
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
        } else {
            return "no such reservation";
        }
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
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Client client = (Client) o;

        //return number == client.getNumber();
        return getNumber().equals(client.getNumber());
    }

    public Reservation searchReservation(Reservation reservation) {
        int index;
        if ((index = reservations.indexOf(reservation)) != -1) {
            return (Reservation) reservations.get(index);
        }
        return null;
    }

    public Reservation searchReservation(Long number) {
        for (Reservation reservation : reservations) {
            if (getNumber().equals(number)) {
                return reservation;
            }
        }
        return null;
    }

    public Long deleteReservation(int number) {
        Reservation reservation = searchReservation(new Long(number));
        if (reservation != null) {
            Long numberDel = reservation.getNumber();
            reservations.remove(reservation);
            return numberDel;
        }
        return null;
    }

    public Long getReservationNumber(Object object) {
        Reservation reservation = (Reservation) object;
        return reservation.getNumber();
    }
    
    public List<String[]> getReservationStrings() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        ArrayList<String[]> h = new ArrayList<>();
        for (Reservation reservation : getReservations()) {
            h.add(new String[]{reservation.getNumber().toString(), reservation.getDateStart().format(formatter), reservation.getDateEnd().format(formatter)});
        }
        return h;
    }

    @Override
    public int hashCode() {
        return number.intValue();
    }

    @Override
    public String toString() {
        String client = "Login: " + login + " Number: " + number.toString() + " NumberCard: " + numberCard + " Password: " + password + "\n";
        for (Reservation reservation : reservations) {
            client += reservation.toString();
        }
        return client + "\n";
    }

    public String[] toString_() {
        String help[] = new String[4];
        help[2] = getNumber().toString();
        help[1] = getLogin();
        help[3] = getPassword();
        help[0] = getNumberCard();
        return help;
    }

}
