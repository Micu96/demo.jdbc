package com.example.jdbc.demo.jdbc.Logic;

import ch.qos.logback.core.util.FileUtil;
import org.apache.commons.io.*;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipFile;

public class Downloader {

    private static final String titlesUrl = "https://datasets.imdbws.com/title.basics.tsv.gz";
    private static final String ratingsUrl = "https://datasets.imdbws.com/title.ratings.tsv.gz";
    private static final String akasUrl = "https://datasets.imdbws.com/title.akas.tsv.gz";
    private static final String principalsUrl = "https://datasets.imdbws.com/title.principals.tsv.gz";
    private static final String namesUrl = "https://datasets.imdbws.com/name.basics.tsv.gz";

    private static final String titlesPathOutput = "C:\\Users\\Michał\\Desktop\\imdb_files\\titles.data.csv";
    private static final String ratingsPathOutput = "C:\\Users\\Michał\\Desktop\\imdb_files\\ratings.data.csv";
    private static final String akasPathOutput = "C:\\Users\\Michał\\Desktop\\imdb_files\\akas.data.csv";
    private static final String principalsPathOutput = "C:\\Users\\Michał\\Desktop\\imdb_files\\principals.data.csv";
    private static final String namesPathOutput = "C:\\Users\\Michał\\Desktop\\imdb_files\\names.data.csv";


    public static void download() throws IOException {

       readGZip(titlesUrl,titlesPathOutput);
       readGZip(ratingsUrl,ratingsPathOutput);
       readGZip(principalsUrl,principalsPathOutput);
       readGZip(namesUrl,namesPathOutput);
       readGZip(akasUrl,akasPathOutput);

    }
    public static void readGZip(String urlAddress, String pathOutput){

        byte[] buffer = new byte[1024];
        try{

            URL webSite = new URL(urlAddress);
            URLConnection connection = webSite.openConnection();

            GZIPInputStream gzis =
                    new GZIPInputStream(new BufferedInputStream(connection.getInputStream()));
            FileOutputStream out =
                    new FileOutputStream(pathOutput);

            int len;
            while ((len = gzis.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }

            gzis.close();
            out.close();


        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
