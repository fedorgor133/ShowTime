package model;

import java.util.*;

public class InterestGroup {

    private String groupName;
    private String description;
    private String accessCode;
    private ArrayList<AudiovisualContent> contentList; // Llista de contingut audiovisual
    private HashMap<Person, Integer> membersList; // Llista seguidors
    private ArrayList<Person> followersList; // Llista membres
    private ArrayList<Question> questionsTrivia;

    public InterestGroup(String groupName, String description, String accessCode) {
        this.groupName = groupName;
        this.description = description;
        contentList = new ArrayList<>();
        followersList = new ArrayList<>();
        membersList = new HashMap<>();
        this.accessCode = accessCode;
        this.questionsTrivia = new ArrayList<>();
    }

    public String getGroupName() { return groupName; }

    public String getAccessCode() { return accessCode;}

    public ArrayList<AudiovisualContent> getContent() {
        return contentList;
    }

    public HashMap<Person, Integer> getMembersList() { return membersList; }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addContent(AudiovisualContent content) {
        if (!contentList.contains(content)) contentList.add(content);
    }

    // Afegir un seguidor al grup
    public void addMember(Person person, int i) {
        if (!membersList.containsKey(person)) membersList.put(person, i);
    }

    // Eliminar un seguidor del grup
    public void removeFollower(Person person) { followersList.remove(person); }

    // Afegir un membre al grup
    public void addFollower(Person person) {
        if (!followersList.contains(person)) followersList.add(person);
    }

    public Person getFollower(String nom) {
        for (Person p : followersList) {
            if (p.getName().equals(nom)) return p;
        }
        return null;
    }

    // Eliminar un membre del grup
    public void removeMember(Person person) { membersList.remove(person); }

    public String accesMembership(MemberStrategy strategy, InterestGroup grup, Person person) {
        return strategy.becomeMember(grup, person);
    }

    public void addQuestionTrivia(Question p) {
        questionsTrivia.add(p);
    }

    public Question getQuestion(String pregunta) {
        for (Question p: questionsTrivia) {
            if (p.getStatement().equals(pregunta))
                return p;
        }
        return null;
    }

    public int getMemberPoints(Person person) {
        if (membersList.containsKey(person)) {
            return membersList.get(person);
        }
        return 0;
    }
}
