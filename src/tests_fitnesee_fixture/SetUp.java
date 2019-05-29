package tests_fitnesee_fixture;

import testdata.Data1;
import fit.Fixture;
import subbusinesstier.Facade;
import subbusinesstier.Factory;


public class SetUp extends Fixture {

    static Facade facade;
    static Factory factory;
    static Data1 data;

    public SetUp() {
        facade = new Facade();
        factory = new Factory();
        data = new Data1();
    }

}
