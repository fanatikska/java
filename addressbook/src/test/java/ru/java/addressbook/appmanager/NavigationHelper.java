package ru.java.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Studenov-DV on 21.02.2017.
 */
public class NavigationHelper extends BaseTest{

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void goToGroupPage() {
        if (isElementPresent(By.tagName("h1"))
                && isElementPresent(By.xpath("//div[@id='content']//h1[.='Groups']"))
                && wd.findElement(By.xpath("//div[@id='content']//h1[.='Groups']")).getText().equals("Groups")
                && isElementPresent(By.name("new")))
                 {
                     return;
        }

        click(By.linkText("groups"));

    }
    public void goToAddContactPage() {
        if (isElementPresent(By.tagName("h1"))
                && isElementPresent(By.xpath("//div[@id='content']//h1[.='Edit / add address book entry']"))
                && wd.findElement(By.xpath("//div[@id='content']//h1[.='Edit / add address book entry']")).getText().equals("Edit / add address book entry")
                && isElementPresent(By.name("submit")))
        {

            return;

        }

        click(By.linkText("add new"));
    }
    public void goToPageHome(){
        if (isElementPresent(By.id("maintable"))){
            return;
        }
        click(By.linkText("home"));

    }

}
