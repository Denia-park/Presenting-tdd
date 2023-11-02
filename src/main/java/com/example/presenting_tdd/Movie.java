package com.example.presenting_tdd;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

enum MovieType {
    REGULAR,
    NEW_RELEASE,
    CHILDRENS;
}

@Getter
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private MovieType type;

    public Movie(final String title) {
        this.title = title;
    }

    public Movie() {
    }

    public Movie(final MovieType movieType, final String childrensMovieTitle) {
        type = movieType;
        title = childrensMovieTitle;
    }
}
