import java.util.ArrayList;

public class Course {
    public static ArrayList<String> courses = new ArrayList<>();

    static {
        courses.add("Java");
        courses.add("Python");
        courses.add("Web Development");
        courses.add("Data Structures");
        courses.add("C/ C++");
        courses.add("SQL"); 
    }

    public static void showCourses() {
        System.out.println("\n--- Available Courses ---");
        for (int i = 0; i < courses.size(); i++) {
            System.out.println((i + 1) + ". " + courses.get(i));
        }
    }
}
