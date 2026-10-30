package com.example.movieapi.exception;

import com.example.movieapi.dto.Movie;

/**
 * 映画の引数が不正な場合に発生させる例外クラス
 */
public class MovieArgumentNotValidException extends RuntimeException {
    //エラーメッセージを指定して例外を作成する
    public MovieArgumentNotValidException(String message) {
        super(message);
    }
}
