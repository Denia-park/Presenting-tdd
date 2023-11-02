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

    Double getCharge() {
        Double charge = 0.0;
        if (getMovie().getType() == MovieType.CHILDRENS) {
            charge = 1.5;
            if (getDaysRented() > 3) {
                charge += (getDaysRented() - 3) * 1.5;
            }
        } else if (getMovie().getType() == MovieType.REGULAR) {
            charge = 2.0;
            if (getDaysRented() > 2) {
                charge += (getDaysRented() - 2) * 1.5;
            }
        } else {
            if (getMovie().getType() == MovieType.NEW_RELEASE) {
                charge = getDaysRented() * 3.0;
            }
        }
        return charge;
    }

    Integer getPoints() {
        Integer points = 1;
        if (getMovie().getType() == MovieType.NEW_RELEASE && getDaysRented() > 1) {
            points++;
        }
        return points;
    }
}
