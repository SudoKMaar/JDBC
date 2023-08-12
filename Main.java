import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Main {
    public static Connection createC() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String user = "root";
            String password = "admin";
            String url = "jdbc:mysql://localhost:3306/tempstudent";
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void showAllStudents() {
        try {
            Connection con = createC();
            String q = "select * from student";
            Statement stnt = con.createStatement();
            ResultSet set = stnt.executeQuery(q);
            while (set.next()) {
                int id = set.getInt(1);
                String name = set.getString(2);
                String phone = set.getString(3);
                String city = set.getString(4);
                System.out.println("ID : " + id);
                System.out.println("Name : " + name);
                System.out.println("Phone No. : " + phone);
                System.out.println("City : " + city);
                System.out.println("********************");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static boolean insertStudentToDB(Student stud) {
        boolean f = false;
        try {
            Connection con = createC();
            String q = "insert into student(sname,sphone,scity) values(?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1, stud.getStudentName());
            pstmt.setString(2, stud.getStudentPhoneNo());
            pstmt.setString(3, stud.getStudentCity());
            pstmt.executeUpdate();
            f = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    public static boolean deleteStudent(int userID) {
        boolean f = false;
        try {
            Connection con = createC();
            String q = "delete from student where sid=?";
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setInt(1, userID);
            pstmt.executeUpdate();
            f = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    public static boolean updateStudentToDB(Student stud) {
        boolean f = false;
        try {
            Connection con = createC();
            String q = "update student set sphone=?, scity=? where sid=?";
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1, stud.getStudentPhoneNo());
            pstmt.setString(2, stud.getStudentCity());
            pstmt.setInt(3, stud.getStudentId());
            pstmt.executeUpdate();
            f = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Student Management");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Press 1 to Display Students");
            System.out.println("Press 2 to Add Students");
            System.out.println("Press 3 to Delete Student");
            System.out.println("Press 4 to Update Student");
            System.out.println("Press 5 to Exit");
            int c = Integer.parseInt(br.readLine());
            if (c == 1) {
                //display student
                showAllStudents();

            } else if (c == 2) {
                //add stud
                System.out.println("Enter user Name: ");
                String name = br.readLine();
                System.out.println("Enter user Phone");
                String phone = br.readLine();
                System.out.println("Enter user City");
                String city = br.readLine();

                //obj to store stud
                Student stud = new Student(name, phone, city);
                boolean answer = insertStudentToDB(stud);
                if (answer) {
                    System.out.println("Student added succcessfully...");
                } else {
                    System.out.println("Something went wrong, please try again later...");
                }
            } else if (c == 3) {
                //delete stud
                System.out.println("Enter Student ID to delete: ");
                int userID = Integer.parseInt(br.readLine());
                deleteStudent(userID);
                boolean f = deleteStudent(userID);
                if (f) {
                    System.out.println("Successfully Deleted...");
                } else {
                    System.out.println("Something went wrong, please try again later...");
                }
            } else if (c == 4) {
                //update stud
                System.out.println("Enter Student ID to update: ");
                int userID = Integer.parseInt(br.readLine());
                System.out.println("Enter updated user Phone");
                String phone = br.readLine();
                System.out.println("Enter updated user City");
                String city = br.readLine();

                //obj to store stud
                Student stud = new Student(userID, phone, city);
                boolean answer = updateStudentToDB(stud);
                if (answer) {
                    System.out.println("Student updated succcessfully...");
                } else {
                    System.out.println("Something went wrong, please try again later...");
                }
            } else if (c == 5) {
                //exit
                break;
            } else {

            }
        }
        System.out.println("Exiting...");
    }

}
