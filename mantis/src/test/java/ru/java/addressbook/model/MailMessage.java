package ru.java.addressbook.model;

/**
 * Created by Studenov-DV on 03.04.2017.
 */
public class MailMessage {

    public String to;
    public String text;

    public MailMessage (String to, String text) {
        this.to = to;
        this.text = text;
    }
}
