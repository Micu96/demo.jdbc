package com.example.jdbc.demo.jdbc.DAO;


public class Movie {

    private String id;
    private String titleType;
    private String primaryTitle;
    private String originalTitle;
    private boolean isAdult;
    private String startYear;
    private String endYear;
    private String runtimeMinutes;
    private String generes1;
    private String generes2;
    private String generes3;

    private Rating rating;

    public Movie() {
    }


    public Movie(String[] args,String[] generes, Rating rating) {

            this.rating = rating;
            this.id = args[0];
            this.titleType = args[1];
            this.primaryTitle = args[2];
            this.originalTitle = args[3];
            this.isAdult = Boolean.parseBoolean(args[4]);
            this.startYear = (args[5]);
            this.endYear = args[6];
            this.runtimeMinutes = args[7];
            this.generes1 = generes[0];
            this.generes2 = generes[1];
            this.generes3 = generes[2];

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitleType() {
        return titleType;
    }

    public void setTitleType(String titleType) {
        this.titleType = titleType;
    }

    public String getPrimaryTitle() {
        return primaryTitle;
    }

    public void setPrimaryTitle(String primaryTitle) {
        this.primaryTitle = primaryTitle;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public boolean isAdult() {
        return isAdult;
    }

    public void setAdult(boolean adult) {
        isAdult = adult;
    }


    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public String getEndYear() {
        return endYear;
    }

    public void setEndYear(String endYear) {
        this.endYear = endYear;
    }

    public String getRuntimeMinutes() {
        return runtimeMinutes;
    }

    public void setRuntimeMinutes(String runtimeMinutes) {
        this.runtimeMinutes = runtimeMinutes;
    }

    public String getGeneres1() {
        return generes1;
    }

    public void setGeneres1(String generes1) {
        this.generes1 = generes1;
    }

    public String getGeneres2() {
        return generes2;
    }

    public void setGeneres2(String generes2) {
        this.generes2 = generes2;
    }

    public String getGeneres3() {
        return generes3;
    }

    public void setGeneres3(String generes3) {
        this.generes3 = generes3;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", titleType='" + titleType + '\'' +
                ", primaryTitle='" + primaryTitle + '\'' +
                ", originalTitle='" + originalTitle + '\'' +
                ", isAdult=" + isAdult +
                ", startYear=" + startYear +
                ", endYear=" + endYear +
                ", runtimeMinutes=" + runtimeMinutes +
                ", generes1='" + generes1 + '\'' +
                ", generes2='" + generes2 + '\'' +
                ", generes3='" + generes3 + '\'' +
                ", rating=" + rating +
                '}';
    }
}
