package assignment;

public class Subject {
    private String subjectId;
    private String subjectName;
    private String subjectType;

    public Subject(String seq, String subjectName, String subjectType){
        this.subjectId = seq;
        this.subjectName = subjectName;
        this.subjectType = subjectType;
    }

    //getter 명령어로 저장된 Subject값을 출력할 수 있는 변수
    public String getSubjectId(){ return subjectId; }

    public String getSubjectName(){ return subjectName; }

    public String getSubjectType() {
        return subjectType;
    }
}
