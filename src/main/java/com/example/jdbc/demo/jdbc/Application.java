package com.example.jdbc.demo.jdbc;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.security.Principal;
import java.sql.*;
import org.springframework.stereotype.Component;
import static com.example.jdbc.demo.jdbc.Logic.Builder.*;
import com.example.jdbc.demo.jdbc.Logic.*;

@Component
public class Application {


	private static final Logger log = LoggerFactory.getLogger(Application.class);

	private static Connection connection;
	private static BufferedReader bufferedReaderTitles;
	private static BufferedReader bufferedReaderRatings;
	private static BufferedReader bufferedReaderCrew;
	private static BufferedReader bufferedReaderPrincipals;
	private static BufferedReader bufferedReaderName;
	private static BufferedReader bufferedReaderAkas;




	public static void main(String[] args) throws SQLException, IOException {

		long starTime = System.nanoTime();
		try {

			log.info("Program is running");

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager
					.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root","root","Kolega66.");
			log.info("Connected to database");

			connection.setAutoCommit(false);
//			log.info("Building Movie table");
//			buildMovieDB(connection);
//			connection.commit();
//			log.info("Movie table committed");
//			log.info("Building Crew table");
//			buildCrewDB(connection);
//			connection.commit();
//			log.info("Crew table committed");
//			log.info("Building Principal table");
//			buildPrincipalDB(connection);
//			connection.commit();
//			log.info("Principal table committed");
//			log.info("Building Name table");
//			buildNameDB(connection);
//			connection.commit();
//			log.info("Name table committed");
//			log.info("Building Akas table");
//			buildAkasDB(connection);
//			connection.commit();
//			log.info("Akas table committed");
			buildOscarsDB(connection);
			connection.commit();


		}
		catch (Exception e) {
            log.error(e.getMessage());

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
			if(bufferedReaderName!=null){
				bufferedReaderName.close();
			}
			if(bufferedReaderAkas != null){
				bufferedReaderAkas.close();
			}
		}
        //Koniec - datatime

		long endTime = System.nanoTime();
		long totalTime = endTime - starTime;
		long seconds = 1000000000;
		totalTime = totalTime/seconds;
		log.info("Program is stopped");
		log.info("Running time : " +totalTime +" seconds");

	}

}



















