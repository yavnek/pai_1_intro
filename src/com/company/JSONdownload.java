package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JSONdownload {
    public static String JSONreturns;
    public static void stringJSON(String url) throws IOException {
        //Tworzenie połączenia URl
        URL jsonUrl = new URL(url);
        HttpURLConnection urlConnection = (HttpURLConnection) jsonUrl.openConnection();

        //Ustawianie metody na GET
        urlConnection.setRequestMethod("GET");

        //Określenie czy połączenie jest sprawne
        int resNum = urlConnection.getResponseCode();
        if (resNum != HttpURLConnection.HTTP_OK) {
            throw new IOException("Błąd HTTP: " + resNum);
        }
        //Szczytywanie odpowiedzi
        BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        StringBuilder jsonResp = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonResp.append(line);
        }
        reader.close();

        JSONreturns = jsonResp.toString();
    }
}
