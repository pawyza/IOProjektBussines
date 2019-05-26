package subbusinesstier.entities;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import subbusinesstier.Test_Entity;
import testdata.Data;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;


@Category({Test_Entity.class})
@RunWith(Parameterized.class)
public class RecordTest {
    static Data data;
    static Record record;

    @BeforeClass
    public static void setUpClass() throws Exception {
        data = new Data();
    }

    @Before
    public void setUp() throws Exception {
        record = data.records[number1];
    }

    @Parameterized.Parameter
    public int number1;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data1 = new Object[][]{{0}, {1}};
        return Arrays.asList(data1);
    }

    @Test
    public void testEquals() {
        System.out.println("testEquals");
        for (int i = number1; i < 2; i++) {
            if (number1 == i) {
                assertTrue(data.records[number1].equals(data.records[i]));
            } else {
                assertFalse(data.records[number1].equals(data.records[i]));
            }
        }
    }

    @Test
    public void addReservation() {
        System.out.println("testAddReservation");
        int i = 0;

        for (Reservation reservation : data.reservations) {
            record.addReservation(reservation);
            assertEquals(reservation, record.getReservations().get(i));
            i++;
            assertEquals(reservation.getRecord(), record);

        }

    }

    @Test
    public void isFree() {
        System.out.println("testIsFree");
        boolean result = true;
        result = record.isFree(data.dates[number1], data.dates[3]);
        assertTrue(result);

    }


}