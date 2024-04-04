public class StudentTest {
    public static void main(String[] args) {
        StudentId student1 = new StudentId();
        System.out.println("Default Student:");
        System.out.println(student1);
        student1.setStudentFirstName("Ada");
        student1.setStudentLastName("Lovelace");
        student1.setStudentId(223344);
        System.out.println("\nUpdated Student:");
        System.out.println(student1);
        StudentId student2 = new StudentId("Buzz", "Lightyear", 123456);
        System.out.println("\nNew Student:");
        System.out.println(student2);
        System.out.println("\nStudent Password:");
        System.out.println(student1.getPassword());
    }
}
