package ru.java.addressbook.tests;

import org.testng.annotations.Test;
import ru.java.addressbook.model.ContactData;

/**
 * Created by studenov-dv on 21.02.2017.
 */
public class EditContactTest extends TestBase{

    @Test
    public  void testEditContactTest(){
        app.getNavigationHelper().goToPageHome();
        app.getContactHelper().selectContact();
        app.getContactHelper().enterEditSelectedContact();
        app.getContactHelper().fillContactForm(new ContactData("name1", "last_name1", "nickname1", "title1", "company1", "address1 80 / 5", "1-111-111-11-11", "e-mail1@mail.ru"));
        app.getContactHelper().submitEditSelectedContact();
        app.getNavigationHelper().goToPageHome();
    }
}
