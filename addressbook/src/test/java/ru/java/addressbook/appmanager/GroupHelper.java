package ru.java.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.java.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Studenov-DV on 21.02.2017.
 */
public class GroupHelper extends BaseTest{

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
        }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void deleteSelectedGroup() {
        click(By.name("delete"));
    }

    public void select(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }
    public void editSelectedGroup(){
        click(By.name("edit"));
    }
    public void submitEditSelectedGroup(){
        click(By.name("update"));
    }

    public void create(GroupData groupData) {
        initGroupCreation();
        fillGroupForm(groupData);
        submitGroupCreation();
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getGroupCount() {
        return  wd.findElements(By.name("selected[]")).size();
    }

    public List<GroupData> list() {
        List<GroupData> groups = new ArrayList<GroupData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for(WebElement element : elements){
        String name = element.getText();
        Integer id = Integer.valueOf(element.findElement(By.tagName("input")).getAttribute("value"));
        GroupData group = new GroupData(id, name, null, null);
        groups.add(group);

        }
        return groups;
    }

    public void modification(GroupData group, int index) {
        select(index);
        editSelectedGroup();
        fillGroupForm(group);
        submitEditSelectedGroup();
        }

    public void deletionGroup(int index) {
        select(index);
        deleteSelectedGroup();
    }

}
