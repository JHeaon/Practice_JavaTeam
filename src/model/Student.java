package model;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private final String studentId;
    private final String studentName;
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

    // 수강 과목 리스트에 주어진 과목의 존재 여부 판별
    public boolean isInList(Subject subject) { return this.enrolledCourses.contains(subject); }
}
