package ru.java.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by studenov-dv on 24.02.2017.
 */
public class TestClass extends TestBase{



    @Test
    public void testTestClass(){
        app.goTo().addContactPage();
        app.goTo().pageHome();
        app.goTo().pageHome();

    }

}
