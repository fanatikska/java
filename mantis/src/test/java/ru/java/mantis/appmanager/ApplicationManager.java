package ru.java.mantis.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.internal.ElementScrollBehavior;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by Studenov-DV on 21.02.2017.
 */
public class ApplicationManager {

    private WebDriver wd;
    private String browser;
    private final Properties properties;
    private RegistrationHelper registrationHelper;
    private MailHelper mailHelper;
    private FtpHelper ftp;
    private DbHelper dbHelper;

    public ApplicationManager(String browser) {

        this.browser = browser;
        properties = new Properties();

    }

    public void init() throws IOException {

        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
        dbHelper = new DbHelper();


    }

    public HttpSession newSession(){
        return new HttpSession(this);
    }

    public String getProperty(String key){
        return properties.getProperty(key);
    }

    public void stop() {
        if (wd != null){
            wd.quit();
        }
    }


    public RegistrationHelper registration() {
        if (registrationHelper == null ){
            registrationHelper = new RegistrationHelper(this);
        }
            return registrationHelper;
    }

    public WebDriver getDriver() {
        if (wd == null){
            if (browser.equals(BrowserType.FIREFOX)){
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability(CapabilityType.ELEMENT_SCROLL_BEHAVIOR, ElementScrollBehavior.BOTTOM);
                wd = new FirefoxDriver(capabilities);
            } else if (browser.equals(BrowserType.CHROME)){
                wd = new ChromeDriver();
            } else if (browser.equals(BrowserType.IE)){
                wd = new InternetExplorerDriver();
            }

            wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            wd.get(properties.getProperty("web.baseUrl"));
        }
        return wd;
    }

    public MailHelper mail(){
        if(mailHelper == null) {
            mailHelper = new MailHelper(this);
        }
        return mailHelper;
    }

    public FtpHelper ftp(){
        if (ftp == null){
            ftp = new FtpHelper(this);
        }
        return ftp;
    }

    public DbHelper db(){
        return dbHelper;
    }
}
