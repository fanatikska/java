package ru.java.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.java.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class AddNewContactTest extends TestBase{


      @Test
    public void testAddNewContactTest() {
        ContactData contact = new ContactData().withName("name").withLast_name("last_name")
                .withNick_name("nickname").withTitle("title").withCompany("company").withAddress("address 80 / 5")
                .withPhone_number("8-905-999-99-99").withEmail("e-mail@mail.ru").withGroup("stest1");
        app.goTo().pageHome();
        List<ContactData> before = app.contact().list();
        app.goTo().addContactPage();
        app.contact().create(contact, true);
        app.goTo().pageHome();
          List<ContactData> after = app.contact().list();
          Assert.assertEquals(before.size() + 1, after.size());

          before.add(contact);
          Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
          before.sort(byId);
          after.sort(byId);
          Assert.assertEquals(before, after);


      }
}
