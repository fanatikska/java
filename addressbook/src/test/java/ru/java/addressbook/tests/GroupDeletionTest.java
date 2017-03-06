package ru.java.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.java.addressbook.model.GroupData;

public class GroupDeletionTest extends TestBase{

    @Test
    public void testGroupDeletionTest() {

        app.getNavigationHelper().goToGroupPage();

        if (! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupData("rtest1","rtest2",null));
            app.getNavigationHelper().goToGroupPage();
        }
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().selectGroup(0);
        app.getGroupHelper().deleteSelectedGroup();
        app.getNavigationHelper().goToGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(before - 1 , after);
    }


}
