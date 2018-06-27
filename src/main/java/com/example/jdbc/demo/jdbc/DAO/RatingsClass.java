package com.example.jdbc.demo.jdbc.DAO;

public class RatingsClass {

    private String id;
    private String ratings;
    private String votesNumbers;

    public RatingsClass() {
    }

    public RatingsClass(String id, String ratings, String votesNumbers) {
        this.id = id;
        this.ratings = ratings;
        this.votesNumbers = votesNumbers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }

    public String getVotesNumbers() {
        return votesNumbers;
    }

    public void setVotesNumbers(String votesNumbers) {
        this.votesNumbers = votesNumbers;
    }

    @Override
    public String toString() {
        return "RatingsClass{" +
                "id=" + id +
                ", ratings=" + ratings +
                ", votesNumbers=" + votesNumbers +
                '}';
    }
}
