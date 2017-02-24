package ru.java.addressbook.tests;

import org.testng.annotations.Test;
import ru.java.addressbook.model.ContactData;
import ru.java.addressbook.model.GroupData;

import java.security.PublicKey;

/**
 * Created by studenov-dv on 21.02.2017.
 */
public class DeleteContactTest extends TestBase{

    @Test
    public  void testDeleteContactTest(){
        app.getNavigationHelper().goToPageHome();
        if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData("name", "last_name", "nickname", "title", "company", "address 80 / 5", "8-905-999-99-99", "e-mail@mail.ru", "stest1"), true);
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().enterEditSelectedContact();
        app.getContactHelper().submitDeleteSelectedContact();
        app.getNavigationHelper().goToPageHome();
    }

}
