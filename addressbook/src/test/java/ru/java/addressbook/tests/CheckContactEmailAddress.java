package ru.java.addressbook.tests;

import org.testng.annotations.Test;
import ru.java.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Studenov-DV on 16.03.2017.
 */
public class CheckContactEmailAddress extends TestBase{

    @Test
    public void testCheckContactEmailAddress(){
        app.goTo().pageHome();
        ContactData checkContact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(checkContact);
        if (checkContact.getEmailAll() != null){
            assertThat(checkContact.getEmailAll(), equalTo(mergePhones(contactInfoFromEditForm)));
        }
    }

    private String mergePhones(ContactData contact) {
        return Arrays.asList(contact.getEmail1(), contact.getEmail2(), contact.getEmail3()).stream()
                .filter((s) -> ! s.equals("")).collect(Collectors.joining("\n"));
    }
}
