package com.example.presenting_tdd;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CHILDRENS")
public class ChildrensMovie extends Movie {
    public ChildrensMovie(final MovieType movieType, final String title) {
        super(movieType, title);
    }

    public ChildrensMovie() {
    }
}
