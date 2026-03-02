package Chuong5;
import java.sql.*;

public class Bai1_SelectUsers {

    public static void main(String[] args) {

        String url = "jdbc:sqlserver://localhost:1433;databaseName=JavaPractice;encrypt=false";
        String user = "sa";
        String password = "123";

        try (
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
        ) {

            System.out.println("=== DANH SÁCH USERS ===");

            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String email = rs.getString("email");

                System.out.println(id + " - " + username + " - " + email);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

