package com.example.jdbc.demo.jdbc.DAO;

public class BoxOffice {

    private String imdbId;
    private Integer budget;
    private Integer gross;
    private String currency;

    public BoxOffice(String imdbId, Integer budget, Integer gross, String currency) {
        this.imdbId = imdbId;
        this.budget = budget;
        this.gross = gross;
        this.currency = currency;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public Integer getGross() {
        return gross;
    }

    public void setGross(Integer gross) {
        this.gross = gross;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
