package ru.java.addressbook.tests;

import org.testng.annotations.Test;
import ru.java.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Studenov-DV on 16.03.2017.
 */
public class CheckContactAddress extends TestBase{

    @Test
    public void testCheckContactAddress(){
        app.goTo().pageHome();
        ContactData checkContact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(checkContact);
        if (checkContact.getAddress() != null){
            assertThat(checkContact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
        }
    }
}
