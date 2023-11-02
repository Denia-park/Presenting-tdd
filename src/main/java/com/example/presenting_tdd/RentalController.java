package com.example.presenting_tdd;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rentals")
public class RentalController {
    private final MovieRepository movieRepository;

    public RentalController(final MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping
    public Movie getRentals(@RequestParam String title) {
        return movieRepository.findByTitle(title);
    }

    @PostMapping
    public RentalResponse addRental(@RequestBody RentalRequest rentalRequest) {
        return new RentalResponse(1, 1.5);
    }
}

record RentalRequest(String title, Integer daysRented) {
}

record RentalResponse(Integer frequentRentalPoints, Double charge) {
}
