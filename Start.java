import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Start {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Student Management");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Press 1 to Display Students");
            System.out.println("Press 2 to Add Students");
            System.out.println("Press 3 to Delete Student");
            System.out.println("Press 4 to Exit");
            int c = Integer.parseInt(br.readLine());
            if (c == 1) {
                //display student
                StudentDao.showAllStudents();

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
                boolean answer = StudentDao.insertStudentToDB(stud);
                if (answer) {
                    System.out.println("Student added succcessfully...");
                } else {
                    System.out.println("Something went wrong, please try again later...");
                }
                System.out.println(stud);
            } else if (c == 3) {
                //delete stud
                System.out.println("Enter Student ID to delete: ");
                int userID = Integer.parseInt(br.readLine());
                StudentDao.deleteStudent(userID);
                boolean f = StudentDao.deleteStudent(userID);
                if (f) {
                    System.out.println("Successfully Deleted...");
                } else {
                    System.out.println("Something went wrong, please try again later...");
                }

            } else if (c == 4) {
                //exit
                break;
            } else {

            }
        }
        System.out.println("Exiting...");
    }
}
