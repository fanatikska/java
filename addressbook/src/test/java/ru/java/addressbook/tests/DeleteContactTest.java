package ru.java.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.java.addressbook.model.ContactData;
import ru.java.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

/**
 * Created by studenov-dv on 21.02.2017.
 */
public class DeleteContactTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        app.goTo().pageHome();
 /*       if (app.db().contacts().size() == 0) {
            app.contact().create(new ContactData().withName("name").withLast_name("last_name")
                    .withAddress("address 80 / 5")
                    .withPhone_number("8-905-999-99-99").withEmailAll("e-mail@mail.ru").inGroup("stest1"), true);
            app.goTo().pageHome();
        }*/
    }

    @Test
    public void testDeleteContactTest() {

            Contacts before = app.db().contacts();
            ContactData deleteContact = before.iterator().next();
            app.contact().deleteContact(deleteContact);
            app.goTo().pageHome();
            int f = app.contact().count();
            assertThat(app.contact().count(), equalTo(before.size() - 1));
            Contacts after = app.db().contacts();
            assertThat(after, equalTo(before.without(deleteContact)));

    }
}
