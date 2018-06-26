package com.example.jdbc.demo.jdbc;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);


	public static void main(String[] args) throws IOException {

		File myFile = new File("/home/michal/Dokumenty/plik.xls");

		FileInputStream fileInputStream = new FileInputStream(myFile);

		HSSFWorkbook myWorkBook = new HSSFWorkbook(new FileInputStream(myFile));
		HSSFSheet mySheet = myWorkBook.getSheetAt(0);
		Iterator<Row> iterator = mySheet.iterator();

		while (iterator.hasNext()) {
			Row row = iterator.next();

			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {

				Cell cell = cellIterator.next();

				//int numericCellValue = (int)cell.getNumericCellValue();
				Cell cell1 = row.getCell(1);


				List<Object[]> movies = Arrays.asList(cell1.toString()).stream()
						.map(name -> name.split(" "))
						.collect(Collectors.toList());

				movies.forEach(name -> log.info(String.format("Inserting customer record for %s", name[0])));

			}


		}


	}


}
















