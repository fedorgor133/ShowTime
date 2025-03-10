package model;

public class GameContext {

    private MemberStrategy strategy;

    public void setStrategy(MemberStrategy strategy) {
        this.strategy = strategy;
    }

    public String executeStrategy(InterestGroup grup, Person person) {
        return strategy.becomeMember(grup, person);
    }
}
