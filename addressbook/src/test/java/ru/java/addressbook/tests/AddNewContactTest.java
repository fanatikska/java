package ru.java.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.java.addressbook.model.ContactData;

import java.util.List;

public class AddNewContactTest extends TestBase{


      @Test
    public void testAddNewContactTest() {

        app.getNavigationHelper().goToPageHome();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getNavigationHelper().goToAddContactPage();
        app.getContactHelper().createContact(new ContactData("name", "last_name", "nickname", "title", "company", "address 80 / 5", "8-905-999-99-99", "e-mail@mail.ru", "stest1"), true);
        app.getNavigationHelper().goToPageHome();
          List<ContactData> after = app.getContactHelper().getContactList();
          Assert.assertEquals(before.size() + 1, after.size());
          System.out.println("size" + before.size());
      }


}
