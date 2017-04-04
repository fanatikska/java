package ru.java.mantis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Studenov-DV on 04.04.2017.
 */

@Entity
@Table(name = "mantis_user_table")
public class UsersData {

        //@Entity
        //@Table(name = "mantis_user_table")
        @Id
        @Column(name = "id")
        private int id = Integer.MAX_VALUE;
        @Column(name = "username")
        private String name;
        @Column(name = "email")
        private String email;
        @Column(name = "password")
        private String password;

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }

        public int getId() {
            return id;
        }

    @Override
    public String toString() {
        return "UsersData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public UsersData withId(int id) {
            this.id = id;
            return this;
        }

        public UsersData withName(String name) {
            this.name = name;
            return this;
        }

        public UsersData withEmail(String email) {
            this.email = email;
            return this;
        }

        public UsersData withPassword(String password) {
            this.password = password;
            return this;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersData usersData = (UsersData) o;

        if (id != usersData.id) return false;
        if (name != null ? !name.equals(usersData.name) : usersData.name != null) return false;
        if (email != null ? !email.equals(usersData.email) : usersData.email != null) return false;
        return password != null ? password.equals(usersData.password) : usersData.password == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
