package com.kosta.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class MovieDTO {
	private String rank;
	private String movieCd;
	private String movieNm;
	private String openDt;
	private String image;
	
}
