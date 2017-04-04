package ru.java.mantis.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.java.mantis.model.UsersData;

import java.io.IOException;
import java.util.HashSet;

/**
 * Created by Studenov-DV on 04.04.2017.
 */
public class ChangePasswordOfUserTest extends TestBase{

 /*     @BeforeMethod
    public void ensurePrecondition() throws IOException {

      if (app.db().users().size() == 0){
            app.registration().createNewUser();
        }
    }*/

    @Test
    public void testChangePasswordOfUser() throws IOException {

        app.registration().enterUsersAdministrator();
        app.registration().click(By.cssSelector("i.fa-gears"));
        HashSet<UsersData> before = app.db().users();
        UsersData modifiedUser = before.iterator().next();
    }
}
