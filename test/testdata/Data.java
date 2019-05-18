package testdata;


import subbusinesstier.entities.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class Data {


    public String[][] titleRecordData = {
            {"0", "ID1", "Title1"},
            {"1", "ID2", "Title2", "Author1"},
            {"1", "ID3", "Title3", "Author2"},
            {"3", "ID4", "Title4", "Author3", "Cast1", "Genre1"},
            {"3", "ID5", "Title5", "Author4", "Cast2", "Genre2"},
            {"3", "ID6", "Title6", "Author5", "Cast3", "Genre4"}};


    public String[][] titleRecordWrongCategoryData = {
            {"4", "ID1", "Title1"},
            {"5", "ID2", "Title2", "Author1"},
            {"6", "ID3", "Title3", "Author2"},
            {"7", "ID4", "Title4", "Author3", "Cast1", "Genre1"},
            {"8", "ID5", "Title5", "Author4", "Cast2", "Genre2"},
            {"9", "ID6", "Title6", "Author5", "Cast3", "Genre4"}};

    public TitleRecord[] titleRecords = {
            new TitleRecord("ID1", "Title1"),
            new TitleRecord("ID2", "Title2", "Author1"),
            new TitleRecord("ID3", "Title3", "Author2"),
            new TitleRecord("ID4", "Title4", "Author3", "Cast1", "Genre1"),
            new TitleRecord("ID5", "Title5", "Author4", "Cast2", "Genre2"),
            new TitleRecord("ID6", "Title6", "Author5", "Cast3", "Genre4")


    };


    public String[][] recordsData = {
            {"0", "1"}, {"0", "2"}
    };

    public Record[] records = {
            new Record(1),
            new Record(2)};


    public String[][] clientData = {

            {"2557835671236456", "Ania", "1", "Tom"},
            {"2978365671236456", "Kamil", "2", "Iop"},
            {"2557835671233310", "Filip", "3", "Spd"},
            {"2557800027636456", "Jakub", "4", "BiomM"},
            {"2557801926554456", "Dawid", "5", "Redagowanie"},
            {"2557835671236456", "Ania2", "6", "Mikro"}};


    public Client[] clients = {
            new Client("2557835671236456", "Ania", 1, "Tom"),
            new Client("2978365671236456", "Kamil", 2, "Iop"),
            new Client("2557835671233310", "Filip", 3, "Spd"),
            new Client("2557800027636456", "Jakub", 4, "BiomM"),
            new Client("2557801926554456", "Dawid", 5, "Redagowanie"),
            new Client("2557835671236456", "Ania2", 6, "Mikro")

    };

    public LocalDate[] dates = {
            LocalDate.of(2019, Month.MAY, 10),
            LocalDate.of(2019, Month.MAY, 18),
            LocalDate.of(2019, Month.JULY, 4),
            LocalDate.of(2019, Month.JULY, 21)};

    public Reservation[] reservations = {
            new Reservation(1),
            new Reservation(2),
            new Reservation(3),
            new Reservation(4),
            new Reservation(5),
            new Reservation(6),
            new Reservation(7)};


    public List<Reservation> reservationList = Arrays.asList(reservations);

    public Rental[] rentals = {
            new Rental(reservations[0], 10),
            new Rental(reservations[1], 20),
            new Rental(reservations[2], 13),
            new Rental(reservations[3], 17),
            new Rental(reservations[4], 16)
    };
    public float[] rentaltData = {10, 20, 13, 17, 16};


    public static int number = 0;
}
