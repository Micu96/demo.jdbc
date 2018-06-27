package com.example.jdbc.demo.jdbc;


import com.sun.org.apache.xpath.internal.operations.Bool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.*;
import java.util.*;
import java.util.function.Function;

import com.example.jdbc.demo.jdbc.DAO.*;

import static java.util.stream.Collectors.toList;


@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);


	public static void main(String[] args) throws IOException {

		File myFileRatings = new File("/home/michal/Dokumenty/plik_ratings.csv");
		File myFileTitles = new File("/home/michal/Dokumenty/data.csv");

		BufferedReader bufferedReaderRatings = null;
		BufferedReader bufferedReaderTitles = null;

		String lineRatings = "";
		String lineTitles ="";
		int mapIncrement = 0;
		int listIncrement= 0;
		int size = 0;

		try {
			bufferedReaderRatings = new BufferedReader(new FileReader(myFileRatings));
			bufferedReaderTitles = new BufferedReader(new FileReader(myFileTitles));
			Map<Integer,RatingsClass> ratingsMap = new TreeMap<>();
			List<MoviesClass> moviesClassesList = new ArrayList<>();

			while ((lineRatings = bufferedReaderRatings.readLine()) != null){

				String[] split = lineRatings.split("\t");

				ratingsMap.put(mapIncrement++,new RatingsClass(split[0],split[1],split[2]));

			}

			while((lineTitles = bufferedReaderTitles.readLine())!=null && size++<20){

				String[] split = lineTitles.split("\t");


//				moviesClassesList.add(listIncrement++,new MoviesClass(split[0],split[1],split[2],split[3],Boolean.parseBoolean(split[4])
//						,split[5],split[6],split[7],split[8]));


				moviesClassesList = Arrays.asList(lineTitles)
						.stream()
						.map(x->x.split("\t"))
						.map(x->new MoviesClass())
						.collect(toList());

			}


			moviesClassesList.forEach(x->System.out.println(x.toString()));












//						movies.forEach(name-> log.info(String.format("%s %s %s %s %s %s %s %s %s ",
//									name[0],name[1],name[2],name[3],name[4],name[5],name[6],name[7],name[8])));




//			while((lineRatings = bufferedReaderRatings.readLine())!=null){
//
//
//					ratings = Arrays.asList(lineRatings).stream()
//						.map(name -> name.split("\t"))
//						.collect(Collectors.toList());
//
//
//			}



		}
		catch (NullPointerException e){
			System.out.println(e);
		}
		catch(IOException e){
			System.out.println(e);
		}
		finally {

			bufferedReaderRatings.close();
			bufferedReaderTitles.close();
		}








		}


	}



















