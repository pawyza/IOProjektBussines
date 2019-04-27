package subbusinesstier;

import subbusinesstier.entities.Client;
import subbusinesstier.entities.Record;
import subbusinesstier.entities.TitleRecord;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import subbusinesstier.entities.Reservation;

/**
 * PU:
 * Dodaj_tytu�_nagrania, Wyszukaj_tytu�_nagrania, Operacje_na_nagraniach, Dodawanie_nagrania, Modyfikacja_nagrania, Wyszukaj_nagrania, Usuwanie_nagrania, Publikuj, Wy�lij_komunikat, Wyszukaj_klienta, Logowanie, Rejestracja_klienta, Rezerwacja_nagrania,Zwrot_nagrania,Wyszukaj_rezerwacje, Usuwanie_rezerwacji, Op�acenie_rezerwacji,Odebranie_nagrania
 */
public class Facade {

    private List<TitleRecord> titleRecords;
    private List<Client> clients;

    public Facade() {
        titleRecords = new ArrayList<>();
        clients = new ArrayList<>();

    }

    /**
     * @param t
     */
    public static void main(String[] t) {
        Facade ap = new Facade();

        System.out.println("Test dodawania nagran 'tytulowych'");
        String[] titleRecord1 = {"0", "ID1", "Title1"};
        String[] titleRecord2 = {"1", "ID2", "Title2", "Author1"};
        String[] titleRecord3 = {"1", "ID3", "Title3", "Author2"};
        String[] titleRecord4 = {"3", "ID4", "Title4", "Author3", "Cast1", "Genre1"};
        String[] titleRecord5 = {"3", "ID5", "Title5", "Author4", "Cast2", "Genre2"};
        String[] titleRecord6 = {"3", "ID6", "Title6", "Author5", "Cast3", "Genre4"};
        ap.addTitleRecord(titleRecord1);
        ap.addTitleRecord(titleRecord2);
        ap.addTitleRecord(titleRecord2);
        ap.addTitleRecord(titleRecord3);
        ap.addTitleRecord(titleRecord4);
        ap.addTitleRecord(titleRecord5);
        ap.addTitleRecord(titleRecord5);
        ap.addTitleRecord(titleRecord6);


        String lan = ap.getTitleRecords().toString();
        System.out.println(lan);

        System.out.println("Test dodawania nagran");
        String[] record1 = {"0", "1"};
        String[] record2 = {"0", "2"};

        ArrayList<String> pom = ap.addRecord(titleRecord1, record1);
        if (pom != null) {
            System.out.print(pom);
        }
        pom = ap.addRecord(titleRecord2, record1);
        if (pom != null) {
            System.out.print(pom);
        }
        pom = ap.addRecord(titleRecord2, record1);
        if (pom != null) {
            System.out.print(pom);
        }
        pom = ap.addRecord(titleRecord2, record2);
        if (pom != null) {
            System.out.print(pom);
        }
        pom = ap.addRecord(titleRecord3, record2);
        if (pom != null) {
            System.out.print(pom);
        }
        pom = ap.addRecord(titleRecord4, record1);
        if (pom != null) {
            System.out.print(pom);
        }
        pom = ap.addRecord(titleRecord5, record2);
        if (pom != null) {
            System.out.print(pom);
        }

        System.out.println("\nTest szukania nagrań o tytule:");
        System.out.println(ap.searchRecordsOfTitle(titleRecord1));

                    
        System.out.println("\nTest dodawania klientow");
        String client1[] = {"2557835671236456", "Ania", "1", "Tom"};
        String client2[] = {"2978365671236456", "Kamil", "2", "Iop"};
        String client3[] = {"2557835671233310", "Filip", "3", "Spd"};
        String client4[] = {"2557800027636456", "Jakub", "4", "BiomM"};
        String client5[] = {"2557801926554456", "Dawid", "5", "Redagowanie"};
        String client6[] = {"2557835671236456", "Ania", "6", "Mikro"};

        ap.addClient(client1);
        ap.addClient(client2);
        ap.addClient(client3);
        ap.addClient(client4);
        ap.addClient(client5);
        ap.addClient(client6);
         lan = ap.getClients().toString();
         System.out.println(lan);
        System.out.println("\nTest dodawania rezerwacji");
            LocalDate date1 = LocalDate.of(2019, Month.MAY, 10);
            
            LocalDate date2 = LocalDate.of(2019, Month.JULY, 4);
        
        ap.addReservation(titleRecord1, client1, date1);
        ap.addReservation(titleRecord1, client2, date1);
        ap.addReservation(titleRecord1, client5, date1);
        ap.addReservation(titleRecord1, client4, date1);
        ap.addReservation(titleRecord2, client2, date2);
        ap.addReservation(titleRecord2, client3, date2);
        ap.addReservation(titleRecord3, client3, date2);

        lan = ap.getClients().toString();
        System.out.println(lan);
        
        System.out.println("\nTest dodawania rental");
         LocalDate date3 = LocalDate.of(2019, Month.MAY,20);
         LocalDate date4 = LocalDate.of(2019, Month.JULY, 24);
         String pom2;
        pom2 = ap.addRental(client1, 1, date1, date4);
        System.out.println(pom2);
        pom2 = ap.addRental(client2, 2, date1, date3);
         System.out.println(pom2);
        pom2 = ap.addRental(client3, 3, date2, date3);
         System.out.println(pom2);
        pom2 = ap.addRental(client6, 4, date2, date4);
         System.out.println(pom2);
        pom2 = ap.addRental(client4, 5, date2, date3);
         System.out.println(pom2);
    }


    public List<TitleRecord> getTitleRecords() {
        return titleRecords;
    }

    /**
     * @param titleRecords
     */
    private void setTitleRecords(List<TitleRecord> titleRecords) {
        this.titleRecords = (ArrayList) titleRecords;
    }

    public List<Client> getClients() {
        return clients;
    }

    /**
     * @param clients
     */
    public void setClients(List<Client> clients) {
        this.clients = (ArrayList) clients;
    }

    /**
     * @param data
     */
    public String addTitleRecord(String[] data) {
        Factory factory = new Factory();
        TitleRecord titleRecord = factory.createTitleRecord(data);
        if (searchTitleRecord(titleRecord) == null) {
            titleRecords.add(titleRecord);
            return titleRecord.toString();
        }
        return null;

    }

    /**
     * @param data1
     * @param data2
     * @return 
     */
    public ArrayList<String> addRecord(String[] data1, String[] data2) {

        TitleRecord help1, titleExist;
        Factory factory = new Factory();
        help1 = factory.createTitleRecord(data1);
        if ((titleExist = searchTitleRecord(help1)) != null) {

            return titleExist.addRecord(data2);

        }
        return null;
    }

    /**
     * @param titleRecord
     * @return 
     */
    public TitleRecord searchTitleRecord(TitleRecord titleRecord) {
        int index;
        if ((index = titleRecords.indexOf(titleRecord)) != -1) {
            return titleRecords.get(index);
        }
        return null;
    }
    
    

    public TitleRecord searchTitleRecod(String id) {
        for(TitleRecord titleRecord : titleRecords){
            if (titleRecord.getId().equals(id))
                return titleRecord;
        }
        return null;
    }
        
    /**
     * @param client
     * @param message
     */
    public void sendPublication(Client client, String[] message) {

    }

    /**
     * @param titleRecord
     * @return
     */

    public String[] addPublication(TitleRecord titleRecord) {
        throw new UnsupportedOperationException();
    }

    /**
     * @param data
     */
    public String addClient(String data[]) {
        Factory factory = new Factory();
        Client client = factory.createClient(data);
        if (searchClient(client) == null) {
            clients.add(client);
            return client.toString();
        }
        return null;
    }

    /**
     * @param client
     */
    public Client searchClient(Client client) {
        int idx;
        idx = clients.indexOf(client);
        if (idx != -1) {

            return clients.get(idx);
        }
        return null;
    }

        public Client searchClient(int id) {
        for(Client client : clients){
            if (client.getNumber() == id)
                return client;
            }
        return null;
    }

    
    /**
     * @param data1
     * @param data2
     * @param date
     */
    public String addReservation(String[] data1, String[] data2, LocalDate date) {
        String result;
        Factory factory = new Factory();
        TitleRecord helpTitleRecord = factory.createTitleRecord(data1),titleRecord;
        
        titleRecord = this.searchTitleRecord(helpTitleRecord);
        if(titleRecord != null)
            if(titleRecord.searchFreeRecord(date)){
                Client helpClient = factory.createClient(data2),client;
                
                client = this.searchClient(helpClient);
                if(client != null){
                    if(titleRecord.getRecord(date)!= null){
                    client.addReservation(titleRecord.getRecord(date), date);
                    result = "reserved";
                    } else result = "no free record";
                } else result = "no such client";
            } else result = "no such book";
         else result = "no such title";
        return result;
    }

    /**
     * @param data1
     */
    public ArrayList<String> searchRecordsOfTitle(String[] data1) {
        Factory factory = new Factory();
        TitleRecord titleRecord = factory.createTitleRecord(data1);
        ArrayList<String> recordsOfTitleList = new ArrayList<>();
        int index;

        if ((index = titleRecords.indexOf(titleRecord)) != -1) {
            List<Record> records = titleRecords.get(index).getRecords();
            Iterator<Record> help = records.iterator();
            while (help.hasNext()) {
                recordsOfTitleList.add(help.next().toString());
            }
            return recordsOfTitleList;
        }
        return null;
    }

    public Object[][] getTitleRecordModel() {
        throw new UnsupportedOperationException();
    }

    public String PrintRecords() {
        String result = "";
        for(TitleRecord titleRecord : titleRecords){
            for(Record record : titleRecord.getRecords()){
                result += record.toString();
            }
        }
        return result;
    }

    public String PrintTitleRecords() {
        String result = "";
        for(TitleRecord titleRecord : titleRecords){
            result += titleRecord.toString();
        }
        return result;
    }

    /**
     * @param data1
     * @param data2
     * @param returnDate
     */
    public String addRental(String[] data1,int number , LocalDate date , LocalDate returnDate) {
        String result;
        Factory factory = new Factory();
        
        Client helpClient = factory.createClient(data1),client;
        
        client = this.searchClient(helpClient);
        if(client != null){
            Reservation helpReservation = factory.createReservation(number, date),reservation;
            
            reservation = client.searchReservation(helpReservation);
            if(reservation != null){
                reservation.addRental(reservation, returnDate);
                result = "rented";
            } else result = "no such reservation";
        } else result = "no such client";
        return result;
    }

}