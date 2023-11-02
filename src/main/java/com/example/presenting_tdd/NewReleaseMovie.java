package com.example.presenting_tdd;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("NEW_RELEASE")
public class NewReleaseMovie extends Movie {
    public NewReleaseMovie(final MovieType movieType, final String title) {
        super(movieType, title);
    }

    public NewReleaseMovie() {
    }

    @Override
    Double getCharge(final Integer daysRented1, final Rental rental) {
        return daysRented1 * 3.0;
    }

    @Override
    Integer getPoints(final Integer daysRented1, final Rental rental) {
        Integer points = 1;
        if (daysRented1 > 1) {
            points++;
        }
        return points;
    }
}
