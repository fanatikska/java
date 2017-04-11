package ru.java.mantis.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.java.mantis.model.Issue;
import ru.java.mantis.model.Project;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

/**
 * Created by studenov-dv on 10.04.2017.
 */
public class SoapTests extends TestBase{

    @Test
    public void testSoap() throws MalformedURLException, ServiceException, RemoteException {

        Set<Project> projects = app.soap().getProject();
        for(Project project : projects){
            System.out.println(project.getName());
        }
    }

    @Test
    public void testCreateIssue() throws RemoteException, ServiceException, MalformedURLException {

        skipIfNotFixed(0000042);
        Set<Project> projects = app.soap().getProject();
        Issue issue = new Issue().withSummary("Test issue")
                .withDescription("Test issue description").withProject(projects.iterator().next()).withStatus(projects.iterator().next());
        Issue created = app.soap().addIssue(issue);
        assertEquals(issue.getSummary(), created.getSummary());
        for (Project project : projects) {
            System.out.println("!!!!!!!!!!!!!!!!" + project.getStatus());
        }
    }

}
