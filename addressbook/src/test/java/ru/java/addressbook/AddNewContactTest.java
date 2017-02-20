package ru.java.addressbook;

import org.testng.annotations.Test;

public class AddNewContactTest extends TestBase{

    @Test
    public void testAddNewContactTest() {

        goToAddContactPage();
        fillContactForm(new ContactData("name", "last_name", "nickname", "title", "company", "address 80 / 5", "8-905-999-99-99", "e-mail@mail.ru"));
        submitContactCreation();
    }


}
