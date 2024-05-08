package model;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Score {
    private final String scoreId;
    private String subjectId;
    private String studentId;
    private HashMap<Integer, Integer> roundGrade;

    public Score(String seq, String studentId, String subjectId) {
        this.scoreId = seq;
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.roundGrade= new LinkedHashMap<>();
    }

    public String getScoreId() {
        return scoreId;
    }

    public String getStudentId() {
        return studentId;
    }


    public String getSubjectId() {
        return subjectId;
    }

    public HashMap<Integer, Integer> getRoundGrade() {
        return roundGrade;
    }


    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }


    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public void setRoundGrade(String subjectType, int round, int point){
        this.roundGrade.put(round, point);
    }

    public String calculateGrade(String subjectType, int point){

        String grade = "";

        if(subjectType.equals("MANDATORY")){
            if(point >= 95){
                grade = "A";
            }
            else if(point >= 90){
                grade = "B";
            }
            else if(point >= 80){
                grade = "C";
            }
            else if(point >= 70){
                grade = "D";
            }
            else if(point >= 60){
                grade = "F";
            }
            else{
                grade = "N";
            }
        }

        else if(subjectType.equals("CHOICE")){
            if(point >= 90){
                grade = "A";
            }
            else if(point >= 80){
                grade = "B";
            }
            else if(point >= 70){
                grade = "C";
            }
            else if(point >= 60){
                grade = "D";
            }
            else if(point >= 50){
                grade = "F";
            }
            else{
                grade = "N";
            }
        }


        return grade;
    }

}
