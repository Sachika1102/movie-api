package com.example.movieapi.repository;

import com.example.movieapi.dto.Movie;
import com.example.movieapi.mapper.MovieMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieRepository {
    private final MovieMapper movieMapper;

    public MovieRepository(MovieMapper movieMapper) {
        this.movieMapper = movieMapper;
    }

    public List<Movie> findAll() {
        return movieMapper.findAll();
    }
}
