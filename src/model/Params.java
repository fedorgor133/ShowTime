package model;

public class Params {
    private String code;
    private int numRand;
    private String answer;
    private String question;

    public Params(String code) {
        this.code = code;
    }

    public Params(int numRand) {
        this.numRand = numRand;
    }

    public Params(String question, String answer) {
        this.answer = answer;
        this.question = question;
    }

    public String getCode() {
        return code;
    }

    public int getNumRand() {
        return numRand;
    }

    public String getAnswer() {
        return answer;
    }

    public String getQuestion() {
        return question;
    }
}
