package ru.java.addressbook.tests;

import org.testng.annotations.Test;
import ru.java.addressbook.model.GroupData;

/**
 * Created by Studenov-DV on 20.02.2017.
 */
public class GroupModificationTest extends TestBase {

    @Test
    public void testGroupModification(){

        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().deleteSelectedGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("stest4", "stest5", "stest6"));
        app.getGroupHelper().submitGroupModification();
        app.getNavigationHelper().goToGroupPage();
    }

}
