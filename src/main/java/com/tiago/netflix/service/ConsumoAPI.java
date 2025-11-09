package com.tiago.netflix.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoAPI {

    public String obterDados(String endereco) {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .header("accept", "application/json")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .header("Authorization",
                        "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIwOWQyOTEwNmZjMDUwMmQ3MGVlZGNiZGQzMzYzNjA5YiIsIm5iZiI6MTY4NzQ2NzIzMi45LCJzdWIiOiI2NDk0YjRlMDU0NTA4ZDAxMDExMDNjZjIiLCJzY29wZXMiOlsiYXBpX3JlYWQiXSwidmVyc2lvbiI6MX0.iZhY7DXdUyGW35OmU7P_5B87oTZjDmC8xdR3iuGWxEQ")
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = null;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String json = response.body();
        return json;
    }
}
