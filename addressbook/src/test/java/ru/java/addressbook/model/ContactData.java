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
    private final String group;
    private  int id;


    public ContactData(String name, String last_name, String nick_name, String title, String company, String address, String phone_number, String email, String group) {
        this.id = Integer.MAX_VALUE;
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

    public ContactData(int id, String name, String last_name, String nick_name, String title, String company, String address, String phone_number, String email, String group) {
        this.id = id;
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

    public void setId(int id) {
        this.id = id;
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
