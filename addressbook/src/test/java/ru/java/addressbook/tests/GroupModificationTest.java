package ru.java.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.java.addressbook.appmanager.BaseTest;
import ru.java.addressbook.model.GroupData;

public class GroupModificationTest extends TestBase{



    @Test
    public void GroupModificationTest() {

        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().selectGroup();

     /*   if (!wd.findElement(By.name("selected[]")).isSelected()) {
            wd.findElement(By.name("selected[]")).click();*/

        app.getGroupHelper().editSelectedGroup();
        app.getGroupHelper().fillGroupForm(new GroupData("stest4", "stest5", "stest6"));
        app.getGroupHelper().submitEditSelectedGroup();
        app.getNavigationHelper().goToGroupPage();

    }
    

}
