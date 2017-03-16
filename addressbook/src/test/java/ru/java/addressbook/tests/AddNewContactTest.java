package ru.java.addressbook.tests;

import org.testng.annotations.Test;
import ru.java.addressbook.model.ContactData;
import ru.java.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.*;

public class AddNewContactTest extends TestBase {


    @Test
    public void testAddNewContactTest() {
        ContactData contact = new ContactData().withName("name").withLast_name("last_name")
                .withNick_name("nickname").withTitle("title").withCompany("company").withAddress("address 80 / 5")
                .withPhone_number("8-905-999-99-99").withEmailAll("e-mail@mail.ru").withGroup("stest1");
        app.goTo().pageHome();
        Contacts before = app.contact().all();
        app.goTo().addContactPage();
        app.contact().create(contact, true);
        app.goTo().pageHome();
        assertEquals(app.contact().count(), before.size()+1);
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() + 1 ));
        assertThat(after, equalTo(before
                .withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }
}
