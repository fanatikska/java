package ru.java.addressbook.model;

public class ContactData {
    private  String name;
    private  String last_name;
    private  String nick_name;
    private  String title;
    private  String company;
    private  String address;
    private  String phone_number;
    private  String email;
    private  String group;
    private  int id = Integer.MAX_VALUE;

    public ContactData withName(String name) {
        this.name = name;
        return this;
    }

    public ContactData withLast_name(String last_name) {
        this.last_name = last_name;
        return this;
    }

    public ContactData withNick_name(String nick_name) {
        this.nick_name = nick_name;
        return this;
    }

    public ContactData withTitle(String title) {
        this.title = title;
        return this;
    }

    public ContactData withCompany(String company) {
        this.company = company;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withPhone_number(String phone_number) {
        this.phone_number = phone_number;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
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

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return last_name != null ? last_name.equals(that.last_name) : that.last_name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (last_name != null ? last_name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "name='" + name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", nick_name='" + nick_name + '\'' +
                ", title='" + title + '\'' +
                ", company='" + company + '\'' +
                ", address='" + address + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", email='" + email + '\'' +
                ", group='" + group + '\'' +
                ", id=" + id +
                '}';
    }

}
