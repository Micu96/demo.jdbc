package com.example.jdbc.demo.jdbc.DAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class Reader {



    public static Map<String,Rating> readRatings(BufferedReader bufferedReaderRatings) throws IOException {

        Map<String, Rating> map = new TreeMap<>();
        String line;


            while((line = bufferedReaderRatings.readLine())!=null){
                try{

                String[] split = line.split("\t");
                if(Integer.parseInt(split[2])>1){
                    StringBuilder sb = new StringBuilder(split[1]);
                    if(sb.length()==3){
                        sb.deleteCharAt(1);
                        split[1] = sb.toString();
                    }
                    if(sb.length()==4){
                        sb.deleteCharAt(2);
                        split[1] = sb.toString();
                    }

                    map.put(split[0],new Rating(split));
                }
                }
                catch (Exception e){
                    System.out.println(e);
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

        while ((line = bufferedReaderTitles.readLine()) != null && list.size() < maxRecordNumber) {
            try {

                String[] split = line.split("\t");


                String[] splitGeneres = convertGenres(split[8].split(","));
                if (ratings.containsKey(split[0])) {
                    Movie movie = new Movie(split, splitGeneres, ratings.get(split[0]));
                    if (RfCriteria.isAGoodMovie(movie)) {
                        list.add(movie);
                    }
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }


        return list;
    }

    public static List<Crew> readCrew(Set<String> imdbIds,BufferedReader bufferedReaderCrew, long maxRecordNumber) throws IOException {

        List<Crew> crewList = new LinkedList<>();
        String line;
        while ((line = bufferedReaderCrew.readLine()) != null && crewList.size() < maxRecordNumber) {
                try {

                    String[] row = line.split("\t");
                    String[] directors = row[1].split(",");
                    String[] writers = row[2].split(",");

                    String imdbId = row[0];
                    if (imdbIds.contains(imdbId)) {

                        for (String director : directors) {
                            if(!director.equals("\\N")) {
                                Crew crew = new Crew(imdbId, director, Crew.Role.Director.toString());
                                crewList.add(crew);
                            }
                        }
                        for (String writer : writers) {
                            if(!writer.equals("\\N")) {
                                Crew crew = new Crew(imdbId, writer, Crew.Role.Writer.toString());
                                crewList.add(crew);
                            }
                        }

                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

        return crewList;

    }

    public static List<Crew> readPrincipal(Set<String> imdbIds,BufferedReader bufferedReaderPrincipal, long maxRecordNumber) throws IOException {


        List<Crew> principalList = new LinkedList<>();
        String line;

        bufferedReaderPrincipal.readLine();
        while((line=bufferedReaderPrincipal.readLine())!=null && principalList.size()<maxRecordNumber) {

            try {

                String[] row = line.split("\t");
                String imbdId = row[0];

                if (imdbIds.contains(imbdId)) {

                    for(Crew.Role role : Crew.Role.values()){
                        if(row[3].equals(role.toString().toLowerCase())){
                            Crew crew = new Crew(row[0], row[1], row[2], role.toString());
                            principalList.add(crew);
                            break;
                        }
                    }
                }
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return principalList;
    }



}
