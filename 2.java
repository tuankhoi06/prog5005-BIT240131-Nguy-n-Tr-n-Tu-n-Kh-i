package Chuong5;
import java.sql.*;
import java.util.Scanner;

public class Bai2_DeleteUser {

    public static void main(String[] args) {

        String url = "jdbc:sqlserver://localhost:1433;databaseName=Java;encrypt=false";
        String user = "tuankhoi";
        String password = "0606";;

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập ID cần xóa: ");
        int id = sc.nextInt();

        String sql = "DELETE FROM users WHERE id = ?";

        try (
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = conn.prepareStatement(sql);
        ) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Xóa thành công!");
            } else {
                System.out.println("Không tìm thấy user để xóa");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

