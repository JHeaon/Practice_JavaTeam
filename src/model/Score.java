package model;

public class Score {
    private final String scoreId;
    private String studentId;
    private int round;
    private String scoreNumber;
    private String scoreGrade;

    public Score(String seq) {
        this.scoreId = seq;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public String getScoreNumber() {
        return scoreNumber;
    }

    public void setScoreNumber(String scoreNumber) {
        this.scoreNumber = scoreNumber;
    }

    public String getScoreGrade() {
        return scoreGrade;
    }

    public void setScoreGrade(String scoreGrade) {
        this.scoreGrade = scoreGrade;
    }

    public String getScoreId() {
        return scoreId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

}
