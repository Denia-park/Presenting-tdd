package com.example.presenting_tdd;

public class RentalCalculator {
    public RentalCalculator() {
    }

    RentalResponse getRentalResponse(final RentalRequest rentalRequest, final Movie movie) {
        Integer points = 1;
        if (movie.getType() == MovieType.NEW_RELEASE && rentalRequest.daysRented() > 1) {
            points++;
        }

        Double charge = 0.0;
        if (movie.getType() == MovieType.CHILDRENS) {
            charge = 1.5;
            if (rentalRequest.daysRented() > 3) {
                charge += (rentalRequest.daysRented() - 3) * 1.5;
            }
        } else if (movie.getType() == MovieType.REGULAR) {
            charge = 2.0;
            if (rentalRequest.daysRented() > 2) {
                charge += (rentalRequest.daysRented() - 2) * 1.5;
            }
        } else if (movie.getType() == MovieType.NEW_RELEASE) {
            charge = rentalRequest.daysRented() * 3.0;
        }
        return new RentalResponse(points, charge);
    }
}
