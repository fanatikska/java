package ru.java.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.java.addressbook.model.ContactData;
import ru.java.addressbook.model.Contacts;
import ru.java.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by studenov-dv on 21.02.2017.
 */
public class EditContactTest extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){
        Groups groups = app.db().groups();
        System.out.println(groups);
        app.goTo().pageHome();
        if (app.db().contacts().size() == 0){
            app.contact().create(new ContactData().withName("name").withLast_name("last_name")
                    .withAddress("address 80 / 5")
                    .withPhone_number("8-905-999-99-99").withEmailAll("e-mail@mail.ru")
                    .inGroup((groups.iterator()).next()), true);
            app.goTo().pageHome();
        }
    }

    @Test
    public  void testEditContactTest(){

        Groups groups = app.db().groups();
        Contacts before = app.db().contacts();
        ContactData modifyContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifyContact.getId()).withName("name5")
                .withLast_name("last_name5").withCompany("company5").withAddress("address 55 / 5")
                .withPhone_number("8-905-555-55-55").withEmailAll("e-mail5@mail.ru")
                .inGroup((groups.iterator()).next());
        app.contact().editContact(contact);
        app.goTo().pageHome();
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.without(modifyContact).withAdded(contact)));
    }

}
