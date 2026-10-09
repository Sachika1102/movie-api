package com.example.movieapi.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Movie {
    private Integer movieId;
    private String title;
    private LocalDate releaseDate;
    private Integer runningTime;
    private String director;
    private String originalWork;
    private String script;
    private String castMembers;
    private String description;
}
