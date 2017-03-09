package ru.java.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.java.addressbook.model.ContactData;
import ru.java.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by studenov-dv on 21.02.2017.
 */
public class EditContactTest extends TestBase{

    @Test
    public  void testEditContactTest(){
        app.getNavigationHelper().goToPageHome();
        ContactData contact = new ContactData("name", "last_name", "nickname", "title", "company", "address 80 / 5", "8-905-999-99-99", "e-mail@mail.ru", "stest1");
        if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(contact, true);
            app.getNavigationHelper().goToPageHome();
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().enterEditSelectedContact(0);
        app.getContactHelper().fillContactForm(contact, false);
        app.getContactHelper().submitEditSelectedContact();
        app.getNavigationHelper().goToPageHome();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(before.size(), after.size());
        before.remove(0);
        before.add(contact);
        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
