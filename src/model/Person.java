package model;

import java.util.*;

public class Person {

    private String pwd;
    private String name;
    private List<AudiovisualContent> watchedHistory;
    private List<AudiovisualContent> watchNext;

    public Person(String name, String pwd) {
        this.pwd = pwd;
        this.name = name;
        this.watchedHistory = new ArrayList<>();
        this.watchNext = new ArrayList<>();
    }

    public String getPwd() {
        return pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPwd(String pwd) { this.pwd = pwd; }

    public List<AudiovisualContent> getWatchedHistory() { return watchedHistory; }

    public List<AudiovisualContent> getWatchNext() { return watchNext; }

    public void addWatchedHistory(AudiovisualContent content) {
        watchedHistory.add(content);
    }

    public void addWatchNext(AudiovisualContent content) {
        watchNext.add(content);
    }

    public void removeWatchNext(AudiovisualContent content) {
        watchNext.remove(content);
    }

    public void removeWatchedHistory(AudiovisualContent content) {
        watchedHistory.remove(content);
    }

    public void emptyWatchedHistory() {
        watchedHistory.clear();
    }

    public void emptyWatchNext() {
        watchNext.clear();
    }
}
