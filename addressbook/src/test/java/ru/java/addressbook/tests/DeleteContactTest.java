package ru.java.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.java.addressbook.model.ContactData;

import java.util.List;
import java.util.Set;

/**
 * Created by studenov-dv on 21.02.2017.
 */
public class DeleteContactTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        app.goTo().pageHome();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData().withName("name").withLast_name("last_name")
                    .withNick_name("nickname").withTitle("title").withCompany("company").withAddress("address 80 / 5")
                    .withPhone_number("8-905-999-99-99").withEmail("e-mail@mail.ru").withGroup("stest1"), true);
            app.goTo().pageHome();
        }
    }

    @Test
    public void testDeleteContactTest() {

        Set<ContactData> before = app.contact().all();
        ContactData deleteContact = before.iterator().next();
        app.contact().deleteContact(deleteContact);
        app.goTo().pageHome();
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(before.size() - 1, after.size());
        before.remove(deleteContact);
        Assert.assertEquals(before, after);
    }

}
