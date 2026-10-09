package com.example.movieapi.controller;

import com.example.movieapi.dto.Movie;
import com.example.movieapi.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    private final MovieService movieService;


    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> findAllMovies() {
        List<Movie> movies = movieService.findAll();

        return new ResponseEntity<>(movies, HttpStatus.OK);

    }
}
