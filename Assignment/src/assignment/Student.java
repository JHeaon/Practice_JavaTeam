package assignment;

import java.util.ArrayList;

public class Student {
    //생성
    private String studentId;
    private String studentName;
    private ArrayList<Subject> subjectList;

    //생성된 객체를 매개변수로 할당하고 학생 인스턴스화
    public Student(String seq, String studentName){
        this.studentId = seq;
        this.studentName = studentName;
        this.subjectList = new ArrayList<>();
    }

    //getter를 사용하여 Student 매개변수 출력하는 변수
    public String getStudentId() {return studentId;}

    public String getStudentName() {return studentName;}

    public ArrayList<Subject> getSubjectList() {return subjectList;}

    //setter를 사용하여 subject리스트에 저장하는 변수
    public void setSubjectList(Subject subject) {this.subjectList.add(subject);}
}
