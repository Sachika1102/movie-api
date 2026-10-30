package com.example.movieapi.service;

import com.example.movieapi.dto.Movie;
import com.example.movieapi.exception.MovieArgumentNotValidException;
import com.example.movieapi.exception.MovieNotFoundException;
import com.example.movieapi.repository.MovieRepository;
import org.springframework.stereotype.Service;

import javax.management.monitor.MonitorSettingException;
import java.util.List;

/**
 * 映画情報に関する処理を行うServiceクラス
 */
@Service
public class MovieService {
    //データベース操作を行うRepository
    private final MovieRepository movieRepository;

    //MovieRepositoryを受け取り、初期化する
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    //映画を全件取得する
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    //映画を新規登録する
    public Movie saveMovie(Movie movie) {
        //タイトルが未入力の場合は例外を発生させる
        if(movie.getTitle() == null || movie.getTitle().isEmpty()) {
            throw new MovieArgumentNotValidException("title is empty");
        }

        //説明が未入力の場合は例外を発生させる
        if(movie.getDescription() == null || movie.getDescription().isEmpty()) {
            throw new MovieArgumentNotValidException("description is empty");
        }

        //入力内容に問題がなければ映画を登録する
        movieRepository.insertMovie(movie);
        return movie;
    }

    //指定されたIDの映画を1件取得する
    public Movie findById(long movieId) {
        //指定されたIDの映画を取得する
        Movie movie = movieRepository.findById(movieId);

        //映画が見つからない場合は例外を発生させる
        if (movie == null) {
            throw new MovieNotFoundException(movieId);
        }

        return movie;
    }

    //指定されたIDの映画を削除する
    public boolean deleteMovie(long movieId) {
        //削除できなかった場合は映画がみつからないとして例外を発生させる
        if(!movieRepository.delete(movieId)) {
            throw new MovieNotFoundException(movieId);
        }
        return true;
    }

    //指定されたIDの映画情報を更新する
    public Movie update(Movie movie, long movieId) {
        //タイトルが未入力の場合は例外を発生させる
        if(movie.getTitle() == null || movie.getTitle().isEmpty()) {
            throw new MovieArgumentNotValidException("title is empty");
        }

        //説明が未入力の場合は例外を発生させる
        if(movie.getDescription() == null || movie.getDescription().isEmpty()) {
            throw new MovieArgumentNotValidException("description is empty");
        }

        //更新対象の映画を取得する
        Movie targetMovie = movieRepository.findById(movieId);
        //更新対象の映画が見つからない場合は例外を発生させる
        if(targetMovie == null) {
            throw new MovieNotFoundException(movieId);
        }
        //更新対象の映画IDを設定する
        movie.setMovieId(targetMovie.getMovieId());
        //映画情報を更新して、更新後の情報を返す
        return movieRepository.update(movie);
    }
 }
