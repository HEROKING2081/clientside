package ru.clientside.client;

import ru.clientside.model.RailwayCarriage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Client {

    public Object url() throws IOException {

        /*byte[] sampleData = "Sample request body".getBytes();
    HttpRequest request = HttpRequest.newBuilder()
            .uri(new URI("https://postman-echo.com/post%22))
                    .headers("Content-Type", "text/plain;charset=UTF-8")
                    .POST(HttpRequest.BodyPublishers
                            .ofInputStream(() -> new ByteArrayInputStream(sampleData)))
                    .build(); */
        URL url = new URL("http://localhoct:8080/railwayCarriage");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        RailwayCarriage railwayCarriage = new RailwayCarriage();
        in.close();
        return null;

    }
}
