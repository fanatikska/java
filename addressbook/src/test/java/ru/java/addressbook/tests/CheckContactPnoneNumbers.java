package ru.java.addressbook.tests;

import org.testng.annotations.Test;
import ru.java.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Studenov-DV on 15.03.2017.
 */
public class CheckContactPnoneNumbers extends TestBase{

    @Test
    public void testCheckContactPnoneNumbers() {

        app.goTo().pageHome();
        ContactData checkContact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(checkContact);
        if (checkContact.getallPhones() != null){
            assertThat(checkContact.getallPhones(), equalTo((mergePhones(contactInfoFromEditForm))));
        }
    }

    private String mergePhones(ContactData contact) {

        System.out.println(contact.getPhone_number());
        System.out.println(contact.getMobile_number());
        System.out.println(contact.getWork_phone());
        System.out.println(contact.getallPhones());


        return Arrays.asList(contact.getPhone_number(), contact.getMobile_number(), contact.getWork_phone()).stream()
        .filter((s) -> ! s.equals("")).map(CheckContactPnoneNumbers::cleaned).collect(Collectors.joining("\n"));
    }

    public static String cleaned (String phone){
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }

}
