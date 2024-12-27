package me._xgqd.moneymakingmaker.hypixel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class Request {

    private static JsonParser parser = new JsonParser();

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JsonElement readJsonFromUrl(String url) throws IOException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader();
            String jsonText = readAll(rd);
            JsonElement json = parser.parse(jsonText);
            return json;
        } finally {
            is.close();
        }
    }
}
