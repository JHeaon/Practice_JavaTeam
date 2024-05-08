package model;

import java.util.ArrayList;

public class Student {
    private final String studentId;
    private final String studentName;
    private final String studentStatus;
    private final ArrayList<Subject> subjectList;

    public Student(String seq, String studentName, String studentStatus) {
        this.studentId = seq;
        this.studentName = studentName;
        this.studentStatus = studentStatus;
        this.subjectList = new ArrayList<Subject>();
    }

    // Getter
    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentStatus() {
        return studentStatus;
    }

    public ArrayList<Subject> getSubjectList() {
        return subjectList;
    }

    // Setter
    public void setSubjectList(Subject subject) {
        this.subjectList.add(subject);
    }

}
