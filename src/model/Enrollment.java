package model;
import java.util.*;

public class Enrollment {
    private Student student;
    private ArrayList<Subject> subjectStore;
    private ArrayList<Score> scoreStore;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }


    public ArrayList<Subject> getSubjectStore() {
        return subjectStore;
    }

    public void setSubjectStore(ArrayList<Subject> subjectStore) {
        this.subjectStore = subjectStore;
    }

    public ArrayList<Score> getScoreStore() {
        return scoreStore;
    }

    public void setScoreStore(ArrayList<Score> scoreStore) {
        this.scoreStore = scoreStore;
    }

}
