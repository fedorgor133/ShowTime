package model;

import java.util.ArrayList;

public class Movie extends AudiovisualContent {
    private float rating;
    private ArrayList<Theme> themesList;

    public Movie(String title, int yearFirstRelease, int duration) {
        super(title, yearFirstRelease, duration);
        this.themesList = new ArrayList<>();
    }

    public Movie(String title, String description, String imageUrl, int yearFirstRelease, String language, int duration, float rating) {
        super(title, description, imageUrl, yearFirstRelease, language, duration);
        this.rating = rating;
        this.themesList = new ArrayList<>();
    }

    public ArrayList<Theme> getTematiques() {
        return themesList;
    }

    public void addTematica(Theme theme) {
        themesList.add(theme);
    }
}
