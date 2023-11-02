package com.example.presenting_tdd;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
