package ub.edu.model.Jocs;

import ub.edu.controller.Messages;
import ub.edu.model.GrupInterest;
import ub.edu.model.MemberStrategy;
import ub.edu.model.Person;
import java.util.Random;
import ub.edu.model.Params;

public class Roulette implements MemberStrategy {
    private int numRand;

    public Roulette(Params param) {
        this.numRand = param.getNumRand();
    }

    @Override
    public String becomeMember(GrupInterest grup, Person person) {
        Random ran = new Random();
        int num = (numRand != -1) ? numRand : ran.nextInt(3);
        // 0 = still follower
        // 1 = new member
        // 2 = nothing
        if (numRand == 0) {
            return Messages.ContinueBeingFollower.getMessage();
        } else if (num == 1) {
            grup.addMembre(person, 150);
            return Messages.SuccesfulRuleta.getMessage();
        }
        grup.removeFollower(person);
        return Messages.LeavingGroup.getMessage();
    }
}
