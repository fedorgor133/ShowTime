package model;

public abstract class AudiovisualContent {
    protected String title;
    protected String description;
    protected String imageUrl;
    protected String language;
    protected int yearFirstRelease;
    protected int duration;

    public AudiovisualContent(String title, int yearFirstRelease, int duration) {
        this.title = title;
        this.yearFirstRelease = yearFirstRelease;
        this.duration = duration;
    }

    public AudiovisualContent(String title, String description, String imageUrl, int yearFirstRelease, String language, int duration) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.yearFirstRelease = yearFirstRelease;
        this.language = language;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearFirstRelease() {
        return yearFirstRelease;
    }

    public String getDescription() {
        return description;
    }
}
