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
	public List<MovieDTO> getMovieList() {
		return mvMapper.getMovieList();
	}

	@Override
	public void movieinsert(List<MovieDTO> mvList) {
		// TODO Auto-generated method stub
		mvMapper.movieinsert(mvList);
	}

	

}
