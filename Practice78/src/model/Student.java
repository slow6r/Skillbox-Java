package model;

public class Student {
    private final String name;
    private final int classNumber;

    public Student(String name, int classNumber) {
        this.name = name;
        this.classNumber = classNumber;
    }

    public String getName() {
        return name;
    }

    public int getClassNumber() {
        return classNumber;
    }
}
