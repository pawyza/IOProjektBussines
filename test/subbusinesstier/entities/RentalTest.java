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
import static subbusinesstier.entities.RecordTest.data;
import testdata.Data;

/**
 *
 * @author Jakub
 */
public class RentalTest {
    
 static Data data;
    static Rental rental;
    @BeforeClass
    public static void setUpClass() {
             data = new Data();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        rental = data.rentals[number1];
    }
    
    @After
    public void tearDown() {
    }
    @Parameterized.Parameter
    public int number1;
    /**
     * Test of getReservation method, of class Rental.
     */
    @Test
    public void testGetReservation() {
        System.out.println("getReservation");
        Rental instance = new Rental();
        Reservation expResult = null;
        Reservation result = instance.getReservation();
        assertEquals(expResult, result);
     
    }

    /**
     * Test of setReservation method, of class Rental.
     */
    @Test
    public void testSetReservation() {
        System.out.println("setReservation");
        Reservation reservation = null;
        Rental instance = new Rental();
        instance.setReservation(reservation);
 
    }

    /**
     * Test of getCost method, of class Rental.
     */
    @Test
    public void testGetCost() {
        System.out.println("getCost");
        Rental instance = new Rental();
        float expResult = 0.0F;
        float result = instance.getCost();
        assertEquals(expResult, result, 0.0);
   
    }

    /**
     * Test of setCost method, of class Rental.
     */
    @Test
    public void testSetCost() {
        System.out.println("setCost");
        float cost = 0.0F;
        Rental instance = new Rental();
        instance.setCost(cost);
  
    }

    /**
     * Test of equals method, of class Rental.
     */
    @Test
    public void testEquals() {
       for (int i = number1; i < 2; i++) {
            if (number1 == i) {
                assertTrue(data.rentals[number1].equals(data.rentals[i]));
            } else {
                assertFalse(data.rentals[number1].equals(data.rentals[i]));
            }
        }
    
    }

    
}
