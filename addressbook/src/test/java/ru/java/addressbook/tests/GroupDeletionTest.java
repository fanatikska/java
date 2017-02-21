package ru.java.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase{

    @Test
    public void testGroupDeletion() {
        app.goToGroupPage();
        app.selectGroup();
        app.deleteSelectedGroup();
        app.goToGroupPage();
    }


}
