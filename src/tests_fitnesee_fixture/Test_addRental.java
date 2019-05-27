package tests_fitnesee_fixture;

import fit.ColumnFixture;

public class Test_addRental extends ColumnFixture {

    String client[],result, data;
    int number, id;
    float daycost;

    public boolean addRental_() {
        result = null;
        result = SetUp.facade.addRental(client, id, daycost);
        if (result.equals("rented")){
        return true;
        }
        return false;
    }
}
