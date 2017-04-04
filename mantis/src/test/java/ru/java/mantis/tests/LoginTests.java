package ru.java.mantis.tests;

import org.testng.annotations.Test;
import ru.java.mantis.appmanager.HttpSession;

import java.io.IOException;
import static org.testng.Assert.assertTrue;

/**
 * Created by Studenov-DV on 31.03.2017.
 */
@Test
public class LoginTests extends TestBase{

    public void testLogin() throws IOException {
        app.registration().enterUsersAdministrator();
    }
}
