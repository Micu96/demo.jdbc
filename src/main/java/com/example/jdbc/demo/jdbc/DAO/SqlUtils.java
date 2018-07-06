package com.example.jdbc.demo.jdbc.DAO;

import java.io.IOException;
import java.sql.*;
import java.util.Iterator;
import java.util.List;


public class SqlUtils {


    public static void createTableMovies(Connection connection) throws SQLException {

        //Start execute a query
        Statement statement = connection.createStatement();
        String sqlDrop = "DROP TABLE IF EXISTS `database`.`Movies`;";
        statement.executeUpdate(sqlDrop);

        String sqlCreate = "CREATE TABLE `database`.`Movies` (\n" +
                "  `imdb_id` VARCHAR(120) NOT NULL,\n" +
                "  `ratings` INT NULL,\n" +
                "  `votes_number` INT NULL,\n" +
                "  `title_type` VARCHAR(120) NULL,\n" +
                "  `primary_title` VARCHAR(255) NULL,\n" +
                "  `original_title` VARCHAR(255) NULL,\n" +
                "  `is_adult` TINYINT(2) NULL,\n" +
                "  `start_year` INT NULL ,\n" +
                "  `end_year` INT NULL,\n" +
                "  `runtime_minutes` INT,\n" +
                "  `generes_1` VARCHAR(45) NULL,\n" +
                "  `generes_2` VARCHAR(45) NULL,\n" +
                "  `generes_3` VARCHAR(45) NULL,\n" +
                "  PRIMARY KEY (`imdb_id`));";
        statement.executeUpdate(sqlCreate);

    }

    public static void insertIntoTableMovies(Connection connection, List<Movie> moviesList) throws IOException, SQLException {


        String sqlInsert = "INSERT INTO database.Movies VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
        Iterator<Movie> iterator = moviesList.iterator();


        while (iterator.hasNext()) {

            try {
                Movie m = iterator.next();

                preparedStatement.setString(1, m.getId());
                preparedStatement.setInt(2, m.getRating().getRatings());
                preparedStatement.setLong(3, m.getRating().getVotesNumbers());
                preparedStatement.setString(4, m.getTitleType());
                preparedStatement.setString(5, m.getPrimaryTitle());
                preparedStatement.setString(6, m.getOriginalTitle());
                preparedStatement.setBoolean(7, m.isAdult());

                if (m.getStartYear().equals("\\N")) {

                    preparedStatement.setNull(8, Types.INTEGER);
                } else {
                    preparedStatement.setInt(8, Integer.parseInt(m.getStartYear()));
                }
                if (m.getEndYear().equals("\\N")) {
                    preparedStatement.setNull(9, Types.INTEGER);
                } else {
                    preparedStatement.setInt(9, Integer.parseInt(m.getEndYear()));
                }
                if (m.getRuntimeMinutes().equals("\\N")) {
                    preparedStatement.setNull(10, Types.INTEGER);
                } else {
                    preparedStatement.setInt(10, Integer.parseInt(m.getRuntimeMinutes()));
                }
                preparedStatement.setString(11, m.getGeneres1());
                preparedStatement.setString(12, m.getGeneres2());
                preparedStatement.setString(13, m.getGeneres3());

                preparedStatement.addBatch();



            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            preparedStatement.executeBatch();

        }


    }

    public static void createTableCrew(Connection connection) throws SQLException{

        Statement statement = connection.createStatement();

        String sqlDrop = "DROP TABLE IF EXISTS `database`.`Crew`";

        statement.executeUpdate(sqlDrop);

        String sqlCreate = "CREATE TABLE `database`.`Crew` (\n" +
                "  `imdb_id` VARCHAR(120) NOT NULL,\n" +
                "  `name_id` VARCHAR(120) NOT NULL,\n" +
                "  `role` VARCHAR(120) NOT NULL);\n";

        statement.executeUpdate(sqlCreate);

    }

    public static  void insertIntoCrewTable(Connection connection, List<Crew> crewList) throws SQLException {



        String sqlInsert = "INSERT INTO database.Crew VALUES(?,?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);

        Iterator<Crew> iterator = crewList.iterator();

        while (iterator.hasNext()){

            try {

                Crew c = iterator.next();

                preparedStatement.setString(1,c.getId());
                preparedStatement.setString(2,c.getName_id());
                preparedStatement.setString(3,c.getRole());

                preparedStatement.addBatch();
            }
            catch (Exception e){

            }

            preparedStatement.executeBatch();


        }


    }
    public static void createTablePrincipal(Connection connection) throws SQLException {

        Statement statement = connection.createStatement();
        String sqlDrop = "DROP TABLE IF EXISTS database.Principal;";
        statement.executeUpdate(sqlDrop);

        String sqlCreate = "CREATE TABLE database.Principal (\n" +
                "  `imdb_id` VARCHAR(120) NOT NULL,\n" +
                "  `ordering` INT NOT NULL,\n" +
                "  `name_id` VARCHAR(120) NULL,\n" +
                "  `role` VARCHAR(120) NULL);\n";

        statement.executeUpdate(sqlCreate);


    }
    public static void insertIntoPrincipalTable(List<Crew> principalList, Connection connection) throws SQLException {



        String sqlInsert = "INSERT INTO database.Principal VALUES(?,?,?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);

        Iterator<Crew> iterator = principalList.iterator();

        while(iterator.hasNext()) {
            try {

                Crew crew = iterator.next();

                preparedStatement.setString(1, crew.getId());
                preparedStatement.setInt(2, crew.getOrder());
                preparedStatement.setString(3, crew.getName_id());
                preparedStatement.setString(4, crew.getRole());


                preparedStatement.addBatch();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        preparedStatement.executeBatch();

    }


}
