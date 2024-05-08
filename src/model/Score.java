package model;

public class Score {
    private final String studentId;
    private final String subjectId;
    private final int testRound;
    private int score;
    private String grade;

    public Score(String studentId, String subjectId, int testRound) {
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.testRound = testRound;
    }

    // Getter
    public String getStudentId() {
        return studentId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public int getTestRound() {
        return testRound;
    }

    public int getScore() {
        return score;
    }

    public String getGrade() {
        return grade;
    }

    // Setter
    public void setScore(int score) {
        this.score = score;
    }

    public void setGrade(String grade) {
        this.grade = grade;
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
