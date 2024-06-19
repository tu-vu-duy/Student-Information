/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author FPTSHOP
 */
public class MarkCalculation {
    //method calculate average marks
    public static void calcAvgAndType(List<Student> students) {
        for (Student student : students) {
            //calculate average mark
            double average = (student.getMath() + student.getPhysical() + student.getChemistry()) / 3;
            student.setAverage(average);
            char type;
            if (average > 7.5) {
                type = 'A';
            } else if (average >= 6 && average <= 7.5) {
                type = 'B';
            } else if (average >= 4 && average < 6) {
                type = 'C';
            } else {
                type = 'D';
            }
            student.setType(type);
        }
    }
    // method calculate percenttage of each student type
    public static HashMap<String, Double> getPercentTypeStudent(List<Student> students) {
        HashMap<String, Double> percentTypeStudent = new HashMap<>();
        int totalStudent = students.size();
        double typeA = 0;
        double typeB = 0;
        double typeC = 0;
        double typeD = 0;
        
        //count number of each student type 
        for(Student student: students){
            switch(student.getType()){
                case'A': typeA++;
                break;
                case'B': typeB++;
                break;
                case'C': typeC++;
                break;
                case'D': typeD++;
                break;
            }
        }
        //calculate percentage of each student
        percentTypeStudent.put("A", typeA / totalStudent * 100);
        percentTypeStudent.put("B", typeB / totalStudent * 100);
        percentTypeStudent.put("C", typeC / totalStudent * 100);
        percentTypeStudent.put("D", typeD / totalStudent * 100);
        return percentTypeStudent;
    }
}
