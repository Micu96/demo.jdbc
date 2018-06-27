package com.example.jdbc.demo.jdbc.DAO;

public class MoviesDTO {

    private String id;
    private String titleType;
    private String primaryTitle;
    private String originalTitle;
    private boolean isAdult;
    private String startYear;
    private String endYear;
    private String runtimeMinutes;
    private String generes;


    public MoviesDTO(MoviesClass moviesClass){

        this.id = moviesClass.getId();
        this.titleType = moviesClass.getTitleType();
        this.primaryTitle = moviesClass.getPrimaryTitle();
        this.originalTitle = moviesClass.getOriginalTitle();
        this.isAdult = moviesClass.isAdult();
        this.startYear = moviesClass.getStartYear();
        this.endYear = moviesClass.getEndYear();
        this.runtimeMinutes = moviesClass.getRuntimeMinutes();
        this.generes = moviesClass.getGeneres();


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

    public String getGeneres() {
        return generes;
    }

    public void setGeneres(String generes) {
        this.generes = generes;
    }
}
