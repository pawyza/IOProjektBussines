package tests_fitnesee_fixture;

import fit.ColumnFixture;
import java.time.LocalDate;

public class Test_addReservation extends ColumnFixture {

    String titlerecord[], client[], result;
    int number, id, date1[], date2[];

    public boolean addReservation_() {
        result = null;
        result = SetUp.facade.addReservation(titlerecord, client, id, LocalDate.of(date1[0], date1[1], date1[2]), LocalDate.of(date2[0], date2[1], date2[2]));
        
        if (result.equals("reserved")) {
            return true;
        }
        return false;

    }
}
