package com.junit5.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.junit5.app.java8.Calc;

@DisplayName("Calc Test Case Class") /* Declares a custom display name for the test class or test method */
public class CalcTest {
	
	private Calc calc=new Calc();
	
	@Test /* Denotes that a method is a test method */
	@DisplayName("Case For n numbers of param") /* Declares a custom display name for the test class or test method. */
	void calcCase1() {
		assertEquals(21, calc.Calculator(1,2,3,4,5,6));
	}
	
	@Test
	@DisplayName("Case For 0 number of param")
	void calcCase2() {
		assertEquals(null, calc.Calculator());
	}

}
