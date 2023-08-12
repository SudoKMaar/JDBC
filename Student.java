public class Student {
    private int studentId;
    private String studentName;
    private String studentPhoneNo;
    private String studentCity;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentCity() {
        return studentCity;
    }

    public void setStudentCity(String studentCity) {
        this.studentCity = studentCity;
    }

    public String getStudentPhoneNo() {
        return studentPhoneNo;
    }

    public void setStudentPhoneNo(String studentPhoneNo) {
        this.studentPhoneNo = studentPhoneNo;
    }

    public Student(int studentId, String studentName, String studentPhoneNo, String studentCity) {
        super();
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentPhoneNo = studentPhoneNo;
        this.studentCity = studentCity;

    }

    public Student(String studentName, String studentPhoneNo, String studentCity) {
        super();
        this.studentName = studentName;
        this.studentPhoneNo = studentPhoneNo;
        this.studentCity = studentCity;

    }

    public Student(int studentId, String studentPhoneNo, String studentCity) {
        super();
        this.studentId = studentId;
        this.studentPhoneNo = studentPhoneNo;
        this.studentCity = studentCity;

    }


    public String toString() {
        return "Student [Student Id=" + studentId + ", Student Name =" + studentName + ", Student City=" + studentCity + "Students Phone No=" + studentPhoneNo + "]";
    }



//    public Student {
//        super();
//    }
}