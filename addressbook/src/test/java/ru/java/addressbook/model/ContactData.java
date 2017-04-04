package ru.java.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@XStreamAlias("contact")
@Entity
@Table (name = "addressbook")
public class ContactData {

    @XStreamOmitField
    @Id
    @Column(name = "id")
    private  int id = Integer.MAX_VALUE;
    @Column(name = "firstname")
    private  String name = "";
    @Column(name = "lastname")
    private  String last_name = "";
    @Column(name = "company")
    private  String company = "";
    @Column(name = "address")
    @Type(type = "text")
    private  String address = "";
    @Column(name = "home")
    @Type(type = "text")
    private  String home_phone = "";
    @Column(name = "mobile")
    @Type(type = "text")
    private  String mobile_number = "";
    @XStreamOmitField
    @Transient
    private  String allPhones;
    @Column(name = "work")
    @Type(type = "text")
    private  String work_phone = "";
    @XStreamOmitField
    @Transient
    private  String emailAll;
    @Column(name = "email")
    @Type(type = "text")
    private  String email1 = "";
    @Column(name = "email2")
    @Type(type = "text")
    private  String email2 = "";
    @Column(name = "email3")
    @Type(type = "text")
    private  String email3 = "";
    @Transient
    private  String info;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "address_in_groups", joinColumns = @JoinColumn(name = "id")
            , inverseJoinColumns = @JoinColumn(name = "group_id"))
    private Set<GroupData> groups = new HashSet<GroupData>();

    public String getInfo() {
        return info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (last_name != null ? !last_name.equals(that.last_name) : that.last_name != null) return false;
        if (company != null ? !company.equals(that.company) : that.company != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (home_phone != null ? !home_phone.equals(that.home_phone) : that.home_phone != null) return false;
        if (mobile_number != null ? !mobile_number.equals(that.mobile_number) : that.mobile_number != null)
            return false;
        if (work_phone != null ? !work_phone.equals(that.work_phone) : that.work_phone != null) return false;
        if (email1 != null ? !email1.equals(that.email1) : that.email1 != null) return false;
        if (email2 != null ? !email2.equals(that.email2) : that.email2 != null) return false;
        return email3 != null ? email3.equals(that.email3) : that.email3 == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (last_name != null ? last_name.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (home_phone != null ? home_phone.hashCode() : 0);
        result = 31 * result + (mobile_number != null ? mobile_number.hashCode() : 0);
        result = 31 * result + (work_phone != null ? work_phone.hashCode() : 0);
        result = 31 * result + (email1 != null ? email1.hashCode() : 0);
        result = 31 * result + (email2 != null ? email2.hashCode() : 0);
        result = 31 * result + (email3 != null ? email3.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", company='" + company + '\'' +
                ", address='" + address + '\'' +
                ", home_phone='" + home_phone + '\'' +
                ", mobile_number='" + mobile_number + '\'' +
                ", work_phone='" + work_phone + '\'' +
                ", email1='" + email1 + '\'' +
                ", email2='" + email2 + '\'' +
                ", email3='" + email3 + '\'' +
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

    public ContactData withMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
        return this;
    }

    public ContactData withWork_phone(String work_phone) {
        this.work_phone = work_phone;
        return this;
    }

    public Groups getGroups() {
        return new Groups(groups);
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

    public String getMobile_number() {
        return mobile_number;
    }

    public String getWork_phone() {
        return work_phone;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public int getId() {
        return id;
    }

    public ContactData inGroup(GroupData group) {
        groups.add(group);
        return this;
    }
}
