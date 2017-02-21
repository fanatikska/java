package ru.java.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Studenov-DV on 21.02.2017.
 */
public class NavigationHelper extends BaseTest{

    public NavigationHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void goToGroupPage() {
        click(By.linkText("groups"));
    }
    public void goToAddContactPage() {
        click(By.linkText("add new"));
    }
    public void goToPageHome(){
        click(By.linkText("home"));

    }

}
