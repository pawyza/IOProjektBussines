package subbusinesstier;


import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import subbusinesstier.entities.*;
import testdata.Data;

import java.util.IllegalFormatCodePointException;

import static junit.framework.TestCase.assertEquals;


@Category({Factory.class})
public class FactoryTest {
    static Data data;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    public FactoryTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        data = new Data();

    }


    @Test
    public void createTitleRecord() {
        System.out.println("CreateTitleRecord");
        Factory instance = new Factory();
        for (int i = 0; i < data.titleRecordData.length; i++) {
            TitleRecord result = instance.createTitleRecord(data.titleRecordData[i]);
            assertEquals(data.titleRecords[i], result);
        }
    }

    @Test(expected = IllegalFormatCodePointException.class)
    public void createTitleRecordOfWrongCategory() {
        System.out.println("CreateTitleRecordOfWrongCategory");
        Factory instance = new Factory();
        instance.createTitleRecord(data.titleRecordWrongCategoryData[0]);
    }

    @Test
    public void createRecord() {
        System.out.println("CreateRecord");
        Factory instance = new Factory();
        for (int i = 0; i < data.recordsData.length; i++) {
            Record result = instance.createRecord(data.recordsData[i]);
            assertEquals(data.records[i], result);
        }

    }

    @Test
    public void createClient() {
        System.out.println("CreateClient");
        Factory instance = new Factory();
        for (int i = 0; i < data.recordsData.length; i++) {
            Client result = instance.createClient(data.clientData[i]);
            assertEquals(data.clients[i], result);
        }
    }

    @Test
    public void createReservation() {
        System.out.println("CreateReservation");
        Factory instance = new Factory();
        for (int i = 0; i < data.reservations.length; i++) {
            Reservation result = instance.createReservation(i + 1);
            assertEquals(data.reservations[i], result);

        }


    }

    @Test
    public void creatRental() {
        System.out.println("CreateRental");
        Factory instance = new Factory();
        for (int i = 0; i < data.rentals.length; i++) {
            Rental result = instance.creatRental(data.reservations[i], data.rentaltData[i]);
            assertEquals(data.rentals[i], result);
        }
    }
}
