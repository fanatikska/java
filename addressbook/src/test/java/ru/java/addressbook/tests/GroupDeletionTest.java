package ru.java.addressbook.tests;

import org.testng.annotations.Test;
import ru.java.addressbook.model.GroupData;

public class GroupDeletionTest extends TestBase{

    @Test
    public void testGroupDeletionTest() {

        app.getNavigationHelper().goToGroupPage();
        if (! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupData("rtest1","rtest2",null));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroup();
        app.getNavigationHelper().goToGroupPage();
    }


}
