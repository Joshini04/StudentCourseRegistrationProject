import java.util.ArrayList;
public class Student {
    String name;
    String email;
    String password;
    ArrayList<String> enrolledCourses;

    public Student(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.enrolledCourses = new ArrayList<>();
    }

    public void enroll(String course) {
        enrolledCourses.add(course);
        System.out.println("Enrolled in " + course + " successfully!");
    }

    public void viewProfile() {
        System.out.println("\n--- Profile ---");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Courses: " + enrolledCourses);
    }
}
