package com.example.jdbc.demo.jdbc.DAO;



public class AcademyAward {

    private String imdb_id;
    private String name_id;
    private String winning_year;
    private String award_type;
    private String win;

    public AcademyAward( String imdb_id, String name_id, String winning_year, String award_type, String win) {
        this.imdb_id = imdb_id;
        this.name_id = name_id;
        this.winning_year = winning_year;
        this.award_type = award_type;
        this.win = win;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public String getName_id() {
        return name_id;
    }

    public void setName_id(String name_id) {
        this.name_id = name_id;
    }

    public String getWinning_year() {
        return winning_year;
    }

    public void setWinning_year(String winning_year) {
        this.winning_year = winning_year;
    }

    public String getAward_type() {
        return award_type;
    }

    public void setAward_type(String award_type) {
        this.award_type = award_type;
    }

    public String getWin() {
        return win;
    }

    public void setWin(String win) {
        this.win = win;
    }
}
