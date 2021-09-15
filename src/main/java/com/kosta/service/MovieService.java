package com.kosta.service;

import java.util.List;

import com.kosta.dto.MovieDTO;

public interface MovieService {

	public List<MovieDTO> getMovieList();

	public void movieinsert(List<MovieDTO> mvList);

	public String updatedate();

}
