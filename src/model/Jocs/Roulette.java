package model.Jocs;

import controller.Messages;
import model.InterestGroup;
import model.MemberStrategy;
import model.Person;
import java.util.Random;
import model.Params;

public class Roulette implements MemberStrategy {
    private int numRand;

    public Roulette(Params param) {
        this.numRand = param.getNumRand();
    }

    @Override
    public String becomeMember(InterestGroup group, Person person) {
        Random ran = new Random();
        int num = (numRand != -1) ? numRand : ran.nextInt(3);
        // 0 = still follower
        // 1 = new member
        // 2 = nothing
        if (numRand == 0) {
            return Messages.ContinueBeingFollower.getMessage();
        } else if (num == 1) {
            group.addMember(person, 150);
            return Messages.SuccesfulRuleta.getMessage();
        }
        group.removeFollower(person);
        return Messages.LeavingGroup.getMessage();
    }
}
