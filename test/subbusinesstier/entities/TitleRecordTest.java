/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbusinesstier.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import subbusinesstier.Test_Entity;

import testdata.Data;

/**
 *
 * @author Jakub
 */

@Category({Test_Entity.class})
@RunWith(Parameterized.class)

public class TitleRecordTest {

    static Data data;
    static TitleRecord titleRecord;
    static Record record;

    @BeforeClass
    public static void setUpClass() {
        data = new Data();
    }

    @Before
    public void setUp() throws Exception {
        record = data.records[number1];
        titleRecord = data.titleRecords[number1];

    }
    @Parameterized.Parameter
    public int number1;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data1 = new Object[][]{{0}, {1}};
        return Arrays.asList(data1);
    }

// @Test
// public void testAddBook() {
// System.out.println("addBook");
// for (int i = 0; i < data.bookdata.length; i++) {
// title.addBook(data.bookdata[i]);
// assertEquals(data.books[i], title.getBooks().get(i)); } //k1.3
// for (int i = 0; i < data.bookdata.length; i++) {
// data.titles[0].addBook(data.bookdata[i]);
// assertEquals(title.getBooks().size(), data.bookdata.length); } // k1.5- badanie spójnosci danych
// }
    @Test
    public void testAddRecord() {
        System.out.println("addRecord");
        for (int i = 0; i < data.recordsData.length; i++) {
            System.out.println("TR : " + titleRecord);
            System.out.println("DATA: " + Arrays.toString(data.recordsData[i]));
            titleRecord.addRecord(data.recordsData[i]);
            assertEquals(data.records[i], titleRecord.getRecords().get(i));
        }
        for (int i = 0; i < data.titleRecordData.length; i++) {
            data.titleRecords[0].addRecord(data.recordsData[i]);
            assertEquals(titleRecord.getRecords().size(), data.titleRecords.length);
        }
    }

    @Test
    public void testGetTitleRecordsModel() {
        System.out.println("getTitleRecordModel");
        if (number1 == 4) {
            assertEquals(titleRecord.getRecordsModel(), Arrays.asList(data.titleRecords));
            assertNotEquals(titleRecord.getRecordsModel(), Arrays.asList(data.titleRecords));
        } else if (number1 == 5) {
            assertEquals(titleRecord.getRecordsModel(), Arrays.asList(data.titleRecords));
        }
    }

    @Test
    public void testEquals() {
        System.out.println("equals");
        for (int j = number1; j < 2; j++) {
            if (number1 == j) {
                assertTrue(data.titleRecords[number1].equals(data.titleRecords[j]));
            } else {
                assertFalse(data.titleRecords[number1].equals(data.titleRecords[j]));
            }
        }
    }
   
    @Test
    public void testSearchRecord() {
        System.out.println("searchRecord");
        for (Record record1 : data.records) {
            Record record = titleRecord.searchRecord(record1);
            assertEquals(record, record1);
        }
    }

    @Test
    public void testSearchFreeTitle() {
        System.out.println("searchFreeTitle");
        for (int i = 0; i < data.recordsData.length; i++) {
            titleRecord.getRecords().get(i).setReservations((ArrayList) data.reservationList);
        }
        boolean result = titleRecord.searchFreeRecord(data.dates[1], LocalDate.MIN);
        assertTrue(result);
        result = titleRecord.searchFreeRecord(data.dates[1], data.dates[2]);
        assertFalse(result);
    }

}
