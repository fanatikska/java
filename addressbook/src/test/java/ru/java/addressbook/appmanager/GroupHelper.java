package ru.java.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.java.addressbook.model.GroupData;

/**
 * Created by Studenov-DV on 21.02.2017.
 */
public class GroupHelper extends BaseTest{

    private FirefoxDriver wd;

    public GroupHelper(FirefoxDriver wd) {
        this.wd = wd;
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    private void click(By locator) {
        wd.findElement(locator).click();
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
        }

    private void type(By locator, String text) {
        wd.findElement(locator).click();
        wd.findElement(By.name("group_name")).clear();
        wd.findElement(By.name("group_name")).sendKeys(text);
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
}
