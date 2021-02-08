package hql;


import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;

public class HiveQLGroupBy01 {

    public static void main(String[] args)
            throws SQLException, ClassNotFoundException {
        String driverName = "org.apache.hadoop.hive.jdbc.HiveDriver";
        Class.forName(driverName);
        Connection con = DriverManager.
                getConnection("jdbc:hive://localhost:10000/userdb", "", "");
        Statement stmt = con.createStatement();
        Resultset res = stmt.executeQuery("SELECT Dept, count( *) FROM employee GROUP BY DEPT;");
        System.out.println(" Dept \t count(*)");
        while (res.next()) {
            System.out.println(res.getString(1) + " " + res.getInt(2));
        }
        con.close();
    }
}