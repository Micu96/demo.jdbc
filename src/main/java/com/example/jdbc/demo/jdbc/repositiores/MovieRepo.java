package com.example.jdbc.demo.jdbc.repositiores;



import com.example.jdbc.demo.jdbc.DAO.AcademyAward;
import com.example.jdbc.demo.jdbc.DAO.Movie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.function.Predicate;


public class MovieRepo  {

    public static Set<String> readImdbIds(Connection connection) throws SQLException {
        //read ids from Movies tabele

        Set<String> imdbIdSet = new HashSet<>();
        Statement statement = connection.createStatement();

        String sql = "Select * from database.Movies limit 500";

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

//    public static Map<String,Movie> readTitlesFromMovies(Connection connection) throws SQLException {
//
//        Map<String,Movie> titlesMap = new TreeMap<>();
//
//        Statement statement = connection.createStatement();
//
//        String sqlSelect = "Select * from database.Movies;";
//
//        ResultSet resultSet = statement.executeQuery(sqlSelect);
//
//        while (resultSet.next()){
//            String imdb_id = resultSet.getString(1);
//            String title = resultSet.getString(5);
//            String year = resultSet.getString(8);
//            titlesMap.put(imdb_id,new Movie(title,year));
//        }
//
//        return titlesMap;
//
//    }


}
