package ru.java.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Studenov-DV on 20.02.2017.
 */
public class HomeHelper extends BaseHelper{

    public HomeHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void selectContact() {
        click(By.id("1"));

    }

    public void initContactModification() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }
}
