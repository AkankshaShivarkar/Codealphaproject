package student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        int choice = 0;

        while (true) {
            System.out.println("\n1. Add student and grade");
            System.out.println("2. Show summary report");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // consume invalid input
                continue;
            }

            if (choice == 1) {
                System.out.print("Enter student name: ");
                String name = scanner.nextLine();
                System.out.print("Enter student grade: ");
                if (scanner.hasNextInt()) {
                    int grade = scanner.nextInt();
                    students.add(new Student(name, grade));
                    System.out.println("Student added.");
                } else {
                    System.out.println("Invalid grade. Please enter an integer.");
                    scanner.nextLine(); // consume invalid input
                }
            } else if (choice == 2) {
                System.out.println("\nStudent Report:");
                if (students.isEmpty()) {
                    System.out.println("No students added yet.");
                } else {
                    for (Student s : students) {
                        System.out.println(s.name + " - " + s.grade);
                    }
                }
            } else if (choice == 3) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}
