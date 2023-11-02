package com.example.presenting_tdd;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("REGULAR")
public class RegularMovie extends Movie {
    public RegularMovie(final MovieType movieType, final String title) {
        super(movieType, title);
    }

    public RegularMovie() {
    }
}
