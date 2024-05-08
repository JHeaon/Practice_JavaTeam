package model;

import java.util.ArrayList;
import java.util.List;

public class Score {
    private final String studentId;
    private final String subjectId;
    private final List<Grade> scoreList = new ArrayList<>();

    public Score(String studentId, String subjectId) {
        this.studentId = studentId;
        this.subjectId = subjectId;
    }

    // Getter
    public String getStudentId() {
        return studentId;
    }

    public String getSubjectId() { return subjectId; }

    public List<Grade> getScoreList() { return scoreList; }

    // Setter
    public void setScoreList(int score, String type) {
        if (scoreList.size() <= 10) {
            this.scoreList.add(new Grade(score, convertToGrade(score, type)));
        } else {
            System.out.println("시험을 10회 완료했습니다.");
        }
    }

    public void setScoreList(int score, String type, int round) {
        this.scoreList.set((round - 1), new Grade(score, convertToGrade(score, type)));
    }

    // 점수를 등급으로 변환
    public String convertToGrade(int score, String type) {
        switch (type) {
            case "MANDATORY" -> {
                if (score >= 95 && score <= 100) { return "A"; }
                else if (score >= 90 && score <= 94) { return "B"; }
                else if (score >= 80 && score <= 89) { return "C"; }
                else if (score >= 70 && score <= 79) { return "D"; }
                else if (score >= 60 && score <= 69) { return "F"; }
                else { System.out.println("올바른 점수를 입력하세요..."); }
            }
            case "CHOICE" -> {
                if (score >= 90 && score <= 100) { return "A"; }
                else if (score >= 80 && score <= 89) { return "B"; }
                else if (score >= 70 && score <= 79) { return "C"; }
                else if (score >= 60 && score <= 69) { return "D"; }
                else if (score >= 50 && score <= 59) { return "F"; }
                else { System.out.println("올바른 점수를 입력하세요..."); }
            }
        }

        return null;
    }
}
