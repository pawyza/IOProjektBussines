/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbusinesstier;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;
import subbusinesstier.entities.Client;
import subbusinesstier.entities.Record;
import subbusinesstier.entities.Reservation;
import subbusinesstier.entities.TitleRecord;
import testdata.Data;

/**
 *
 * @author Jakub
 */
@Category({Test_Entity.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FacadeTest {

    static Data data;
    static Facade instance;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    public FacadeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        instance = new Facade();
        data = new Data();
    }

    @Test
    public void test1AddTitleRecord() {
        System.out.println("addTitleRecord");
        for (int i = 0; i < 6; i++) {
            instance.addTitleRecord(data.titleRecordData[i]);
            int number1 = instance.getTitleRecords().size();
            instance.addTitleRecord(data.titleRecordData[i]);
            int number2 = instance.getTitleRecords().size();
            TitleRecord result = instance.getTitleRecords().get(number2 - 1);
            assertEquals(data.titleRecords[number2 - 1], result);
            assertEquals(number1, number2);
        }

    }

    @Test
    public void test2AddRecord() {
        System.out.println("addRecord");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 1; j++) {

                instance.addRecord(data.titleRecordData[i], data.recordsData[j]);
                int number1 = instance.getTitleRecords().get(i).getRecords().size();
                instance.addRecord(data.titleRecordData[i], data.recordsData[j]);
                int number2 = instance.getTitleRecords().get(i).getRecords().size();

                Record result = instance.getTitleRecords().get(i).getRecords().get(number2 - 1);
                assertEquals(data.records[number2 - 1], result);
                assertEquals(number1, number2);

            }
        }
    }

  
    @Test
    @Category(Test_Entity.class)
    public void testAddReservation() {
        System.out.println("addReservation");
        int k = 0;
        int i = 2;
        int j = 1;
        int number = 0;
        
        instance.addReservation(data.titleRecordData[i], data.clientData[j], number++, data.dates[0], data.dates[1]);
        instance.addReservation(data.titleRecordData[i], data.clientData[j], number++, data.dates[2], data.dates[3]);
        int number2 = instance.getClients().get(i-1).getReservations().size();
        instance.addReservation(data.titleRecordData[i], data.clientData[j], number++, data.dates[0], data.dates[1]);
        int number3 = instance.getClients().get(i-1).getReservations().size();
        Reservation result = instance.getClients().get(j).getReservations().get(number3-1);
        assertEquals(data.reservations[k], result);
        assertEquals(number3, number2);
    }

    @Test
    public void testAddClient() {
        System.out.println("addClient");
        for (int i = 0; i < 2; i++) {
            instance.addClient(data.clientData[i]);
            int number1 = instance.getClients().size();
            instance.addClient(data.clientData[i]);
            int number2 = instance.getClients().size();
            Client result = instance.getClients().get(number2 - 1);
            assertEquals(data.clients[number2 - 1], result);
            assertEquals(number1, number2);

        }
    }

}
