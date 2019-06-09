package com.junit5.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.junit5.app.java8.Calc;

public class CalcTest {
	
	private Calc calc=new Calc();
	
	@Test
	void calcCase1() {
		assertEquals(21, calc.Calculator(1,2,3,4,5,6));
	}
	
	@Test
	void calcCase2() {
		assertEquals(null, calc.Calculator());
	}

}
