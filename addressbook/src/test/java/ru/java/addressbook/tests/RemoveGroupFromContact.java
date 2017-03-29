package ru.java.addressbook.tests;

import org.openqa.selenium.By;
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
public class RemoveGroupFromContact extends TestBase{

    @Test
    public void testRemoveGroupFromContact(){

        Contacts before = app.db().contacts();
        app.goTo().pageHome();
        ContactData modifiedContact = before.iterator().next();
        GroupData removeGroup = modifiedContact.getGroups().iterator().next();
        app.contact().removeGroupFromContact(removeGroup.getId());
        app.contact().selectById(modifiedContact.getId());
        app.contact().click(By.cssSelector("input[name='remove']"));
        Contacts after = app.db().contacts();
        after.remove(modifiedContact);
        ContactData modifiedContact2 = new ContactData();
        for(ContactData contact : before) {
            if (contact.equals(modifiedContact)) {
                contact.getGroups().remove(removeGroup);
                after.add(contact);
            }
        }
        modifiedContact2.getGroups().remove(removeGroup);
        System.out.println(modifiedContact2);

        assertThat(after, equalTo(before));
    }
}
