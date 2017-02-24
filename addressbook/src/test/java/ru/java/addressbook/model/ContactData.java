package ru.java.addressbook.model;

public class ContactData {
    private final String name;
    private final String last_name;
    private final String nick_name;
    private final String title;
    private final String company;
    private final String address;
    private final String phone_number;
    private final String email;
    private String group;

    public ContactData(String name, String last_name, String nick_name, String title, String company, String address, String phone_number, String email, String group) {
        this.name = name;
        this.last_name = last_name;
        this.nick_name = nick_name;
        this.title = title;
        this.company = company;
        this.address = address;
        this.phone_number = phone_number;
        this.email = email;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getNick_name() {
        return nick_name;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }
}
