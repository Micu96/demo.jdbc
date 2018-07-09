package com.example.jdbc.demo.jdbc.Logic;

import com.example.jdbc.demo.jdbc.DAO.*;
import com.example.jdbc.demo.jdbc.repositiores.MovieRepo;
import com.example.jdbc.demo.jdbc.repositiores.SqlUtils;
import org.slf4j.Logger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.example.jdbc.demo.jdbc.Application;
import org.slf4j.LoggerFactory;


public class Builder {

    private static BufferedReader bufferedReaderTitles;
    private static BufferedReader bufferedReaderRatings;
    private static BufferedReader bufferedReaderCrew;
    private static BufferedReader bufferedReaderPrincipals;
    private static BufferedReader bufferedReaderName;
    private static BufferedReader bufferedReaderAkas;
    private static final int maxRecordNumber = 10000;

    private static final File myFileTitles = new File("/home/michal/Dokumenty/data.csv");
    private static final File myFileRatings = new File("/home/michal/Dokumenty/ratings.csv");
    private static final File myFileCrew = new File("/home/michal/Dokumenty/crew_data.csv");
    private static final File myFilePrincipals = new File("/home/michal/Dokumenty/principals_data.csv");
    private static final File myFileNames = new File("/home/michal/Dokumenty/name_data.csv");
    private static final File myFileAkas = new File("/home/michal/Dokumenty/akas_data.csv");

    private static final Logger log = LoggerFactory.getLogger(Builder.class);


    public static void buildMovieDB(Connection connection) throws SQLException, IOException {
        bufferedReaderRatings = new BufferedReader(new FileReader(myFileRatings));
        bufferedReaderTitles = new BufferedReader(new FileReader(myFileTitles));
        log.info("Creating Movie table in the database");
        SqlUtils.createTableMovies(connection);
        log.info("Reading ratings from file and adding to a map");
        Map<String, Rating> ratings = Reader.readRatings(bufferedReaderRatings);

        int inserted = 0;

        List<Movie> movies;

        while(true) {
            movies = Reader.readMovies(bufferedReaderTitles, ratings,maxRecordNumber);
            log.info("Inserting into Movie table");
            SqlUtils.insertIntoTableMovies(connection, movies);

            if (movies.size() < maxRecordNumber) {
                break;
            }

            inserted +=movies.size();
            log.info("Table size : "+ inserted + " rows");

        }

    }

    public static void buildCrewDB(Connection connection) throws SQLException, IOException {
        log.info("Creating Crew table in the database");
        SqlUtils.createTableCrew(connection);
        log.info("Reading imdbIds from Movie table");
        Set<String> imdbIds = MovieRepo.readImdbIds(connection);
        bufferedReaderCrew = new BufferedReader(new FileReader(myFileCrew));

        int inserted = 0;

        while(true) {

            List<Crew> crews = Reader.readCrew(imdbIds, bufferedReaderCrew, maxRecordNumber);
            log.info("Inserting data into Crew table");
            SqlUtils.insertIntoCrewTable(connection, crews);

            if(crews.size() < maxRecordNumber){
                break;
            }

            inserted += crews.size();
            log.info("Table size : "+ inserted +" rows");

        }


    }

    public static void buildPrincipalDB(Connection connection) throws SQLException, IOException {
        log.info("Reading ImdbIds from Movie table");
        Set<String> imdbIds = MovieRepo.readImdbIds(connection);
        log.info("Creating Principal table in the database");
        SqlUtils.createTablePrincipal(connection);
        bufferedReaderPrincipals = new BufferedReader(new FileReader(myFilePrincipals));

        int inserted = 0;

        while(true) {
            log.info("Inserting data into Principal table");
            List<Crew> principals = Reader.readPrincipal(imdbIds, bufferedReaderPrincipals, maxRecordNumber);
            SqlUtils.insertIntoPrincipalTable(principals, connection);

            if(principals.size()<maxRecordNumber){
                break;
            }

            inserted += principals.size();
            log.info("Table size " + inserted +" rows");

        }
    }

    public static void buildNameDB(Connection connection) throws SQLException, IOException {
        log.info("Creating Name table in the database");
        SqlUtils.createTableName(connection);

        log.info("Reading NameIds from Principal table");
        Set<String> nameIds = MovieRepo.readNameIds(connection);

        bufferedReaderName = new BufferedReader(new FileReader(myFileNames));

        int inserted = 0;


        while(true){
            log.info("Inserting data into Name table");
            List<Name> nameList = Reader.readName(bufferedReaderName,maxRecordNumber,nameIds);
            SqlUtils.insertIntoNameTable(nameList,connection);
            if(nameList.size()<maxRecordNumber){
                break;
            }
            inserted+=nameList.size();
            log.info("Table size : "+ inserted + " rows");
        }


    }

    public static void buildAkasDB(Connection connection) throws IOException, SQLException {
        log.info("Creating Akas table in the database");
        SqlUtils.createTableAkas(connection);

        log.info("Reading Imdbids from Movies table");
        Set<String> imdbIds = MovieRepo.readImdbIds(connection);

        bufferedReaderAkas = new BufferedReader(new FileReader(myFileAkas));

        int inserted = 0;

        while (true) {
            log.info("Inserting data into Akas table");
            List<Akas> akasList = Reader.readAkas(bufferedReaderAkas, imdbIds, maxRecordNumber);
            SqlUtils.insertIntoAkasTable(akasList,connection);
            if(akasList.size()<maxRecordNumber){
                break;
            }
            inserted+=akasList.size();
            log.info("Table size : "+inserted+" rows");


        }
    }


}
