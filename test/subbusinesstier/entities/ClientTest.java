/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbusinesstier.entities;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runners.Parameterized;
import testdata.Data;

/**
 *
 * @author Jakub
 */
public class ClientTest {
    
    static Data data;
    static Client client;
    
    public ClientTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        data = new Data();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        client = data.clients[number1];
    }
    
    @After
    public void tearDown() {
    }
@Parameterized.Parameter
    public int number1;
    /**
     * Test of getPassword method, of class Client.
     */
 
    @Test
    public void testAddReservation() {
      System.out.println("addReservation");
      Client client=data.clients[0];
      Record record = data.records[0];
        for (int j=0;j<data.dates.length-1;j++) {
            client.addReservation(record,j, data.dates[j],data.dates[3]);
            assertSame(client.getReservations().get(j), record.getReservations().get(j)); 
            assertSame(client.getReservations().get(j).getClient(), client); 
        }      

    }


    @Test
    public void testEquals() {
         System.out.println("testEquals");
         
        for (int i = number1; i < 2; i++) {
            if (number1 == i) {
                assertTrue(data.clients[number1].equals(data.clients[i]));
            } else {
                assertFalse(data.clients[number1].equals(data.clients[i]));
            }
        }
    }
    
}
