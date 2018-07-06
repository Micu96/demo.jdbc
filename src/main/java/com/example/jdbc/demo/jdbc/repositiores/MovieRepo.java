package com.example.jdbc.demo.jdbc.repositiores;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


public class MovieRepo  {

    public static Set<String> readImdbIds(Connection connection) throws SQLException {
        //read ids from Movie tabele

        Set<String> imdbIdSet= new HashSet<>();
        Statement statement = connection.createStatement();

        String sql = "Select * from database.Movies;";

        ResultSet resultSet = statement.executeQuery(sql);

        while(resultSet.next()) {
            String string = resultSet.getString(1);

            imdbIdSet.add(string);

        }
        System.out.println("Rozmiar imdbList : " + imdbIdSet.size());
        return imdbIdSet;
    }


}
