package hql;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;

public class HiveQLOrderBy01 {

    public static void main(String[] args)
            throws SQLException, ClassNotFoundException {

        String driverName = "org.apache.hadoop.hive.jdbc.HiveDriver";
        Class.forName(driverName);
        Connection con = DriverManager.getConnection("jdbc:hive://localhost:10000/userdb", "", "");
        Statement stmt = con.createStatement();
        Resultset res = stmt.executeQuery("SELECT * FROM employee ORDER BY DEPT;");
        System.out.println(" ID \t Name \t Salary \t Designation \t Dept ");
        while (res.next()) {
            System.out.println(res.getInt(1) + " " + res.getString(2) + " " + res.getDouble(3) + " " + res.getString(4) + " " + res.getString(5));
        }
        con.close();
    }
}