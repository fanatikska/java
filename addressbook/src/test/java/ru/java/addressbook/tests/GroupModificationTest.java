package ru.java.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.java.addressbook.model.GroupData;
import ru.java.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.*;

public class GroupModificationTest extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {

        app.goTo().groupPage();
        if (app.db().groups().size() == 0){
            app.group().create(new GroupData().withName("rtest1").withHeader("rtest2"));
            app.goTo().groupPage();
        }
    }

    @Test
    public void GroupModificationTest() {
        Groups before = app.db().groups();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData().withId(modifiedGroup
                .getId()).withName("stest4").withHeader("stest5").withFooter("stest6");
        app.group().modification(group);
        app.goTo().groupPage();
        assertThat(app.group().count(), equalTo(before.size()));
        Groups after = app.db().groups();
        assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
        verifyGroupListInUI();
    }

}