package ru.java.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.java.addressbook.model.GroupData;

/**
 * Created by Studenov-DV on 21.02.2017.
 */
public class GroupHelper extends BaseTest{

    public GroupHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
        }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void deleteSelectedGroup() {
        click(By.name("delete"));
    }

    public void selectGroup() {
        click(By.name("selected[]"));
    }
    public void editSelectedGroup(){
        click(By.name("edit"));
    }
    public void submitEditSelectedGroup(){
        click(By.name("update"));
    }
}
