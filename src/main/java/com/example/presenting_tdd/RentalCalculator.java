package com.example.presenting_tdd;

public class RentalCalculator {
    public RentalCalculator() {
    }

    RentalResponse getRentalResponse(final Movie movie, final Integer daysRented) {
        Integer points = 1;
        if (movie.getType() == MovieType.NEW_RELEASE && daysRented > 1) {
            points++;
        }

        Double charge = 0.0;
        if (movie.getType() == MovieType.CHILDRENS) {
            charge = 1.5;
            if (daysRented > 3) {
                charge += (daysRented - 3) * 1.5;
            }
        } else if (movie.getType() == MovieType.REGULAR) {
            charge = 2.0;
            if (daysRented > 2) {
                charge += (daysRented - 2) * 1.5;
            }
        } else if (movie.getType() == MovieType.NEW_RELEASE) {
            charge = daysRented * 3.0;
        }
        return new RentalResponse(points, charge);
    }
}
