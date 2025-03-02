package model;

import java.util.List;

public class Question {
    private String category;
    private String statement;
    private String correctAnswer;
    private List<String> incorrectAnswers;

    public Question(String category, String statement, String correctAnswer, List<String> incorrectAnswers) {
        this.category = category;
        this.statement = statement;
        this.correctAnswer = correctAnswer;
        this.incorrectAnswers = incorrectAnswers;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getStatement() {
        return statement;
    }
}
