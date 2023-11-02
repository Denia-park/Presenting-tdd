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
}
