package ru.java.addressbook.appmanager;

import com.sun.rowset.internal.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

/**
 * Created by studenov-dv on 21.02.2017.
 */
public class BaseTest {


    protected WebDriver wd;


    public BaseTest(WebDriver wd) {
        this.wd = wd;
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        if (text != null) {

            String existingText = wd.findElement(locator).getAttribute("value");
            if (!existingText.equals(text)) {
                wd.findElement(locator).click();
                wd.findElement(locator).clear();
                wd.findElement(locator).sendKeys(text);
            }

        }
    }

    public boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    protected boolean isElementPresent(By locator) {

        try{
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException ex){
            return false;
        }

    }
}
