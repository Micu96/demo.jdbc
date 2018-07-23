package com.example.jdbc.demo.jdbc.DAO;

public class BoxOffice {

    private String imdbId;
    private String budget;
    private String gross;

    public BoxOffice(String imdbId, String budget, String gross) {
        this.imdbId = imdbId;
        this.budget = budget;
        this.gross = gross;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getGross() {
        return gross;
    }

    public void setGross(String gross) {
        this.gross = gross;
    }
}
