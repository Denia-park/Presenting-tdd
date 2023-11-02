package com.example.presenting_tdd;

public abstract class Movie {
    String title;
    MovieType type;

    public Movie() {
    }

    protected Movie(final String title, final MovieType type) {
        this.title = title;
        this.type = type;
    }

    public static Movie of(final String title, final MovieType type) {
        switch (type) {
            case CHILDRENS:
                return new ChildrenMovie(title, MovieType.CHILDRENS);
            case REGULAR:
                return new RegularMovie(title, MovieType.REGULAR);
            case NEW_RELEASE:
                return new NewReleaseMovie(title, MovieType.NEW_RELEASE);
            default:
                throw new IllegalArgumentException("Invalid movie type");
        }
    }

    public abstract Integer getFrequenceRenterPoints(int daysRented1);

    public abstract Double getCharge(int daysRented1);

    enum MovieType {
        CHILDRENS,
        REGULAR,
        NEW_RELEASE
    }
}
