package ru.java.addressbook.tests;

import org.testng.annotations.Test;
import ru.java.addressbook.model.ContactData;

public class AddNewContactTest extends TestBase{

    @Test
    public void testAddNewContactTest() {

        app.getNavigationHelper().goToAddContactPage();
        app.getContactHelper().fillContactForm(new ContactData("name", "last_name", "nickname", "title", "company", "address 80 / 5", "8-905-999-99-99", "e-mail@mail.ru"));
        app.getContactHelper().submitContactCreation();
    }


}
