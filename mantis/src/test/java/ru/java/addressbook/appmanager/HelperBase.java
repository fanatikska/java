package ru.java.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Studenov-DV on 03.04.2017.
 */
public class HelperBase {

    protected WebDriver wd;
    protected ApplicationManager app;

    public HelperBase(ApplicationManager app){
        this.app = app;
        this.wd = app.getDriver();
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        click(locator);
        if (text != null) {

            String existingText = wd.findElement(locator).getAttribute("value");
            if (!existingText.equals(text)) {
                wd.findElement(locator).clear();
                wd.findElement(locator).sendKeys(text);
            }

        }
    }
}
