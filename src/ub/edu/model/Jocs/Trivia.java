package ub.edu.model.Jocs;

import ub.edu.controller.Messages;
import ub.edu.model.*;

public class Trivia implements MemberStrategy {
    private String resposta;
    private String pregunta;
    public Trivia(Params param) {
        this.pregunta = param.getQuestion();
        this.resposta = param.getAnswer();
    }

    @Override
    public String becomeMember(GrupInterest grup, Person person) {
        Question p = grup.getQuestion(pregunta);
        if (p != null && p.getCorrectAnswer().equals(resposta)) {
            grup.addMembre(person, 200);
            return Messages.SuccesfulTrivia.getMessage();
        } else {
            return Messages.WrongTrivia.getMessage();
        }
    }
}