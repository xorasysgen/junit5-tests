package com.junit5.app.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public  class Person {

	private Integer id; 
	private String name;
	private String gender;
	
	
	public String toUpper(String string) {
		return string.toUpperCase();
		
	}

}
