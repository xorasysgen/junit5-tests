package com.junit5.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import com.junit5.app.java8.Calc;


@DisplayName("Main Class")
public class RepetitionTest {
	
	private Calc calc;
	
	@BeforeEach
	void init() {
		calc=new Calc();
	}
	
	
	@RepeatedTest(3) // use @test annotation together else will get warning message of multiple similar test case 
	void numberTest(RepetitionInfo repet) {
		if(repet.getCurrentRepetition()==1) {
		Integer expected=3;
		Integer actual=calc.Calculator(1,2);
		assertEquals(expected, actual, () -> " it should return " + expected + " But actual is " + actual);
		}
		
		if(repet.getCurrentRepetition()==2) {
			Integer expected=56;
			Integer actual=calc.Calculator(7,2,3,7,5,6,7,5,9,10,23);
			assertEquals(expected, actual, () -> " it should return " + expected + " But actual is " + actual);
		}
		
		if(repet.getCurrentRepetition()==3) {
			Integer expected=45;
			Integer actual=calc.Calculator(1,2,3,4,5,6,7,8,9);
			assertEquals(expected, actual, () -> " it should return " + expected + " But actual is " + actual);
		}
		
		
	}
	
	
	@AfterEach
	void cleanUp() {
		calc=null;
	}
	
}
