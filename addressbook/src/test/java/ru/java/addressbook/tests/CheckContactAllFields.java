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
public class CheckContactAllFields extends TestBase {

    @Test
    public void testCheckContactEmailAddress() {
        app.goTo().pageHome();
        ContactData checkContact = app.contact().all().iterator().next();
        ContactData contactInfoFromDetailForm = app.contact().infoFromDetailForm(checkContact);
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(checkContact);
        String a = cleaned(contactInfoFromDetailForm.getInfo());
        String b = mergeInfo(contactInfoFromEditForm);
        if (contactInfoFromDetailForm.getInfo() != null) {
            assertThat(cleaned(contactInfoFromDetailForm.getInfo()), equalTo(mergeInfo(contactInfoFromEditForm)));
        }

    }

    public static String cleaned(String allInfo) {
        return allInfo.replaceAll("\\s", "").replaceAll("[-()]", "").replace("M:", "").replaceAll("Memberof.*","")
                .replace("H:","").replace("W:","");
    }


    private String mergeInfo(ContactData contact) {
        return Arrays.asList(contact.getName(), contact.getLast_name(), contact.getCompany(), contact.getAddress(),
                contact.getHome_phone(), contact.getMobile_number(), contact.getWork_phone(),
                contact.getEmail1(), contact.getEmail2(), contact.getEmail3()).stream()
                .filter((s) -> ! s.equals("")).map(CheckContactPnoneNumbers::cleaned).collect(Collectors.joining(""));
    }
}
