package ru.java.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.java.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTest extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        app.goTo().groupPage();
        if (app.group().list().size() == 0){
            app.group().create(new GroupData().withName("rtest1").withHeader("rtest2"));
            app.goTo().groupPage();
        }
    }

    @Test
    public void testGroupDeletionTest() {

        List<GroupData> before = app.group().list();
        app.group().deletionGroup(0);
        app.goTo().groupPage();
        List<GroupData> after = app.group().list();
        Assert.assertEquals(before.size() - 1 , after.size());
        before.remove(0);
        Assert.assertEquals(before, after);
    }

}
