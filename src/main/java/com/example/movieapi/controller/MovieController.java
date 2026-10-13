package com.example.movieapi.controller;

import com.example.movieapi.dto.Movie;
import com.example.movieapi.service.MovieService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie,
                                           UriComponentsBuilder uriBuilder) {
        Movie createMovie = movieService.saveMovie(movie);

        URI location = uriBuilder.path("/api/movies/{id}").buildAndExpand(createMovie.getMovieId()).toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(location);

        return new ResponseEntity<>(createMovie, headers, HttpStatus.CREATED);
    }
}
