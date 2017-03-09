package ru.java.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.java.addressbook.model.ContactData;
import ru.java.addressbook.model.GroupData;

import java.security.PublicKey;
import java.util.List;

/**
 * Created by studenov-dv on 21.02.2017.
 */
public class DeleteContactTest extends TestBase{

    @Test
    public  void testDeleteContactTest(){
        app.getNavigationHelper().goToPageHome();

        if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData("name", "last_name", "nickname", "title", "company", "address 80 / 5", "8-905-999-99-99", "e-mail@mail.ru", "stest1"), true);
            app.getNavigationHelper().goToPageHome();
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(0);
        app.getContactHelper().enterEditSelectedContact(0);
        app.getContactHelper().submitDeleteSelectedContact();
        app.getNavigationHelper().goToPageHome();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(before.size() - 1, after.size());
        before.remove(0);
        Assert.assertEquals(before,after);
    }

}
