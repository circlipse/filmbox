package com.kosta.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class KakaopayDTO {
	private String name;
	private String email;
	private String phone;
	private String address;
	private int totalPrice;
}
