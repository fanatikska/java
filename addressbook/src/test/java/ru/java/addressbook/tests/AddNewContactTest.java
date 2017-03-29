package ru.java.addressbook.tests;

import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.java.addressbook.model.ContactData;
import ru.java.addressbook.model.Contacts;
import ru.java.addressbook.model.GroupData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.*;

public class AddNewContactTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContacts() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")));
        String xml = "";
        String line = reader.readLine();
        while (line != null){
            xml +=line;
            line = reader.readLine();
        }
        XStream xStream = new XStream();
        xStream.processAnnotations(ContactData.class);
        List<ContactData> contacts = (List<ContactData>) xStream.fromXML(xml);
        return contacts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();


    }

    @Test(dataProvider = "validContacts")
    public void testAddNewContactTest(ContactData contact) {
        app.goTo().pageHome();
        Contacts before = app.db().contacts();
        app.goTo().addContactPage();
        app.contact().create(contact, true);
        app.goTo().pageHome();
        assertEquals(app.contact().count(), before.size()+1);
        Contacts after = app.db().contacts();
        assertThat(after.size(), equalTo(before.size() + 1 ));
        assertThat(after, equalTo(before
                .withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }
}
