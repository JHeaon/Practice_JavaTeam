package model;

public class Grade {
    private int score;
    private String grade;

    public Grade(int score, String grade) {
        this.score = score;
        this.grade = grade;
    }

    // Getter
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
}
