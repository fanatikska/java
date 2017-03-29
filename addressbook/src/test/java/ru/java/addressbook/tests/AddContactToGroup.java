package ru.java.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.java.addressbook.model.ContactData;
import ru.java.addressbook.model.Contacts;
import ru.java.addressbook.model.GroupData;
import ru.java.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Studenov-DV on 29.03.2017.
 */
public class AddContactToGroup extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        Groups groups = app.db().groups();
        app.goTo().pageHome();
        if (app.db().contacts().size() == 0) {

            app.contact().create(new ContactData().withName("name").withLast_name("last_name")
                    .withAddress("address 80 / 5")
                    .withPhone_number("8-905-999-99-99").withEmailAll("e-mail@mail.ru")
                    .inGroup(groups.iterator().next()), true);
            app.goTo().pageHome();
        }
        if (app.db().groups().size() == 0){
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("rtest1").withHeader("rtest2"));
            app.goTo().groupPage();
        }
    }

    @Test
    public void testAddContactToGroup(){
        Contacts before = app.db().contacts();
        app.goTo().pageHome();
        Groups group = app.db().groups();
        ContactData modifiedContact = before.iterator().next();
       GroupData addedGroup = group.iterator().next();
        app.contact().selectById(modifiedContact.getId());
        app.contact().addGroupToContact(addedGroup.getId());
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(modifiedContact.inGroup(addedGroup))));
    }
}
