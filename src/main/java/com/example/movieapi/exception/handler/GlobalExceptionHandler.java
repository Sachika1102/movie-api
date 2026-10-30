package com.example.movieapi.exception.handler;

import com.example.movieapi.exception.MovieArgumentNotValidException;
import com.example.movieapi.exception.MovieNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *APIで発生した例外をまとめて処理するクラス
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    //指定された映画が見つからない場合の例外
    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<String> handleMovieNotFoundException(MovieNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    //リクエストの引数が不正な場合の例外処理
    @ExceptionHandler(MovieArgumentNotValidException.class)
    public ResponseEntity<String> MovieArgumentNotValidException(MovieArgumentNotValidException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
