package model;

import java.util.ArrayList;

public class Student {
    private final String studentId;
    private String studentName;
    private String studentStatus;
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
    public void setStudentName(String newName) {
        this.studentName = newName;
    }

    public void setStudentStatus(String newStatus) {
        this.studentStatus = newStatus;
    }

    public void setSubjectList(Subject subject) {
        this.subjectList.add(subject);
    }

}
