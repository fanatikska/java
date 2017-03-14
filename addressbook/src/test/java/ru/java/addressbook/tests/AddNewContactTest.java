package ru.java.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.java.addressbook.model.ContactData;

import java.util.Set;

public class AddNewContactTest extends TestBase {


    @Test
    public void testAddNewContactTest() {
        ContactData contact = new ContactData().withName("name").withLast_name("last_name")
                .withNick_name("nickname").withTitle("title").withCompany("company").withAddress("address 80 / 5")
                .withPhone_number("8-905-999-99-99").withEmail("e-mail@mail.ru").withGroup("stest1");
        app.goTo().pageHome();
        Set<ContactData> before = app.contact().all();
        app.goTo().addContactPage();
        app.contact().create(contact, true);
        app.goTo().pageHome();
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(before.size() + 1, after.size());
        contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before, after);
    }
}
