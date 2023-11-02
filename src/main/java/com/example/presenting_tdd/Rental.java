package com.example.presenting_tdd;

import lombok.Getter;

@Getter
public final class Rental {
    private final Movie movie;
    private final Integer daysRented;

    public Rental(Movie movie, Integer daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }
}
