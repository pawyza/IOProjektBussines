package tests_fitnesee_fixture;

import fit.ColumnFixture;
import java.util.IllegalFormatCodePointException;

public class Test_addRecord extends ColumnFixture {

    String titlerecord[];
    String record[];
    String result;
    String data;
    int number;

    public boolean addRecord_() {
        result = null;
        try {
            result = SetUp.facade.addRecord(titlerecord, record).get(0);
        } catch (NullPointerException|IllegalFormatCodePointException e) {
            return false;
        }

        data = SetUp.data.recordData[number];
        return data.equals(result);
    }
}
