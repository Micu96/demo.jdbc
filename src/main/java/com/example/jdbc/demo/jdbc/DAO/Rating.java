package com.example.jdbc.demo.jdbc.DAO;

public class Rating {

    private String id;
    private int ratings;
    private long votesNumbers;

    public Rating() {
    }


    public Rating(String[] args){

        this.id = args[0];
        this.ratings = Integer.parseInt(args[1]);
        this.votesNumbers = Long.parseLong(args[2]);

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    public long getVotesNumbers() {
        return votesNumbers;
    }

    public void setVotesNumbers(long votesNumbers) {
        this.votesNumbers = votesNumbers;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", ratings=" + ratings +
                ", votesNumbers=" + votesNumbers +
                '}';
    }
}
