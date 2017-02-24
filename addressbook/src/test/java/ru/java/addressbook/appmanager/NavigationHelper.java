package ru.java.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.java.addressbook.tests.TestClass;

/**
 * Created by Studenov-DV on 21.02.2017.
 */
public class NavigationHelper extends BaseTest{

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void goToGroupPage() {
        if (isElementPresent(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresent(By.name("new")))
                 {
                     System.out.println("Переход на страницу не осуществляется");
            return;
        }
        System.out.println("Происходит переход на страницу!");
        click(By.linkText("groups"));
    }
    public void goToAddContactPage() {
        click(By.linkText("add new"));
    }
    public void goToPageHome(){
        click(By.linkText("home"));

    }

}
