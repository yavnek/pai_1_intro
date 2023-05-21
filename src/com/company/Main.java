package com.company;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        final int retires = 3;
        final int delay = 1000;
        //web api 1
        String urlDownload = "https://mdn.github.io/learning-area/javascript/oojs/json/superheroes.json";
        int downloadretires = 0;
        int downloadDelay = delay;
        while (downloadretires <= retires) {
            try {
                JSONdownload.stringJSON(urlDownload);
                String jsonContent = JSONdownload.JSONreturns;
                System.out.println(jsonContent);
                printSuperHeroNames(jsonContent);
                break;
            } catch (IOException e) {
                downloadretires++;
                System.err.println("Błąd podczas pobierania danych JSON, " + downloadretires + " razy kod błedu: " + e.getMessage());
                delay(downloadDelay);
                downloadDelay *= 2;
            }
        }


        String urlUPLOAD = "https://httpbin.org/post";
        String jsonData = "{\"name\": \"jonatan\"}";
        // web api 2

        try {
            JSONupload.sendPostRequest(urlUPLOAD, jsonData);
            System.out.println(JSONupload.JSONresponse);
        } catch (IOException e) {
            System.err.println("Błąd podczas wysyłania żądania HTTP: " + e.getMessage());
        }
    }
    private static void printSuperHeroNames(String JSONreturns) {
        JSONObject jsonObject = new JSONObject(JSONreturns);
        JSONArray members = jsonObject.getJSONArray(("members"));

        for(int i = 0; i< members.length(); i++){
            JSONObject member = members.getJSONObject(i);
            String name = member.getString("name");
            System.out.println(name);
        }
    }

    private static void delay(int backoffDelay) {
        long startTime = System.currentTimeMillis();
        long delay = (long) backoffDelay * 1000;

        while (System.currentTimeMillis() - startTime < delay) {
        }
    }

}
