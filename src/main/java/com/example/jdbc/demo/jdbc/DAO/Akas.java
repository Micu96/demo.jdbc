package com.example.jdbc.demo.jdbc.DAO;

public class Akas {

    private String imdb_id;
    private int order;
    private String title;
    private String region;
    private String language;
    private boolean originTitle;

    public Akas(String[] splited) {
        this.imdb_id = splited[0];
        this.order = Integer.parseInt(splited[1]);
        this.title = splited[2];
        this.region = splited[3];
        this.language = splited[4];
        this.originTitle = Boolean.parseBoolean(splited[7]);
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isOriginTitle() {
        return originTitle;
    }

    public void setOriginTitle(boolean originTitle) {
        this.originTitle = originTitle;
    }

    @Override
    public String toString() {
        return "Akas{" +
                "titleId='" + imdb_id + '\'' +
                ", order=" + order +
                ", title='" + title + '\'' +
                ", region='" + region + '\'' +
                ", language='" + language + '\'' +
                ", originTitle=" + originTitle +
                '}';
    }
}
