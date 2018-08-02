package com.example.jdbc.demo.jdbc.repositiores;

import com.example.jdbc.demo.jdbc.DAO.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.swing.*;
import java.io.IOException;
import java.sql.*;
import java.util.Iterator;
import java.util.List;



public class SqlUtils {

    private static final Logger log = LoggerFactory.getLogger(SqlUtils.class);

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
                log.error(e.getMessage());
            }
            preparedStatement.executeBatch();

        }


    }

    public static void createTableCrew(Connection connection) throws SQLException {

        Statement statement = connection.createStatement();

        String sqlDrop = "DROP TABLE IF EXISTS `database`.`Crew`";

        statement.executeUpdate(sqlDrop);

        String sqlCreate = "CREATE TABLE `database`.`Crew` (\n" +
                "  `imdb_id` VARCHAR(120) NOT NULL,\n" +
                "  `name_id` VARCHAR(120) NOT NULL,\n" +
                "  `role` VARCHAR(120) NOT NULL);\n";

        statement.executeUpdate(sqlCreate);

    }

    public static void insertIntoCrewTable(Connection connection, List<Crew> crewList) throws SQLException {


        String sqlInsert = "INSERT INTO database.Crew VALUES(?,?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);

        Iterator<Crew> iterator = crewList.iterator();

        while (iterator.hasNext()) {

            try {

                Crew c = iterator.next();

                preparedStatement.setString(1, c.getId());
                preparedStatement.setString(2, c.getName_id());
                preparedStatement.setString(3, c.getRole().toString());

                preparedStatement.addBatch();
            } catch (Exception e) {
                log.error(e.getMessage());
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

        while (iterator.hasNext()) {
            try {

                Crew crew = iterator.next();

                preparedStatement.setString(1, crew.getId());
                preparedStatement.setInt(2, crew.getOrder());
                preparedStatement.setString(3, crew.getName_id());
                preparedStatement.setString(4, crew.getRole().toString());


                preparedStatement.addBatch();

            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }

        preparedStatement.executeBatch();

    }

    public static void createTableName(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String sqlDrop = "DROP TABLE IF EXISTS `database`.`Name`;";
        statement.executeUpdate(sqlDrop);

        String sqlCreate = "CREATE TABLE database.Name" +
                " (`name_id` VARCHAR(120) NOT NULL," +
                "`primary_name` VARCHAR(120) NOT NULL, " +
                "`birth_year` INT NULL," +
                "`death_year` INT NULL," +
                "PRIMARY KEY(`name_id`));";

        statement.executeUpdate(sqlCreate);

    }

    public static void insertIntoNameTable(List<Name> nameList, Connection connection) throws SQLException {

        String sqlInsert = "INSERT INTO `database`.`Name` VALUES(?,?,?,?);";

        PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);

        Iterator<Name> iterator = nameList.iterator();
        int value = 0;

        while (iterator.hasNext()) {

            try {

                Name name = iterator.next();
                preparedStatement.setString(1, name.getName_id());
                preparedStatement.setString(2, name.getPrimaryName());
                if (name.getBirthYear().equals("\\N")) {
                    preparedStatement.setNull(3, Types.INTEGER);
                } else {
                    preparedStatement.setInt(3, Integer.parseInt(name.getBirthYear()));
                }
                if (name.getDeathYear().equals("\\N")) {
                    preparedStatement.setNull(4, Types.INTEGER);
                } else {
                    preparedStatement.setInt(4, Integer.parseInt(name.getDeathYear()));
                }
            } catch (Exception e) {
                log.error(e.getMessage());
            }
            //System.out.println(value++);
            preparedStatement.addBatch();
        }

        preparedStatement.executeBatch();

    }

    public static void createTableAkas(Connection connection) throws SQLException {

        Statement statement = connection.createStatement();

        String sqlDrop = "DROP TABLE IF EXISTS database.Akas;";
        statement.executeUpdate(sqlDrop);

        String sqlCreate = "CREATE TABLE database.Akas (" +
                "`title_id` VARCHAR(120) NOT NULL," +
                "`ordering` VARCHAR(120) NOT NULL," +
                "`title` VARCHAR(500) NOT NULL," +
                "`region` VARCHAR(120) NULL," +
                "`language` VARCHAR(120) NULL," +
                "`is_original_title` TINYINT(2) NOT NULL);";

        statement.executeUpdate(sqlCreate);

    }

    public static void insertIntoAkasTable(List<Akas> akasList, Connection connection) throws SQLException {

        String sqlInsert = "INSERT INTO database.Akas VALUES (?,?,?,?,?,?);";

        PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);

        Iterator<Akas> iterator = akasList.iterator();

        while (iterator.hasNext()) {

            try {

                Akas akas = iterator.next();

                preparedStatement.setString(1, akas.getImdb_id());
                preparedStatement.setInt(2, akas.getOrder());
                preparedStatement.setString(3, akas.getTitle());
                if (akas.getRegion().equals("\\N")) {
                    preparedStatement.setNull(4, Types.INTEGER);
                } else {
                    preparedStatement.setString(4, akas.getRegion());
                }
                if (akas.getLanguage().equals("\\N")) {
                    preparedStatement.setNull(5, Types.INTEGER);
                } else {
                    preparedStatement.setString(5, akas.getLanguage());
                }
                preparedStatement.setBoolean(6, akas.isOriginTitle());

                preparedStatement.addBatch();

            } catch (Exception e) {
                log.error(e.getMessage());
            }


        }

        preparedStatement.executeBatch();

    }

    public static void createTableBoxOffice(Connection connection) throws SQLException {

        Statement statement = connection.createStatement();

        String sqlDrop = "DROP TABLE IF EXISTS `database`.`BoxOffice`";
        statement.executeUpdate(sqlDrop);

        String sqlCreate = "CREATE TABLE `database`.`BoxOffice` (" +
                "`imdb_id` VARCHAR(120) NOT NULL," +
                "`budget` INT (120) NULL," +
                "`gross` INT (120) NULL," +
                "`crnc` VARCHAR (120) NULL,"+
                "PRIMARY KEY(`imdb_id`));";

        statement.executeUpdate(sqlCreate);

    }

    public static void insertIntoBoxOfficeTable(List<BoxOffice> boxOfficeList, Connection connection) throws SQLException {

        String sqlInsert = "INSERT INTO `database`.`BoxOffice` VALUES(?,?,?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);

        Iterator<BoxOffice> iterator = boxOfficeList.iterator();

        while (iterator.hasNext()) {

            try {
                BoxOffice boxOffice = iterator.next();


                preparedStatement.setString(1, boxOffice.getImdbId());
                preparedStatement.setInt(2, boxOffice.getBudget());
                preparedStatement.setInt(3, boxOffice.getGross());
                preparedStatement.setString(4,boxOffice.getCurrency());

                preparedStatement.addBatch();

            } catch (Exception e) {
                log.error(e.getMessage());
            }

        }
        preparedStatement.executeBatch();
    }

    public static void createTableOscars(Connection connection) throws SQLException {

        Statement statement = connection.createStatement();

        String sqlDrop = "DROP TABLE IF EXISTS `database`.`Oscars`;";

        statement.executeUpdate(sqlDrop);

        String sqlCreate = "CREATE TABLE `database`.`Oscars` (" +
                "`imdb_id` VARCHAR(120) NOT NULL,"+
                "`title` VARCHAR(255) NOT NULL," +
                "`w_year`VARCHAR(120) NOT NULL," +
                "`nomination` VARCHAR (120) NOT NULL," +
                "`win` VARCHAR (120) NOT NULL);";


        statement.executeUpdate(sqlCreate);

    }

    public static void insertIntoOscarsTable(Connection connection, List<AcademyAward> academyAwardList) throws SQLException {

        String sqlInsert = "INSERT INTO `database`.`Oscars` VALUES(?,?,?,?,?);";

        PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);

        Iterator<AcademyAward> iterator = academyAwardList.iterator();

        while (iterator.hasNext()) {
            try {
                AcademyAward movie = iterator.next();
                preparedStatement.setString(1,movie.getImdb_id());
                preparedStatement.setString(2, movie.getName_id());
                preparedStatement.setString(3, movie.getWinning_year());
                preparedStatement.setString(4, movie.getAward_type());
                preparedStatement.setString(5, movie.getWin());


                preparedStatement.addBatch();

            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
        preparedStatement.executeBatch();
    }
}