package ru.java.addressbook.tests;

import org.openqa.selenium.By;
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
public class RemoveGroupFromContact extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {

        Contacts contacts = app.db().contacts();
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
        }
        for(ContactData contact : contacts) {
            if (contact.getGroups().size() == 0) {
                app.goTo().pageHome();
                ContactData modifiedContact = contacts.iterator().next();
                GroupData addedGroup = groups.iterator().next();
                app.contact().selectById(modifiedContact.getId());
                app.contact().addGroupToContact(addedGroup.getId());
            }
        }
    }

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
