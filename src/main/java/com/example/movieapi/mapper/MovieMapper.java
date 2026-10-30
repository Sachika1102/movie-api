package com.example.movieapi.mapper;

import com.example.movieapi.dto.Movie;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 *映画情報のデータベース操作を行うMapperインターフェース
 */
@Mapper
public interface MovieMapper {

    //映画を全件取得する
    //公開日が新しい順に並べて取得する
    @Select("SELECT movie_id, title, release_date, running_time, director, original_work, script, cast_members, description FROM movies ORDER BY release_date DESC")
    List<Movie> findAll();

    //映画を新規登録する
    @Insert(""" 
            INSERT INTO movies(
            title, 
            release_date,
            running_time,
            director,
            original_work,
            script,
            cast_members,
            description
            ) 
            VALUES (
            #{title},
            #{releaseDate},
            #{runningTime},
            #{director},
            #{originalWork},
            #{script},
            #{castMembers},
            #{description}
            )
            """)

    //登録後に自動生成された映画IDをMovieオブジェクトに設定する
    @Options(useGeneratedKeys = true, keyProperty = "movieId", keyColumn = "movie_id")
    int insert(Movie movie);

    //指定されたIDの映画を1件取得する
    @Select("""
        SELECT 
            movie_id,
            title, 
            release_date,
            running_time,
            director,
            original_work,
            script,
            cast_members,
            description
        FROM movies WHERE movie_id = #{movieId}
    """)
    Movie findById(long movieId);

    //指定されたIDの映画を削除する
    @Delete("DELETE FROM movies WHERE movie_id = #{movieId}")
    int delete(long movieId);

    //指定された映画のタイトルと説明を更新する
    @Update("UPDATE movies SET title = #{title}, description = #{description} WHERE movie_id = #{movieId}")
    int update(Movie movie);
}

