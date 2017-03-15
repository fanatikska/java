package ru.java.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.java.addressbook.model.ContactData;
import ru.java.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by studenov-dv on 21.02.2017.
 */
public class EditContactTest extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){
        app.goTo().pageHome();
        if (app.contact().all().size() == 0){
            app.contact().create(new ContactData().withName("name").withLast_name("last_name")
                    .withNick_name("nickname").withTitle("title").withCompany("company").withAddress("address 80 / 5")
                    .withPhone_number("8-905-999-99-99").withEmail("e-mail@mail.ru").withGroup("stest1"), true);
            app.goTo().pageHome();
        }
    }

    @Test
    public  void testEditContactTest(){

        Contacts before = app.contact().all();
        ContactData modifyContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifyContact.getId()).withName("name5").withLast_name("last_name5")
                .withNick_name("nickname5").withTitle("title5").withCompany("company5").withAddress("address 55 / 5")
                .withPhone_number("8-905-555-55-55").withEmail("e-mail5@mail.ru").withGroup("stest1");
        app.contact().editContact(contact);
        app.goTo().pageHome();
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.without(modifyContact).withAdded(contact)));
    }

}
