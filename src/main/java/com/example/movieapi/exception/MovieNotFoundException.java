package com.example.movieapi.exception;

/**
 * 指定されたIDの映画が見つからない場合に発生させる例外クラス
 */
public class MovieNotFoundException extends RuntimeException {
    //映画IDを指定して例外を作成する
    public MovieNotFoundException(long movieId) {
        super("指定されたIDのノートが見つかりません:" + movieId);
    }
}
