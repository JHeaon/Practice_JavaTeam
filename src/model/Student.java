package model;

import java.util.ArrayList;

public class Student {
    private String studentId;
    private String studentName;
    private ArrayList<String> subjectList;

    public Student(String seq, String studentName) {
        this.studentId = seq;
        this.studentName = studentName;
        this.subjectList = new ArrayList<String>();
    }

    // Getter
    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public ArrayList<String> getSubjectList() {
        return subjectList;
    }

    // Setter
    public void setSubjectList(String subjectName) {
        this.subjectList.add(subjectName);
    }

}
