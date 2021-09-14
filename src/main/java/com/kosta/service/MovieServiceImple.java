package com.kosta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.dto.MovieDTO;
import com.kosta.mapper.MovieMapper;

@Service(value = "movieservice")
public class MovieServiceImple implements MovieService {

	@Autowired
	private MovieMapper mvMapper;
	
	@Override
	public int insertMovie(MovieDTO dto) {
		
		return mvMapper.insertMovie(dto);
	}

	@Override
	public List<MovieDTO> getMovieList() {
		return mvMapper.getMovieList();
	}

}
