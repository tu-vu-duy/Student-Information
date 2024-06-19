package student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import student.Student;

/**
 *
 * @author thaycacac
 */
public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        display();
    }

    //method check if striing have special characters
    public static boolean containSpecialCharacter(String input) {
        return !input.matches("[a-zA-Z0-9\\s]+"); //only allow alphabet characters
    }
    // 
    public static String checkInputString() {
        while (true) {
            String result = sc.nextLine();
            if (result.isEmpty()) {
                System.out.println("Not Emty");
            } else {
                return result;
            }
        }
    }

    public static int checkInputMarking(String nameSubject) {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                if (result < 0) {
                    System.out.println(nameSubject + "is greater than equal 0.");
                    System.out.println(nameSubject + ": ");
                    continue;
                }
                if (result > 10) {
                    System.out.println(nameSubject + "is less than equal 10.");
                    System.out.println(nameSubject + ": ");
                    continue;
                }
                return result;
            } catch (NullPointerException e) {
                System.out.println(nameSubject + "is digit");
                System.out.println(nameSubject + ":");
            }
        }
    }

    public static boolean checkYN() {
        while (true) {
            String result = checkInputString();
            if (result.length() == 1) {
                char resultChar = result.charAt(0);
                if (resultChar == 'y' || resultChar == 'Y') {
                    return true;
                }
                if (resultChar == 'n' || resultChar == 'N') {
                    return false;
                }
            }
            System.out.println("Re-input");
        }
    }

    public static void createStudent(List<Student> list) {
        while (true) {
            System.out.print("Name: ");
            String name = checkInputString();
            System.out.print("Classes: ");
            String className = checkInputString();
            System.out.print("Maths: ");
            double math = checkInputMarking("Maths");
            System.out.print("Physics: ");
            double physics = checkInputMarking("Physics");
            System.out.print("Chemistry: ");
            double chemistry = checkInputMarking("Chemistry");

            //add new student to list
            list.add(new Student(name, className, math, physics, chemistry));
            System.out.print("Do you want to enter more student information?(Y/N): ");
            if (!checkYN()) {
                return;
            }
        }

    }

    private static void displayInformationStudent(List<Student> ls) {
        int i = 0;
        for (Student mem : ls) {
            System.out.println("Student " + (++i) + " info");
            System.out.println("Name: " + mem.getStudentName());
            System.out.println("Classes: " + mem.getClassName());
            System.out.println("AVG: " + mem.getAverage());
            System.out.println("Type: " + mem.getType());
        }
    }

    private static void display() {
        List<Student> ls = new ArrayList<>();
        createStudent(ls);
        MarkCalculation.calcAvgAndType(ls);
        displayInformationStudent(ls);
        HashMap<String, Double> percentTypeStudent = MarkCalculation.getPercentTypeStudent(ls);
        for (Map.Entry<String, Double> student : percentTypeStudent.entrySet()) {
            System.out.println(student.getKey() + " :" + student.getValue() + "%");
        }
    }

}
