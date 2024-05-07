package model;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String studentId;
    private String studentName;
    private final List<Subject> enrolledCourses = new ArrayList<>();

    public Student(String seq, String studentName) {
        this.studentId = seq;
        this.studentName = studentName;
    }

    // Getter
    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public List<Subject> getEnrolledCourses() { return enrolledCourses; }

    // Setter
    public void setEnrolledCourses(Subject course) { this.enrolledCourses.add(course); }

    public boolean isInList(Subject subject) { return this.enrolledCourses.contains(subject); }
}
