package ru.java.mantis.tests;

import org.testng.annotations.Test;
import ru.java.mantis.model.UsersData;

import java.sql.*;
import java.util.HashSet;

/**
 * Created by Studenov-DV on 23.03.2017.
 */
public class DBConnectionTest {

    @Test
    public void testDBConnection(){
        Connection conn = null;
        try {
                conn = DriverManager
                        .getConnection("jdbc:mysql://localhost:3306/bugtracker?serverTimezone=UTC&" +
                                "user=root&password=");
        //    jdbc:mysql://localhost/test?" +"user=minty&password=greatsqldb
                Statement st  = conn.createStatement();
            ResultSet rs = st.executeQuery("select group_id, group_name, group_header, group_footer" +
                    " from group_list");
            HashSet<UsersData> users = new HashSet<UsersData>();
            while(rs.next()) {
                users.add(new UsersData().withId(rs.getInt("id")).withName(rs.getString("name"))
                        .withEmail(rs.getString("email")).withPassword(rs.getString("password")));
            }
            rs.close();
            st.close();
            conn.close();
            System.out.println(users);
        } catch (SQLException ex) {
            System.out.println("SQL Exception" + ex.getMessage());
            System.out.println("SQL State" + ex.getSQLState());
            System.out.println("Vendor Error" + ex.getErrorCode());
        }
    }
}
