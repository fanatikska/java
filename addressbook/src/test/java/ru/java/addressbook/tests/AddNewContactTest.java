package ru.java.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.java.addressbook.model.ContactData;
import ru.java.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class AddNewContactTest extends TestBase{


      @Test
    public void testAddNewContactTest() {
        ContactData contact = new ContactData("name", "last_name", "nickname", "title", "company", "address 80 / 5", "8-905-999-99-99", "e-mail@mail.ru", "stest1");
        app.getNavigationHelper().goToPageHome();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getNavigationHelper().goToAddContactPage();
        app.getContactHelper().createContact(contact, true);
        app.getNavigationHelper().goToPageHome();
          List<ContactData> after = app.getContactHelper().getContactList();
          Assert.assertEquals(before.size() + 1, after.size());

          before.add(contact);
          Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
          before.sort(byId);
          after.sort(byId);
          Assert.assertEquals(before, after);


      }
}
