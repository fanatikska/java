package ru.java.addressbook.model;

public class ContactData {
    private  String name;
    private  String last_name;
    private  String nick_name;
    private  String title;
    private  String company;
    private  String address;
    private  String home_phone;
    private  String mobile_number;
    private  String allPhones;
    private  String work_phone;
    private  String emailAll;
    private  String email1;
    private  String email2;
    private  String email3;
    private  String info;
    private  String group;
    private  int id = Integer.MAX_VALUE;


    public String getInfo() {
        return info;
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
                ", home_phone='" + home_phone + '\'' +
                ", mobile_number='" + mobile_number + '\'' +
                ", allPhones='" + allPhones + '\'' +
                ", work_phone='" + work_phone + '\'' +
                ", emailAll='" + emailAll + '\'' +
                ", email1='" + email1 + '\'' +
                ", email2='" + email2 + '\'' +
                ", email3='" + email3 + '\'' +
                ", info='" + info + '\'' +
                ", group='" + group + '\'' +
                ", id=" + id +
                '}';
    }

    public ContactData withInfo(String info) {
        this.info = info;
        return this;
    }

    public ContactData withallPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

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
        this.home_phone = phone_number;
        return this;
    }

    public ContactData withEmailAll(String email) {
        this.emailAll = email;
        return this;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    public ContactData withMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
        return this;
    }

    public ContactData withWork_phone(String work_phone) {
        this.work_phone = work_phone;
        return this;
    }


    public String getEmail1() {
        return email1;
    }

    public ContactData withEmail1(String email1) {
        this.email1 = email1;
        return this;
    }

    public String getEmail2() {
        return email2;
    }

    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public String getEmail3() {
        return email3;
    }

    public ContactData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getallPhones() {
        return allPhones;
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

    public String getHome_phone() {
        return home_phone;
    }

    public String getEmailAll() {
        return emailAll;
    }

    public String getGroup() {
        return group;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public String getWork_phone() {
        return work_phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return last_name != null ? last_name.equals(that.last_name) : that.last_name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (last_name != null ? last_name.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public int getId() {
        return id;
    }

}
