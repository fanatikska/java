package ru.java.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.java.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTest extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        app.goTo().groupPage();
        if (app.group().list().size() == 0){
            app.group().create(new GroupData().withName("rtest1").withHeader("rtest2"));
            app.goTo().groupPage();
        }
    }

    @Test
    public void GroupModificationTest() {
        List<GroupData> before = app.group().list();
        GroupData group = new GroupData().withId(before.get(0)
                .getId()).withName("stest4").withHeader("stest5").withFooter("stest6");
        app.group().modification(group, 0);
        app.goTo().groupPage();
        List<GroupData> after = app.group().list();
        Assert.assertEquals(before.size(), after.size());
        before.remove(0);
        before.add(group);

        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }



}
