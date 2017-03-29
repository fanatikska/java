package ru.java.addressbook.tests;

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
