package ru.java.addressbook.tests;

import org.testng.annotations.Test;
import ru.java.addressbook.model.Issue;

import java.io.IOException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

/**
 * Created by studenov-dv on 11.04.2017.
 */

public class RestTest extends TestBase{

    @Test
    public void testRest() throws IOException {

        skipIfNotFixed(1);
        Set<Issue> oldIssues = getIssue();
        Issue newIssue = new Issue().withSubject("test issue").withDescription("New test issue").withStatus("New");
        int issueId = createIssue(newIssue);
        Set<Issue> newIssues = getIssue();
        oldIssues.add(newIssue.withId(issueId));
        assertEquals(newIssues, oldIssues);
    }
}
