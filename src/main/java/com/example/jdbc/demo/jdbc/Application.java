package com.example.jdbc.demo.jdbc;

import com.example.jdbc.demo.jdbc.DAO.Reader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.sql.*;
import java.util.*;
import com.example.jdbc.demo.jdbc.DAO.*;
import com.example.jdbc.demo.jdbc.repositiores.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Application {


	private static final Logger log = LoggerFactory.getLogger(Application.class);



	private static Connection connection;
	private static BufferedReader bufferedReaderTitles;
	private static BufferedReader bufferedReaderRatings;
	private static BufferedReader bufferedReaderCrew;
	private static BufferedReader bufferedReaderPrincipals;
	private static final int maxRecordNumber = 1000;

	private static final File myFileTitles = new File("/home/michal/Dokumenty/data.csv");
	private static final File myFileRatings = new File("/home/michal/Dokumenty/ratings.csv");
	private static final File myFileCrew = new File("/home/michal/Dokumenty/crew_data.csv");
	private static final File myFilePrincipals = new File("/home/michal/Dokumenty/principals_data.csv");




	public static void main(String[] args) throws SQLException, IOException {

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager
					.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root","root","Kolega66.");
			connection.setAutoCommit(false);
//			buildMovieDB();
//			connection.commit();
//			buildCrewDB();
//			connection.commit();
			buildPrincipalDB();
			connection.commit();


		}
		catch (Exception e) {
            System.out.println(e.getMessage());

        }  finally{
			connection.close();
			if(bufferedReaderRatings != null) {
				bufferedReaderRatings.close();
			}
			if( bufferedReaderTitles != null) {
				bufferedReaderTitles.close();
			}
			if(bufferedReaderCrew != null ) {
				bufferedReaderCrew.close();
			}
			if(bufferedReaderPrincipals != null){
				bufferedReaderPrincipals.close();
			}
		}
        //Koniec - datatime
	}
	public static void buildMovieDB() throws SQLException, IOException {
		bufferedReaderRatings = new BufferedReader(new FileReader(myFileRatings));
		bufferedReaderTitles = new BufferedReader(new FileReader(myFileTitles));
		Map<String, Rating> ratings = Reader.readRatings(bufferedReaderRatings);
		//Start datetime
		SqlUtils.createTableMovies(connection);

		int recCnt = 0;

		List<Movie> movies;

		while(true) {
			movies = Reader.readMovies(bufferedReaderTitles, ratings,maxRecordNumber);
			SqlUtils.insertIntoTableMovies(connection, movies);

			if (movies.size() < maxRecordNumber) {
				break;
			}
			recCnt += movies.size();

			System.out.println(recCnt);

		}

	}

	public static void buildCrewDB() throws SQLException, IOException {
		Set<String> imdbIds = MovieRepo.readImdbIds(connection);
		bufferedReaderCrew = new BufferedReader(new FileReader(myFileCrew));
		SqlUtils.createTableCrew(connection);
		int result = 0;

		while(true) {

			List<Crew> crews = Reader.readCrew(imdbIds, bufferedReaderCrew, maxRecordNumber);

			SqlUtils.insertIntoCrewTable(connection, crews);

			if(crews.size() < 1000){
				break;
			}

			result += crews.size();
			System.out.println(result);

		}


	}

	public static void buildPrincipalDB() throws SQLException, IOException {

		SqlUtils.createTablePrincipal(connection);
		bufferedReaderPrincipals = new BufferedReader(new FileReader(myFilePrincipals));
		Set<String> imdbIds = MovieRepo.readImdbIds(connection);
		int inserted = 0;

		while(true) {
			List<Crew> principals = Reader.readPrincipal(imdbIds, bufferedReaderPrincipals, maxRecordNumber);
			SqlUtils.insertIntoPrincipalTable(principals, connection);

			if(principals.size()<1000){
				break;
			}

			inserted += principals.size();
			System.out.println(inserted);

		}
	}




}



















