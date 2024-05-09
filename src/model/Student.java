package model;

import javax.swing.plaf.nimbus.State;
import java.util.ArrayList;
import java.util.Arrays;

public class Student {
    private final String studentId;
    private String studentName;
    private String studentState;
    private final ArrayList<Subject> subjectList;

    public Student(String seq, String studentName, String studentState) {
        this.studentId = seq;
        this.studentName = studentName;
        this.studentState = studentState;
        this.subjectList = new ArrayList<Subject>();
    }

    // Getter
    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentState() {
        return studentState;
    }

    public ArrayList<Subject> getSubjectList() {
        return subjectList;
    }

    // Setter
    public void setStudentName(String newName) {
        this.studentName = newName;
    }

    public void setSubjectList(Subject subject) {
        this.subjectList.add(subject);
    }
    public void setStudentState(String studentState) {
        this.studentState = studentState;
    }
}
