package hql;

import java.sql.*;

public class HiveQLSelectWhere {
    private static String driverName = "org.apache.hadoop.hive.jdbc.HiveDriver";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        // Register driver and create driver instance
        Class.forName(driverName);

        // get connection
        Connection con = DriverManager.getConnection("jdbc:hive://localhost:10000/userdb", "", "");

        // create statement
        Statement stmt = con.createStatement();

        // execute statement
        Resultset res = stmt.executeQuery("SELECT * FROM employee WHERE salary>30000;");
        System.out.println("Result:");
        System.out.println(" ID \t Name \t Salary \t Designation \t Dept ");
        while (res.next()) {
            System.out.println(res.getInt(1) + " " + res.getString(2) + " " + res.getDouble(3) + " " + res.getString(4) + " " + res.getString(5));
        }
        con.close();
    }
}
