package model.Jocs;

import controller.Messages;
import model.*;

public class Trivia implements MemberStrategy {
    private String resposta;
    private String pregunta;
    public Trivia(Params param) {
        this.pregunta = param.getQuestion();
        this.resposta = param.getAnswer();
    }

    @Override
    public String becomeMember(InterestGroup group, Person person) {
        Question p = group.getQuestion(pregunta);
        if (p != null && p.getCorrectAnswer().equals(resposta)) {
            group.addMember(person, 200);
            return Messages.SuccesfulTrivia.getMessage();
        } else {
            return Messages.WrongTrivia.getMessage();
        }
    }
}