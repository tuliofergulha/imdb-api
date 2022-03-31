package br.com.fergulha.imdb;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class App {

    private static final String URI_STRING = "https://imdb-api.com/API/AdvancedSearch/k_c3yg9s0x?title_type=tv_movie&count=250&sort=user_rating,desc";

    public static void main(String[] args) throws URISyntaxException {

        HttpRequest request = HttpRequest
            .newBuilder()
            .uri(new URI(URI_STRING))
            .GET()
            .build();

        HttpClient client = HttpClient.newHttpClient();
        client.sendAsync(request, BodyHandlers.ofString())
            .thenApply(HttpResponse::body)
            .thenAccept(System.out::println)
            .join();
    }
}
