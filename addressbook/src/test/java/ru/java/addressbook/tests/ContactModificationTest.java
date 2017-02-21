package ru.java.addressbook.tests;

import org.testng.annotations.Test;
import ru.java.addressbook.model.ContactData;

/**
 * Created by Studenov-DV on 20.02.2017.
 */
public class ContactModificationTest extends TestBase{

    @Test
    public void contactModificationTest(){

    app.getNavigationHelper().goToHomePage();
    app.gethomeHelper().selectContact();
    app.gethomeHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("name1", "last_name1", "nickname1", "title1", "company1", "address 80 / 51", "8-905-999-99-11", "e-mail1@mail.ru"));
    app.getContactHelper().submitContactCreation();
    }
}
