package com.example.movieapi.dto;

import lombok.Data;

import java.time.LocalDate;

/**
 *映画の情報を管理するDTOクラス
 */
@Data
public class Movie {
    //映画ID
    private Integer movieId;
    //映画のタイトル
    private String title;
    //映画の公開日
    private LocalDate releaseDate;
    //映画の上映時間(分)
    private Integer runningTime;
    //映画の監督名
    private String director;
    //原作の情報
    private String originalWork;
    //脚本を担当した人の名前
    private String script;
    //出演者の情報
    private String castMembers;
    //映画のあらすじや説明
    private String description;
}
