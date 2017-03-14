package ru.java.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.java.addressbook.model.ContactData;

import java.util.List;

/**
 * Created by studenov-dv on 21.02.2017.
 */
public class DeleteContactTest extends TestBase{

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
    public  void testDeleteContactTest(){

        List<ContactData> before = app.contact().list();
        app.contact().deleteContact(0);
        app.goTo().pageHome();
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(before.size() - 1, after.size());
        before.remove(0);
        Assert.assertEquals(before,after);
    }

}
