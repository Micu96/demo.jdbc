package com.example.jdbc.demo.jdbc.DAO;



public class AcademyAward {

    private String imdb_id;
    private String title;
    private String award;
    private String nomination;
    private String winningYear;
    private String isBestPicture;


    public AcademyAward(String key,String[] list) {
        this.imdb_id = key;
        this.title = list[0];
        this.winningYear = list[1];
        this.award = list[2];
        this.nomination = list[3];
        this.isBestPicture = list[4];
    }


    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public String getNomination() {
        return nomination;
    }

    public void setNomination(String nomination) {
        this.nomination = nomination;

    }

    public String getWinningYear() {
        return winningYear;
    }

    public void setWinningYear(String winningYear) {
        this.winningYear = winningYear;
    }

    public String getIsBestPicture() {
        return isBestPicture;
    }

    public void setIsBestPicture(String isBestPicture) {
        this.isBestPicture = isBestPicture;
    }
}
