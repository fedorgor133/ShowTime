package ub.edu.model.Jocs;
import ub.edu.controller.Messages;
import ub.edu.model.GrupInterest;
import ub.edu.model.MemberStrategy;
import ub.edu.model.Person;
import ub.edu.model.Params;

public class AccessCode implements MemberStrategy {
    private String codi;

    public AccessCode(Params params) {
        this.codi = params.getCode();
    }

    @Override
    public String becomeMember(GrupInterest grup, Person person) {
        if (grup.getAccessCode().equals(codi)) {
            grup.addMembre(person, 150);
            return Messages.SuccesfulCode.getMessage();
        } else {
            return Messages.WrongCode.getMessage();
        }
    }
}
