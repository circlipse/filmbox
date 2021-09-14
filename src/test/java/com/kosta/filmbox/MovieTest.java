package com.kosta.filmbox;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kosta.dto.MovieDTO;
import com.kosta.mapper.MovieMapper;
import com.kosta.mapper.ProMapper;
import com.kosta.service.MovieService;
import com.zaxxer.hikari.HikariDataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src\\main\\webapp\\WEB-INF\\spring\\root-context.xml")
public class MovieTest {
	@Autowired
	private MovieService service;

	@Autowired
	private MovieMapper mapper;
	@Test
	public void t1() {
		MovieDTO dto = new MovieDTO("1", "1", "1", "1", "1");
		assertEquals(0, service.getMovieList());
	}
}
