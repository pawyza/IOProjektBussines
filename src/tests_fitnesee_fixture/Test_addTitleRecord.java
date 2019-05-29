package tests_fitnesee_fixture;

import fit.ColumnFixture;
import java.util.IllegalFormatCodePointException;

public class Test_addTitleRecord extends ColumnFixture {

    String dataintitlerecords[], data, result;
    int number;

    public boolean addTitleRecord_() {
        try {
            result = null;
            result = SetUp.facade.addTitleRecord(dataintitlerecords);
            data = SetUp.data.titleRecordData[number];

        } catch (IllegalFormatCodePointException e) {
            return false;
        }
        return data.equals(result);
    }
}
