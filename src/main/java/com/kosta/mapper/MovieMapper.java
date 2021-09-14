package com.kosta.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kosta.dto.MovieDTO;

@Mapper
public interface MovieMapper {

	public List<MovieDTO> getMovieList();
	public void movieinsert(List<MovieDTO> mvList);

}
