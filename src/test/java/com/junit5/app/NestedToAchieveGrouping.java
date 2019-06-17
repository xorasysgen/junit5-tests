package com.junit5.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import com.junit5.app.java8.Calc;


@DisplayName("Main Class")
public class NestedToAchieveGrouping {
	
	private Calc calc;
	
	@BeforeEach
	void init() {
		calc=new Calc();
	}
	
	
	@RepeatedTest(2) // use @test annotation together else will get warning message of multiple similar test case 
	void numberTest() {
		Integer expected=56;
		Integer actual=calc.Calculator(7,2,3,7,5,6,7,5,9,10,23);
		assertEquals(expected, actual, () -> " it should return " + expected + " But actual is " + actual);
		
	}
	
	@Nested
	@DisplayName("Nested Positive")
	@Disabled("untill numberTest method is enabled")
	class Positive {
		
			@Test
			void TestPositive() {
				Integer expected=45;
				Integer actual=calc.Calculator(1,2,3,4,5,6,7,8,9);
				assertEquals(expected, actual);
				
			}
	}
	
	@Nested
	@DisplayName("Nested Negative")
	@Disabled("untill numberTest method is enabled")
	class Negative{
		
		@Test
		void  TestNegative() {
			Integer expected=-45;
			Integer actual=calc.Calculator(-1,-2,-3,-4,-5,-6,-7,-8,-9);
			assertEquals(expected, actual);
		}
	}
	
	@AfterEach
	void cleanUp() {
		calc=null;
	}
	
}
