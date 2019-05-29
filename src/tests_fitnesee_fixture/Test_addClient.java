package tests_fitnesee_fixture;

import fit.ColumnFixture;

public class Test_addClient extends ColumnFixture {

    String datainclients[], data, result;
    int number;

    public boolean addClient_() {
        result = null;
        result = SetUp.facade.addClient(datainclients);
       System.out.print(number);
        data = SetUp.data.clientData[number];
        return data.equals(result);
    }

}
