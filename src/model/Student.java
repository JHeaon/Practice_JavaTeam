package model;

import java.util.ArrayList;

public class Student {
    private String studentId;
    private String studentName;
    private ArrayList<Subject> subjectList;

    public Student(String seq, String studentName) {
        this.studentId = seq;
        this.studentName = studentName;
        this.subjectList = new ArrayList<Subject>();
    }

    // Getter
    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public ArrayList<Subject> getSubjectList() {
        return subjectList;
    }

    // Setter
    public void setSubjectList(Subject subject) {
        this.subjectList.add(subject);
    }

}
