package ru.java.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by Studenov-DV on 20.02.2017.
 */
public class ContactDeleteTest extends TestBase {

    @Test
    public void contactDeleteTest(){

        app.getNavigationHelper().goToHomePage();
        app.getHomeHelper().selectContact();
        app.getHomeHelper().initContactDelete();
        app.getSessionHelper().windowHelper();
        app.getNavigationHelper().goToHomePage();
    }
}
