package testdata;


import subbusinesstier.entities.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class Data {


    public String[][] titleRecordData = {
            {"0", "1", "Title1"},
            {"1", "2", "Title2", "Author1"},
            {"1", "3", "Title3", "Author2"},
            {"3", "4", "Title4", "Author3", "Cast1", "Genre1"},
            {"3", "5", "Title5", "Author4", "Cast2", "Genre2"},
            {"3", "6", "Title6", "Author5", "Cast3", "Genre4"}};


    public String[][] titleRecordWrongCategoryData = {
            {"4", "1", "Title1"},
            {"5", "2", "Title2", "Author1"},
            {"6", "3", "Title3", "Author2"},
            {"7", "4", "Title4", "Author3", "Cast1", "Genre1"},
            {"8", "5", "Title5", "Author4", "Cast2", "Genre2"},
            {"9", "6", "Title6", "Author5", "Cast3", "Genre4"}};

    public TitleRecord[] titleRecords = {
           new TitleRecord(1L, "Title1"),
           new TitleRecord(2L, "Title2", "Author1"),
           new TitleRecord(3L, "Title3", "Author2"),
            new TitleRecord(4L, "Title4", "Author3", "Cast1", "Genre1"),
            new TitleRecord(5L, "Title5", "Author4", "Cast2", "Genre2"),
            new TitleRecord(6L, "Title6", "Author5", "Cast3", "Genre4")


    };


    public String[][] recordsData = {
            {"0", "1"}, {"0", "2"}
    };

    public Record[] records = {
            new Record(1L),
            new Record(2L)};


    public String[][] clientData = {

            {"2557835671236456", "Ania", "1", "Tom"},
            {"2978365671236456", "Kamil", "2", "Iop"},
            {"2557835671233310", "Filip", "3", "Spd"},
            {"2557800027636456", "Jakub", "4", "BiomM"},
            {"2557801926554456", "Dawid", "5", "Redagowanie"},
            {"2557835671236456", "Ania2", "6", "Mikro"}};


    public Client[] clients = {
            new Client("2557835671236456", "Ania", 1L, "Tom"),
            new Client("2978365671236456", "Kamil", 2L, "Iop"),
            new Client("2557835671233310", "Filip", 3L, "Spd"),
            new Client("2557800027636456", "Jakub", 4L, "BiomM"),
            new Client("2557801926554456", "Dawid", 5L, "Redagowanie"),
            new Client("2557835671236456", "Ania2", 6L, "Mikro")

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
