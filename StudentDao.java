import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {
    public static boolean insertStudentToDB(Student stud) {
        boolean f = false;
        try {
            Connection con = CProvider.createC();
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

    public static void showAllStudents() {
        try {
            Connection con = CProvider.createC();
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

    public static boolean deleteStudent(int userID) {
        boolean f = false;
        try {
            Connection con = CProvider.createC();
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
}