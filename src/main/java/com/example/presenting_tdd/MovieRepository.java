package com.example.presenting_tdd;

public class MovieRepository {
    public MovieRepository() {
    }

    static Movie findMovieBy(final String title, final Movie.MovieType type) {
        return Movie.of(title, type);
    }
}
