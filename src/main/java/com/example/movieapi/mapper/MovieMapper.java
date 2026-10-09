package com.example.movieapi.mapper;

import com.example.movieapi.dto.Movie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MovieMapper {

    //公開日が新しい順に表示
    @Select("SELECT movie_id, title, release_date, running_time, director, original_work, script, cast_members, description FROM movies ORDER BY release_date DESC")
    List<Movie> findAll();
}
