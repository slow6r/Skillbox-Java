import model.Student;
import service.StudentService;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();

        studentService.addGrade(new Student("Anna", 4), 58);
        studentService.addGrade(new Student("Katya", 6), 27);
        studentService.addGrade(new Student("Sergey", 8), 98);
        studentService.addGrade(new Student("Nikita", 2), 11);
        studentService.addGrade(new Student("Ivan", 9), 34);


        Student bestStudent = studentService.getBestStudent();
        System.out.println("Best student is " + bestStudent.getName() + " from class " + bestStudent.getClassNumber());

        Student worstStudent = studentService.getWorstStudent();
        System.out.println("Worst student is " + worstStudent.getName() + " from class " + worstStudent.getClassNumber());
        System.out.println("Average grade is " + studentService.getAverageGrade());
    }
}
