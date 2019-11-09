package com.mycompany.app;

import java.util.Scanner;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;

/**
 * Fetch info about a country
 *
 */
public class App 
{
    public static final String BASE_COUNTRY_URL =  "https://restcountries.eu/rest/v2/name/";
    public static final String END_URL = "?fullText=true";

    public static void main(String[] args) throws IOException, MalformedURLException, ProtocolException {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter a country: ");

        String countryName = myScanner.nextLine();
        System.out.println("Displaying info for: " + countryName);

        String fullURL = BASE_COUNTRY_URL + countryName + END_URL;
        System.out.println("URL: " + fullURL);

        URL url = new URL(fullURL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json");
        String contentType = connection.getHeaderField("Content-Type");

        FullResponseBuilder fRB = new FullResponseBuilder();
        String response = fRB.getFullResponse(connection);

        System.out.println(response);

        /*
        int status = connection.getResponseCode();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        connection.disconnect();
         */
    }
}
