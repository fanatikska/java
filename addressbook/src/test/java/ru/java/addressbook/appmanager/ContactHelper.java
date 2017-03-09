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
        if (!bool) {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        } else if (bool
                && isElementPresent(By.name("new_group"))) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        }

    }


    public void selectContact(Integer index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void enterEditSelectedContact(int index) {
        wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img")).get(index).click();
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
        return wd.findElements(By.cssSelector("tr")).size();
    }

    public List<ContactData> getContactList() {
        String last_name;
        String name;
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("tr[name='entry']"));
        List<WebElement> elements2 = wd.findElements(By.cssSelector("tr[name='entry'] > td"));
        for (WebElement element : elements) {
            Integer id = Integer.valueOf(element.findElement(By.cssSelector("td.center input")).getAttribute("value"));
            for(int i=0; i<elements2.size(); i++){
               if((i==1) || (i % 11 == 0)){
                    last_name = String.valueOf(elements2.get(i));
                   ContactData contact = new ContactData(id, "name", "last_name", null, null, null, null, null, null, null);
                }
                if ((i==2) || (i % 12 == 0)){
                   name = String.valueOf(elements2.get(i));
                    ContactData contact = new ContactData(id, "name", "last_name", null, null, null, null, null, null, null);
                }
                contacts.add(contact);
            }



        }
        return contacts;
    }


}



