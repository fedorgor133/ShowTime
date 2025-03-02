package model.Jocs;
import controller.Messages;
import model.InterestGroup;
import model.MemberStrategy;
import model.Person;
import model.Params;

public class AccessCode implements MemberStrategy {
    private String codi;

    public AccessCode(Params params) {
        this.codi = params.getCode();
    }

    @Override
    public String becomeMember(InterestGroup group, Person person) {
        if (group.getAccessCode().equals(codi)) {
            group.addMember(person, 150);
            return Messages.SuccesfulCode.getMessage();
        } else {
            return Messages.WrongCode.getMessage();
        }
    }
}
