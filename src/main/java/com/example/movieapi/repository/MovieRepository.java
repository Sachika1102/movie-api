package com.example.movieapi.repository;

import com.example.movieapi.dto.Movie;
import com.example.movieapi.exception.MovieNotFoundException;
import com.example.movieapi.mapper.MovieMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 映画情報のデータベース操作を行うRepositoryクラス
 */
@Repository
public class MovieRepository {
    //データベース操作を行うMapper
    private final MovieMapper movieMapper;

    //MovieMapperを受け取り、初期化する
    public MovieRepository(MovieMapper movieMapper) {
        this.movieMapper = movieMapper;
    }

    //登録されている映画を全件取得する
    public List<Movie> findAll() {
        return movieMapper.findAll();
    }

    //映画を新規登録する
    public int insertMovie(Movie movie) {
        return movieMapper.insert(movie);
    }

    //指定されたIDの映画を1件取得する
    public Movie findById(long movieId) {
        return movieMapper.findById(movieId);
    }

    //指定されたIDの映画を削除する
    public boolean delete(long movieId) {
        //削除された件数が1件なら成功とする
        return movieMapper.delete(movieId) == 1;
    }

    //映画の情報を更新する
    public Movie update(Movie movie) {
        //更新された件数が0件の場合、対象の映画が存在しないと判断する
        if(movieMapper.update(movie) == 0) {
            throw new MovieNotFoundException(movie.getMovieId());
        }
        //更新した映画情報を返す
        return movie;
    }
}
