package ru.java.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.java.addressbook.model.GroupData;
import ru.java.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        GroupData group = new GroupData().withId(id).withName(name);
        groups.add(group);

        }
        return groups;
    }

    public Groups all() {
        Groups groups = new Groups();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for(WebElement element : elements){
            String name = element.getText();
            Integer id = Integer.valueOf(element.findElement(By.tagName("input")).getAttribute("value"));
            GroupData group = new GroupData().withId(id).withName(name);
            groups.add(group);

        }
        return groups;
    }

    public void modification(GroupData group) {
        selectById(group.getId());
        editSelectedGroup();
        fillGroupForm(group);
        submitEditSelectedGroup();
        }

    public void deletionGroup(int index) {
        select(index);
        deleteSelectedGroup();
    }

    public void delete(GroupData group) {
        selectById(group.getId());
        deleteSelectedGroup();
    }

    private void selectById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }
}
