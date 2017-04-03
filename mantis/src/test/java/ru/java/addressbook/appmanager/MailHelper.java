package ru.java.addressbook.appmanager;

import org.subethamail.wiser.Wiser;
import org.subethamail.wiser.WiserMessage;
import ru.java.addressbook.model.MailMessage;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


/**
 * Created by Studenov-DV on 03.04.2017.
 */
public class MailHelper {
    private ApplicationManager app;
    private final Wiser wiser;

    public MailHelper (ApplicationManager app){
        this.app = app;
        wiser = new Wiser();
    }

    public List<MailMessage> waitForMail(int count, long timeout){
        long start = System.currentTimeMillis();
        while(System.currentTimeMillis() < start + timeout){
            if (wiser.getMessages().size() >= count){
                return wiser.getMessages().stream().map((m) -> toModelMail(m)).collect(Collectors.toList());
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        throw new Error("No mail :(");
    }

    public static MailMessage toModelMail(WiserMessage m){
        try {
            MimeMessage mm = m.getMimeMessage();
            return new MailMessage(mm.getAllRecipients()[0].toString(), (String) mm.getContent());
        } catch (MessagingException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void start(){
        wiser.start();
    }

    public void stop() {
        wiser.stop();
    }
}
