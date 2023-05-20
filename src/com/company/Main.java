package com.company;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String url = "https://mdn.github.io/learning-area/javascript/oojs/json/superheroes.json";
        try {
            JSONdownload.stringJSON(url);
            String jsonContent = JSONdownload.JSONreturns;
            System.out.println(jsonContent);
        } catch (IOException e) {
            System.err.println("Błąd podczas pobierania danych JSON: " + e.getMessage());
        }
    }


}
