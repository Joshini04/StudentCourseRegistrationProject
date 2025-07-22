import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();
    static Student currentStudent = null;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Student Course Registration ---");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void register() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Password: ");
        String pass = sc.nextLine();

        for (Student s : students) {
            if (s.email.equals(email)) {
                System.out.println("Email already registered.");
                return;
            }
        }

        students.add(new Student(name, email, pass));
        System.out.println("Registration successful! You can now log in.");
    }

    static void login() {
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Password: ");
        String pass = sc.nextLine();

        for (Student s : students) {
            if (s.email.equals(email) && s.password.equals(pass)) {
                currentStudent = s;
                System.out.println("Login successful! Welcome, " + s.name);
                studentMenu();
                return;
            }
        }

        System.out.println("Invalid credentials.");
    }

    static void studentMenu() {
        while (true) {
            System.out.println("\n--- Student Menu ---");
            System.out.println("1. Enroll in a course");
            System.out.println("2. View Profile");
            System.out.println("3. Logout");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    Course.showCourses();
                    System.out.print("Enter course number to enroll: ");
                    int courseNum = sc.nextInt();
                    sc.nextLine();
                    if (courseNum >= 1 && courseNum <= Course.courses.size()) {
                        currentStudent.enroll(Course.courses.get(courseNum - 1));
                    } else {
                        System.out.println("Invalid course number.");
                    }
                    break;
                case 2:
                    currentStudent.viewProfile();
                    break;
                case 3:
                    System.out.println("Logged out.");
                    currentStudent = null;
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
