package ru.java.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

/**
 * Created by Studenov-DV on 21.02.2017.
 */
public class ApplicationManager {

    WebDriver wd;

    private GroupHelper groupHelper;
    private ContactHelper contactHelper;
    private NavigationHelper navigationHelper;
    private SystemHelper systemHelper;
    private String browser;

    public ApplicationManager(String browser) {

        this.browser = browser;
    }

    public void init() {

        if (browser.equals(BrowserType.FIREFOX)){
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)){
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.IE)){
            wd = new InternetExplorerDriver();
        }

        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://localhost:8080/addressbook/");
        groupHelper = new GroupHelper(wd);
        contactHelper = new ContactHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        systemHelper = new SystemHelper(wd);
        systemHelper.login("admin", "secret");
    }


    public void stop() {
        wd.quit();
    }


    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public SystemHelper getSystemHelper() {
        return systemHelper;
    }
}
