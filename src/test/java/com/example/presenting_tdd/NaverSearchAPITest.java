package com.example.presenting_tdd;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class NaverSearchAPITest {
    @Autowired
    private NaverSearchAPI naverSearchAPI;

    @Test
    void testApiCall() {
        final SearchResult search = naverSearchAPI.search();
        assertThat(search.items()).hasSize(5);
    }

    private SearchResult search() {

        return naverSearchAPI.search();
    }
}

record SearchResult(String lastBuildDate, String total, String start, String display, List<Item> items) {
}

record Item(String title, String link, String category, String description, String telephone, String address, String roadAddress, String mapx, String map) {
}
