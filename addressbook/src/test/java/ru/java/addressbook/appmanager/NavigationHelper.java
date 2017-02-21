package ru.java.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Studenov-DV on 21.02.2017.
 */
public class NavigationHelper {

    private FirefoxDriver wd;

    public NavigationHelper(FirefoxDriver wd) {
        this.wd = wd;
    }

    public void goToGroupPage() {
        wd.findElement(By.linkText("groups")).click();
    }
    public void goToAddContactPage() {
        wd.findElement(By.linkText("add new")).click();
    }

}
