public class StudentId {
    private String studentFirstName;
    private String studentLastName;
    private int studentId;
    public StudentId() {
        this.studentFirstName = "First";
        this.studentLastName = "Last";
        this.studentId = 111111;
    }
    public StudentId(String studentFirstName, String studentLastName, int studentId) {
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.studentId = studentId;
    }
    public String getStudentFirstName() {
        return studentFirstName;
   }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getPassword() {
        char firstChar = studentLastName.charAt(0);
        char lastChar = studentLastName.charAt(studentLastName.length() - 1);
        return firstChar + Integer.toString(studentId) + lastChar;
    }

    public String toString() {
        return "Name = " + studentFirstName + " " + studentLastName + "\nStudent Id = " + studentId;
    }
}
