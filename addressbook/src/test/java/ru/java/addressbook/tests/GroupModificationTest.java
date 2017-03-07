package ru.java.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.java.addressbook.appmanager.BaseTest;
import ru.java.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTest extends TestBase{



    @Test
    public void GroupModificationTest() {

        app.getNavigationHelper().goToGroupPage();
        if (! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupData("rtest1","rtest2",null));
            app.getNavigationHelper().goToGroupPage();
        }

        List<GroupData> before = app.getGroupHelper().getGroupList();
        GroupData group = new GroupData(before.get(0).getId(), "stest4", "stest5", "stest6");
        app.getGroupHelper().selectGroup(0);
        app.getGroupHelper().editSelectedGroup();
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitEditSelectedGroup();
        app.getNavigationHelper().goToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(before.size(), after.size());
        before.remove(0);
        before.add(group);

        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
    

}
