package ru.java.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.java.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTest extends TestBase{

    @Test
    public void testGroupDeletionTest() {

        app.getNavigationHelper().goToGroupPage();

        if (! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupData("rtest1","rtest2",null));
            app.getNavigationHelper().goToGroupPage();
        }
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(0);
        app.getGroupHelper().deleteSelectedGroup();
        app.getNavigationHelper().goToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(before.size() - 1 , after.size());
    }


}
