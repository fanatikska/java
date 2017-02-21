package ru.java.addressbook.tests;

import org.testng.annotations.Test;
import ru.java.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase{

    @Test
    public void testGroupCreation() {

        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("stest1", "stest2", "stest3"));
        app.getGroupHelper().submitGroupCreation();
        app.getNavigationHelper().goToGroupPage();
    }

}
