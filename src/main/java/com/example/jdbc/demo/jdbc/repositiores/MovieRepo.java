package com.example.jdbc.demo.jdbc.repositiores;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


public class MovieRepo  {

    public static Set<String> readImdbIds(Connection connection) throws SQLException {
        //read ids from Movies tabele

        Set<String> imdbIdSet = new HashSet<>();
        Statement statement = connection.createStatement();

        String sql = "Select * from database.Movies limit 1000";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            String string = resultSet.getString(1);

            imdbIdSet.add(string);

        }

        return imdbIdSet;
    }


    public static Set<String> readNameIds(Connection connection) throws SQLException {

        Set<String> nameIds = new HashSet<>();

        Statement statement = connection.createStatement();

        String sql = "Select * from `database`.`Principal`;";

        ResultSet resultSet = statement.executeQuery(sql);

        while(resultSet.next()){
            String nameId = resultSet.getString(3);
            nameIds.add(nameId);
        }

        return nameIds;
    }

//    public static MovieDTO findByImdbId(Connection connection) throws SQLException {
//
//        Statement statement = connection.createStatement();
//
//        String sql = "Select * from `database`.`Movies`;";
//
//        ResultSet resultSet = statement.executeQuery(sql);
//        MovieDTO movieDTO = null;
//
//        while(resultSet.next()){
//
//            String imdb_id = resultSet.getString(1);
//            int rating = resultSet.getInt(2);
//            long voteNumber = resultSet.getLong(3);
//            String titleType = resultSet.getString(4);
//            String primaryTitle = resultSet.getString(5);
//            String originalTitle = resultSet.getString(6);
//            boolean isAdult = resultSet.getBoolean(7);
//            String startYear = resultSet.getString(8);
//            String endYear = resultSet.getString(9);
//            String runTime = resultSet.getString(10);
//            String generes1 = resultSet.getString(11);
//            String generes2 = resultSet.getString(12);
//            String generes3 = resultSet.getString(13);
//
//            movieDTO = new MovieDTO(imdb_id,rating,voteNumber,titleType,primaryTitle
//            ,originalTitle,isAdult,startYear,endYear,runTime,generes1,generes2,generes3);
//
//        }
//
//        return movieDTO;
//
//    }


}
