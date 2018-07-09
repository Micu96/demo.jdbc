package com.example.jdbc.demo.jdbc.Logic;

import com.example.jdbc.demo.jdbc.DAO.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;


public class Reader {

    private static final Logger log = LoggerFactory.getLogger(Builder.class);

    public static Map<String,Rating> readRatings(BufferedReader bufferedReaderRatings) throws IOException {

        Map<String, Rating> map = new TreeMap<>();
        String line;


            while((line = bufferedReaderRatings.readLine())!=null){
                try{

                    String[] split = line.split("\t");
                    if(Integer.parseInt(split[2])>1) {
                        StringBuilder sb = new StringBuilder(split[1]);
                        if (sb.length() == 3) {
                            sb.deleteCharAt(1);
                            split[1] = sb.toString();
                        }
                        if (sb.length() == 4) {
                            sb.deleteCharAt(2);
                            split[1] = sb.toString();
                        }

                        map.put(split[0], new Rating(split));
                    }
                }
                catch (Exception e){
                    log.error(e.getMessage());
                }
            }

        return map;
    }
    private static String[] convertGenres(String [] generes){
        String [] resp = new String[3];
        for( int i =0; i < generes.length; i++) {
            resp[i] = generes[i];
        }
        return resp;
    }
    public static List<Movie> readMovies(BufferedReader bufferedReaderTitles, Map<String, Rating> ratings, long maxRecordNumber) throws IOException {

        List<Movie> list = new LinkedList<>();
        String line;
        log.info("Reading rows from Movie file");

        while ((line = bufferedReaderTitles.readLine()) != null && list.size() < maxRecordNumber) {
            try {

                String[] split = line.split("\t");

                String[] splitGeneres = convertGenres(split[8].split(","));
                String imdbId = split[0];
                if (ratings.containsKey(imdbId)) {
                    Movie movie = new Movie(split, splitGeneres, ratings.get(split[0]));
                    if (RfCriteria.isAGoodMovie(movie)) {
                        list.add(movie);
                    }
                }

            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }

        return list;
    }

    public static List<Crew> readCrew(Set<String> imdbIds, BufferedReader bufferedReaderCrew, long maxRecordNumber) throws IOException {

        List<Crew> crewList = new LinkedList<>();
        String line;
        log.info("Reading rows from the Crew file");
        while ((line = bufferedReaderCrew.readLine()) != null && crewList.size() < maxRecordNumber) {
                try {

                    String[] row = line.split("\t");
                    String[] directors = row[1].split(",");
                    String[] writers = row[2].split(",");

                    String imdbId = row[0];
                    if (imdbIds.contains(imdbId)) {

                        for (String director : directors) {
                            if(!director.equals("\\N")) {
                                Crew crew = new Crew(imdbId, director, Crew.Role.director);
                                crewList.add(crew);
                            }
                        }
                        for (String writer : writers) {
                            if(!writer.equals("\\N")) {
                                Crew crew = new Crew(imdbId, writer, Crew.Role.writer);
                                crewList.add(crew);
                            }
                        }

                    }
                } catch (Exception e) {
                    log.error(e.getMessage());
                }
            }

        return crewList;
    }

    public static List<Crew> readPrincipal(Set<String> imdbIds,BufferedReader bufferedReaderPrincipal, long maxRecordNumber) throws IOException {


        List<Crew> principalList = new LinkedList<>();
        String line;
        log.info("Reading Principals from the file");
        bufferedReaderPrincipal.readLine();
        while((line=bufferedReaderPrincipal.readLine())!=null && principalList.size()<maxRecordNumber) {

            try {

                String[] row = line.split("\t");
                String imbdId = row[0];

                if (imdbIds.contains(imbdId)) {
                    Crew crew = new Crew(row[0], row[1], row[2], Crew.Role.valueOf(row[3]));
                    principalList.add(crew);
                }
            }
            catch (Exception e) {
                log.error(e.getMessage());
            }
        }

        return principalList;
    }
    public static List<Name> readName(BufferedReader bufferedReader, long maxRecordNumber, Set<String> nameIds) throws IOException {

        List<Name> nameList = new LinkedList<>();
        String line;
        log.info("Reading Names from the file");
        bufferedReader.readLine();
        while((line=bufferedReader.readLine())!=null && nameList.size()<maxRecordNumber){

            try {
                String[] row = line.split("\t");
                String nameId = row[0];
                if(nameIds.contains(nameId)) {
                    Name name = new Name(row);
                    nameList.add(name);
                }
            }
            catch (Exception e){
                log.error(e.getMessage());
            }
        }
        return nameList;
    }
    public static List<Akas> readAkas(BufferedReader bufferedReader, Set<String> imdbIds, long maxRecordNumber) throws IOException {

        List<Akas> akasList = new LinkedList<>();
        String line;
        bufferedReader.readLine();
        log.info("Reading Akas from the file");
        while((line=bufferedReader.readLine())!=null && akasList.size()<maxRecordNumber){

            try{
                String[] row = line.split("\t");
                String imdbId = row[0];
                if(imdbIds.contains(imdbId)){

                    Akas akas = new Akas(row);
                    akasList.add(akas);
                }
            }
            catch (Exception e){
                log.error(e.getMessage());
            }
        }
        return akasList;
    }

}
