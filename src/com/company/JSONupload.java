package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class JSONupload {
    public static String JSONresponse;
    public static void sendPostRequest(String url, String jsonData) throws IOException {
        URL postUrl = new URL(url);
        HttpURLConnection urlConnection = (HttpURLConnection) postUrl.openConnection();
        urlConnection.setRequestMethod("POST");
        urlConnection.setRequestProperty("Content-Type", "application/json");
        urlConnection.setDoOutput(true);

        try (OutputStream outputStream = urlConnection.getOutputStream()) {
            outputStream.write(jsonData.getBytes());
            outputStream.flush();
        }

        int resNum = urlConnection.getResponseCode();
        if (resNum != HttpURLConnection.HTTP_OK) {
            throw new IOException("Błąd HTTP: " + resNum);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        StringBuilder JSONresp = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            JSONresp.append(line);
        }
        reader.close();

        JSONresponse = JSONresp.toString();
    }
}
