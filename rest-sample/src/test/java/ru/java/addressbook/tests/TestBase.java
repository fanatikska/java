package ru.java.addressbook.tests;

import org.testng.SkipException;
import ru.java.addressbook.appmanager.RestHelper;
import ru.java.addressbook.model.Issue;

import java.io.IOException;
import java.util.Set;

/**
 * Created by studenov-dv on 13.04.2017.
 */
public class TestBase extends RestHelper{


    public void skipIfNotFixed(int issueId) throws IOException {
        if (isIssueOpen(issueId)) {
            throw new SkipException("Ignored because of issue " + issueId);
        }
    }

    private boolean isIssueOpen(int issueId) throws IOException {

       Set<Issue> issues = RestTest.getIssue();
        Issue checkIssue = null;

        for (Issue issue : issues) {
            if (issue.getId() == issueId) {
                checkIssue = issue;
            }
        }
        if ((String.valueOf(checkIssue.getStatus()) == "new")
                || (String.valueOf(checkIssue.getStatus()) == "open")) {
            return false;
        } else return true;
    }

}
