package ru.java.addressbook.tests;

import org.testng.annotations.Test;

import java.security.PublicKey;

/**
 * Created by studenov-dv on 21.02.2017.
 */
public class DeleteContactTest extends TestBase{

    @Test
    public  void testDeleteContactTest(){
        app.getNavigationHelper().goToPageHome();
        app.getContactHelper().selectContact();
        app.getContactHelper().enterEditSelectedContact();
        app.getContactHelper().submitDeleteSelectedContact();
        app.getNavigationHelper().goToPageHome();
    }

}
