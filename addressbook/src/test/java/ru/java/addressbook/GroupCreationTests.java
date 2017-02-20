package ru.java.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase{

    @Test
    public void testGroupCreation() {

        goToGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("stest1", "stest2", "stest3"));
        submitGroupCreation();
        goToGroupPage();
    }

}
