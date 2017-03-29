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

        System.out.println(contactData.getHome_phone());
        System.out.println(contactData.getWork_phone());
        type(By.name("firstname"), contactData.getName());
        type(By.name("lastname"), contactData.getLast_name());
        type(By.name("company"), contactData.getCompany());
        type(By.name("address"), contactData.getAddress());
        type(By.name("mobile"), contactData.getMobile_number());
        type(By.name("email"), checkNull(contactData.getEmail1()));
        type(By.name("home"), checkNull(contactData.getHome_phone()));
        type(By.name("work"), checkNull(contactData.getWork_phone()));
        type(By.name("work"), checkNull(contactData.getWork_phone()));
        type(By.name("email2"), checkNull(contactData.getEmail2()));
        type(By.name("email3"), checkNull(contactData.getEmail3()));
/*        if (!bool) {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        } else if (contactData.inGroup() != ""
                || contactData.inGroup() == null) {
            Assert.assertTrue(isElementPresent(By.name("new_group")));
        } else if (bool
                && isElementPresent(By.name("new_group"))) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.inGroup());
        }*/

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
                    .withallPhones(allPhones).withAddress(address).withEmailAll(emailAddress);

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

    public void enterEditSelectedContactById(int id) {
        wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
    }

    private void enterDetailsSelectedContactById(int id) {
        wd.findElement(By.cssSelector("a[href='view.php?id=" + id + "']")).click();
    }

    public void selectById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public ContactData infoFromDetailForm (ContactData contact){

            enterDetailsSelectedContactById(contact.getId());
            String info = wd.findElement(By.cssSelector("div#content")).getText();
            wd.navigate().back();
            return  new ContactData().withInfo(info);
        }

    public ContactData infoFromEditForm(ContactData contact) {

        enterEditSelectedContactById(contact.getId());
        String name = wd.findElement(By.name("firstname")).getAttribute("value");
        String last_name = wd.findElement(By.name("lastname")).getAttribute("value");
        String home_number = wd.findElement(By.name("home")).getAttribute("value");
        String mobile_number = wd.findElement(By.name("mobile")).getAttribute("value");
        String work_number = wd.findElement(By.name ("work")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        String email_address1 = wd.findElement(By.name("email")).getAttribute("value");
        String email_address2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email_address3 = wd.findElement(By.name("email3")).getAttribute("value");
        String company = wd.findElement(By.name("company")).getAttribute("value");
        wd.navigate().back();

        return  new ContactData().withPhone_number(home_number).withName(name).withLast_name(last_name).withCompany(company)
                .withMobile_number(mobile_number).withWork_phone(work_number).withAddress(address)
                .withEmail1(email_address1).withEmail2(email_address2).withEmail3(email_address3);
    }

    public String checkNull(String field){
        if (field != null) return field;
        else return "";
    }

    public void checkGroup(int id) {
        wd.findElement(By.cssSelector("select[name='to_group']>option[value='" + id + "']")).click();
        click(By.cssSelector("input[name='add']"));
    }
}



