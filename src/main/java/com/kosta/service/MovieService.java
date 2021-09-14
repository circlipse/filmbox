package com.kosta.service;

import java.util.List;

import com.kosta.dto.MovieDTO;

public interface MovieService {

	public int insertMovie(MovieDTO dto);

	public List<MovieDTO> getMovieList();

}
