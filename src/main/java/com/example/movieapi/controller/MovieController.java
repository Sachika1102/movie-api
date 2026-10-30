package com.example.movieapi.controller;

import com.example.movieapi.dto.Movie;
import com.example.movieapi.service.MovieService;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 *映画情報に関するAPIのリクエストを処理するControllerクラス
 */
@RestController
@RequestMapping("/api/movies")
public class MovieController {
    //映画に関する処理を行うservice
    private final MovieService movieService;

    //MovieServiceを受け取る
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    //映画を全件取得する
    @GetMapping
    public ResponseEntity<List<Movie>> findAllMovies() {
        //映画の一覧を取得する
        List<Movie> movies = movieService.findAll();

        //取得した映画の一覧を返す
        return ResponseEntity.ok(movies);
    }

    //映画を新規登録する
    @PostMapping
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie,
                                           UriComponentsBuilder uriBuilder) {
        //受け取った映画の情報を登録する
        Movie createMovie = movieService.saveMovie(movie);

        //登録した映画のURLを作成する
        URI location = uriBuilder.path("/api/movies/{id}").buildAndExpand(createMovie.getMovieId()).toUri();

        //登録した映画の情報を返す
        return ResponseEntity.created(location).body(createMovie);
    }

    //指定したIDの映画を1件取得する
    @GetMapping("/{movieId}")
    public ResponseEntity<Movie> findById(@PathVariable long movieId) {
        //指定したIDの映画を取得する
        Movie movie = movieService.findById(movieId);

        //取得した映画の情報を返す
        return ResponseEntity.ok(movie);
    }

    //指定したIDの映画を削除する
    @DeleteMapping("/{movieId}")
    public ResponseEntity<Void> deleteMovie(@PathVariable long movieId) {
        //指定したIDの映画を削除する
        movieService.deleteMovie(movieId);

        //削除が完了したことを返す
        return ResponseEntity.noContent().build();
    }

    //指定したIDの映画を更新する
    @PutMapping("/{movieId}")
    public ResponseEntity<Movie> update(@PathVariable long movieId,
                                        @RequestBody Movie movie) {
        //指定したIDの映画を受け取った情報で更新する
        movieService.update(movie, movieId);

        //更新した映画の情報を返す
        return ResponseEntity.ok(movie);

    }

}
