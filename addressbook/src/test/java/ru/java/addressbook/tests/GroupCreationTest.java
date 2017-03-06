package ru.java.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.java.addressbook.model.GroupData;

import java.util.List;

public class GroupCreationTest extends TestBase{

    @Test
    public void testGroupCreation() {

        app.getNavigationHelper().goToGroupPage();
        List<GroupData> before = app.getGroupHelper().getGroupList();

        app.getGroupHelper().createGroup(new GroupData("stest1", "step2", "stest3"));
        app.getNavigationHelper().goToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();

        Assert.assertEquals(before.size() + 1, after.size());
    }

}
