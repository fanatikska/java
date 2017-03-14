package ru.java.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.java.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by studenov-dv on 21.02.2017.
 */
public class EditContactTest extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){
        app.goTo().pageHome();
        if (app.contact().list().size() == 0){
            app.contact().create(new ContactData().withName("name").withLast_name("last_name")
                    .withNick_name("nickname").withTitle("title").withCompany("company").withAddress("address 80 / 5")
                    .withPhone_number("8-905-999-99-99").withEmail("e-mail@mail.ru").withGroup("stest1"), true);
            app.goTo().pageHome();
        }
    }

    @Test
    public  void testEditContactTest(){

        ContactData contact = new ContactData().withName("name5").withLast_name("last_name5")
                .withNick_name("nickname5").withTitle("title5").withCompany("company5").withAddress("address 55 / 5")
                .withPhone_number("8-905-555-55-55").withEmail("e-mail5@mail.ru").withGroup("stest1");
        List<ContactData> before = app.contact().list();
        app.contact().editContact(contact, 0);
        app.goTo().pageHome();
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(before.size(), after.size());
        before.remove(0);
        before.add(new ContactData().withName("name5").withLast_name("last_name5")
                .withNick_name("nickname5").withTitle("title5").withCompany("company5").withAddress("address 55 / 5")
                .withPhone_number("8-905-555-55-55").withEmail("e-mail5@mail.ru").withGroup("stest1").withId(0));
        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
      //  Assert.assertEquals(before, after);
    }

}
