package com.example.jdbc.demo.jdbc.DAO;

public class RfCriteria {
     static final long  voteNumbers = 500;
     public static boolean isAGoodMovie(Movie movie) {

        if(movie.getRating().getVotesNumbers()>=voteNumbers){
            return true;
        }
        else{
            return false;
        }

    }
}
