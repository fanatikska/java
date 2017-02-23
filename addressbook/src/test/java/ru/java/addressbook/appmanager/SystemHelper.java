package ru.java.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Studenov-DV on 21.02.2017.
 */
public class SystemHelper extends BaseTest{

    public SystemHelper(WebDriver wd) {
        super(wd);
    }

    public void login(String login, String password) {
        type(By.name("user"), login);
        type(By.name("pass"), password);
        click(By.xpath("//form[@id='LoginForm']/input[3]"));
    }

}
