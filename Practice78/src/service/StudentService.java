package service;
import model.Student;


public class StudentService {
    private int sumGrades;
    private int countStudents;
    private int maxGrade;
    private int minGrade;
    private Student bestStudent;
    private Student worstStudent;

    public StudentService() {
        sumGrades = 0;
        countStudents = 0;
        maxGrade = Integer.MIN_VALUE;
        minGrade = Integer.MAX_VALUE;
        bestStudent = null;
        worstStudent = null;
    }

    public void addGrade(Student student, int grade) {
        sumGrades += grade;
        countStudents++;

        if (grade > maxGrade) {
            maxGrade = grade;
            bestStudent = student;
        }

        if (grade < minGrade) {
            minGrade = grade;
            worstStudent = student;
        }

    }

    public float getAverageGrade() {
        if (countStudents == 0) {
            return 0.0f;
        }
        return (float) sumGrades / countStudents;
    }

    public Student getBestStudent() {
        return bestStudent;
    }

    public Student getWorstStudent() {
        return worstStudent;
    }
}
