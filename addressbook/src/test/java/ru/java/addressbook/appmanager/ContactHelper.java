package ru.java.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.java.addressbook.model.ContactData;
import ru.java.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Studenov-DV on 21.02.2017.
 */
public class ContactHelper extends BaseTest {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitContactCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }


    public void fillContactForm(ContactData contactData, Boolean bool) {
        type(By.name("firstname"), contactData.getName());
        type(By.name("lastname"), contactData.getLast_name());
        type(By.name("nickname"), contactData.getNick_name());
        type(By.name("title"), contactData.getTitle());
        type(By.name("company"), contactData.getCompany());
        type(By.name("address"), contactData.getAddress());
        type(By.name("mobile"), contactData.getPhone_number());
        type(By.name("email"), contactData.getEmail());
        if (! bool) {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        } else if (bool
                && isElementPresent(By.name("new_group"))){
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
           }

        }


    public void selectContact(){
        click(By.name("selected[]"));
    }

    public void enterEditSelectedContact(){
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public void submitEditSelectedContact() {
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }

    public void submitDeleteSelectedContact() {
        click(By.xpath("//div[@id='content']/form[2]/input[2]"));
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public void createContact(ContactData contactData, Boolean bool) {
        fillContactForm(contactData, true);
        submitContactCreation();
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<GroupData> getContactList () {
        List<GroupData> groups = new ArrayList<GroupData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for(WebElement element : elements){
            String name = element.getText();
            GroupData group = new GroupData("name", null, null);
            groups.add(group);
        }
        return groups;
    }
}
