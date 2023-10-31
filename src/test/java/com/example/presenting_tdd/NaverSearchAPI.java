package com.example.presenting_tdd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
public class NaverSearchAPI {
    @Autowired
    WebClient webClient;

    public NaverSearchAPI() {
    }

    SearchResult search() {
        String query = "주식";
        int display = 5;
        int start = 1;
        String sort = "random";

        SearchResult response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("query", query)
                        .queryParam("display", display)
                        .queryParam("start", start)
                        .queryParam("sort", sort)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(SearchResult.class)
                .block();

        return response;
    }

    @Configuration
    static
    class WebClientConfig {
        @Value("${naver.client.id}")
        private String clientId;

        @Value("${naver.client.secret}")
        private String clientSecret;

        @Bean
        public WebClient webClient() {
            return WebClient.builder()
                    .baseUrl("https://openapi.naver.com/v1/search/local.json")
                    .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .defaultHeader("X-Naver-Client-Id", clientId)
                    .defaultHeader("X-Naver-Client-Secret", clientSecret)
                    .build();
        }
    }

    record SearchResult(String lastBuildDate, String total, String start, String display, List<Item> items) {
    }

    record Item(String title, String link, String category, String description, String telephone, String address, String roadAddress, String mapx, String map) {
    }
}
