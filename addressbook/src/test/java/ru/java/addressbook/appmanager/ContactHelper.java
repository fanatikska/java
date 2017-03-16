package ru.java.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.java.addressbook.model.ContactData;
import ru.java.addressbook.model.Contacts;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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


    public void select(Integer index) {
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

    public void create(ContactData contactData, Boolean bool) {
        fillContactForm(contactData, true);
        submitContactCreation();
        contactCache = null;
    }

    public int count() {
        return wd.findElements(By.cssSelector("tr[name='entry']")).size();
    }

    private Contacts contactCache = null;

    public Contacts all() {

        if (contactCache != null) {
            return new Contacts(contactCache);
        }

        contactCache = new Contacts();
        Set<ContactData> contacts = new HashSet<>();
        List<WebElement> elements = wd.findElements(By.cssSelector("tr[name='entry']"));
        for (WebElement element : elements) {
            Integer id = Integer.valueOf(element.findElement(By.cssSelector("td.center input")).getAttribute("value"));
            List<WebElement> cells = element.findElements(By.tagName("td"));
            String  last_name = String.valueOf(cells.get(1).getText());
            String name = String.valueOf(cells.get(2).getText());
            String allPhones = String.valueOf(cells.get(5).getText());
            String address = String.valueOf(cells.get(3).getText());
            String emailAddress = String.valueOf(cells.get(4).getText());
            ContactData contact = new ContactData().withId(id).withName(name).withLast_name(last_name)
                    .withallPhones(allPhones).withAddress(address).withEmail(emailAddress);

            contactCache.add(contact);
        }
        return new Contacts(contactCache);
    }

    public void editContact(ContactData contact) {
        enterEditSelectedContactById(contact.getId());
        fillContactForm(contact, false);
        submitEditSelectedContact();
        contactCache = null;
    }

    public void deleteContact(ContactData contact) {
        selectById(contact.getId());
        enterEditSelectedContactById(contact.getId());
        submitDeleteSelectedContact();
        contactCache = null;
    }

    private void enterEditSelectedContactById(int id) {
        wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
    }

    private void selectById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public ContactData infoFromEditForm(ContactData contact) {

        enterEditSelectedContactById(contact.getId());
        String home_number = wd.findElement(By.name("home")).getAttribute("value");
        String mobile_number = wd.findElement(By.name("mobile")).getAttribute("value");
        String work_number = wd.findElement(By.name ("work")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        String email_address = wd.findElement(By.name("email")).getAttribute("value");
        wd.navigate().back();

        return  new ContactData().withPhone_number(home_number)
                .withMobile_number(mobile_number).withWork_phone(work_number).withAddress(address)
                .withEmail(email_address);
    }

}



