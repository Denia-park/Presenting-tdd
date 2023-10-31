package com.example.presenting_tdd;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class NaverSearchAPITest {
    @Autowired
    private NaverSearchAPI naverSearchAPI;

    @Test
    void testApiCall() {
        final NaverSearchAPI.SearchResult search = naverSearchAPI.search();
        assertThat(search.items()).hasSize(5);
    }

    private NaverSearchAPI.SearchResult search() {

        return naverSearchAPI.search();
    }
}
