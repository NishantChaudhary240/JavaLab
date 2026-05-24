package JDBC;

import java.sql.*;
import java.util.Scanner;

public class StudentCRUD_8 {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/";
    static final String DB = "studentdb";
    static final String DB_USER = "root";
    static final String DB_PASS = "";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL + DB, DB_USER, DB_PASS);

            System.out.println("Connected Successfully");

            while (true) {
                System.out.println("\n1. Insert");
                System.out.println("2. Select");
                System.out.println("3. Update");
                System.out.println("4. Delete");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");

                int ch = sc.nextInt();
                sc.nextLine();

                switch (ch) {

                    case 1:
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Email: ");
                        String email = sc.nextLine();

                        System.out.print("Enter Phone: ");
                        String phone = sc.nextLine();

                        System.out.print("Enter Gender: ");
                        String gender = sc.nextLine();

                        System.out.print("Enter Title: ");
                        String title = sc.nextLine();

                        String insert = "INSERT INTO students(fullname,email,phoneno,gender,title) VALUES(?,?,?,?,?)";
                        PreparedStatement ps = conn.prepareStatement(insert);

                        ps.setString(1, name);
                        ps.setString(2, email);
                        ps.setString(3, phone);
                        ps.setString(4, gender);
                        ps.setString(5, title);

                        ps.executeUpdate();
                        System.out.println("Record Inserted");
                        break;

                    case 2:
                        Statement st = conn.createStatement();
                        ResultSet rs = st.executeQuery("SELECT * FROM students");

                        while (rs.next()) {
                            System.out.println(
                                    rs.getInt("id") + " | " +
                                    rs.getString("fullname") + " | " +
                                    rs.getString("email") + " | " +
                                    rs.getString("phoneno") + " | " +
                                    rs.getString("gender") + " | " +
                                    rs.getString("title")
                            );
                        }
                        break;

                    case 3:
                        System.out.print("Enter ID to update: ");
                        int uid = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter new Name: ");
                        String newName = sc.nextLine();

                        System.out.print("Enter new Email: ");
                        String newEmail = sc.nextLine();

                        System.out.print("Enter new Phone: ");
                        String newPhone = sc.nextLine();

                        System.out.print("Enter new Gender: ");
                        String newGender = sc.nextLine();

                        System.out.print("Enter new Title: ");
                        String newTitle = sc.nextLine();

                        String update = "UPDATE students SET fullname=?, email=?, phoneno=?, gender=?, title=? WHERE id=?";
                        PreparedStatement ups = conn.prepareStatement(update);

                        ups.setString(1, newName);
                        ups.setString(2, newEmail);
                        ups.setString(3, newPhone);
                        ups.setString(4, newGender);
                        ups.setString(5, newTitle);
                        ups.setInt(6, uid);

                        ups.executeUpdate();
                        System.out.println("Record Updated");
                        break;

                    case 4:
                        System.out.print("Enter ID to delete: ");
                        int did = sc.nextInt();

                        String delete = "DELETE FROM students WHERE id=?";
                        PreparedStatement dps = conn.prepareStatement(delete);

                        dps.setInt(1, did);
                        dps.executeUpdate();

                        System.out.println("Record Deleted");
                        break;

                    case 5:
                        conn.close();
                        System.out.println("Program Ended");
                        return;

                    default:
                        System.out.println("Invalid Choice");
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}