package ru.java.addressbook.tests;

import org.testng.annotations.Test;
import ru.java.addressbook.model.ContactData;
import ru.java.addressbook.model.Contacts;
import ru.java.addressbook.model.GroupData;
import ru.java.addressbook.model.Groups;

/**
 * Created by Studenov-DV on 29.03.2017.
 */
public class AddContactToGroup extends TestBase{

    @Test
    public void testAddContactToGroup(){
        app.goTo().pageHome();
        Contacts contacts = app.db().contacts();
        Groups group = app.db().groups();
        ContactData modifiedContact = contacts.iterator().next();
       GroupData addedGroup = group.iterator().next();
        app.contact().selectById(modifiedContact.getId());
        app.contact().checkGroup(addedGroup.getId());
    }
}
