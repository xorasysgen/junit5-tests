package com.junit5.app;

import static org.junit.jupiter.api.Assertions.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.junit5.app.java8.Calc;

@Tag("Math")
public class FibonaciiParameterizedTest {
	

	private static final Logger logger=Logger.getLogger(FibonaciiParameterizedTest.class.getName());
	
	private Calc calc;
	@SuppressWarnings("unused")//if you want to use it remove @SuppressWarnings and use it
	private TestInfo testInfo;
	@SuppressWarnings("unused")//if you want to use it remove @SuppressWarnings and use it
	private TestReporter testReporter;
	
	@BeforeEach
	void init(TestInfo testInfo,TestReporter testReporter) {
		logger.log(Level.FINE, "init successful");
		this.testInfo=testInfo;
		this.testReporter=testReporter;
		calc=new Calc();
		testReporter.publishEntry("Testing " + testInfo.getDisplayName() + " With tag# " + testInfo.getTags());
	}
	
	
		
	@RepeatedTest(4) // use @test annotation together else will get warning message of multiple similar test case
	@Tag("Fibonacii")
	void fibonaciiTest(RepetitionInfo info) {
		int value =info.getCurrentRepetition();
		switch (value) {
		case  1 :
		{
			Long expected=new Long("120");
			Long actual=calc.factorial(new Long(5));
			assertEquals(expected, actual);
			break;
		}
		case  2 :
		{
			Long expected=new Long("1307674368000");
			Long actual=calc.factorial(new Long(15));
			assertEquals(expected, actual);
			break;
		}
		case  3 :
		{
			Long expected=new Long("7034535277573963776");
			Long actual=calc.factorial(new Long(25));
			assertEquals(expected, actual);
			break;
		}
		case  4 :
		{
			Long expected=new Long("6399018521010896896");
			Long actual=calc.factorial(new Long(35));
			assertEquals(expected, actual);
			break;
		}
		
		}
		
	}
	
	
	
	
	
	@RepeatedTest(3) // use @test annotation together else will get warning message of multiple similar test case
	@Tag("Factorial")
	void factorialTest(RepetitionInfo info) {
		int value =info.getCurrentRepetition();
		switch (value) {
			case  1 :
			{
				Long expected=new Long("6");
				Long actual=calc.factorial(new Long(3));
				assertEquals(expected, actual);
				break;
			}
			case  2 :
			{
				Long expected=new Long("120");
				Long actual=calc.factorial(new Long(5));
				assertEquals(expected, actual);
				break;
			}
			case  3 :
			{
				Long expected=new Long("3628800");
				Long actual=calc.factorial(new Long(10));
				assertEquals(expected, actual);
				break;
			}
		
		}
		
	}
	
	@ParameterizedTest
	@CsvSource({
		"3 , 6",
		"4 , 24",
		"7 , 5040",
		"8 , 40320",
		"9 , 362880",
		"10 , 3628801",
		"14 , 87178291200"
	}
	)
	void parameterizedFactorialTest(Long n,Long expected) {
		Long actual=calc.factorial(new Long(n));
		assertEquals(expected, actual);
	}
	
	
	@ParameterizedTest
	@CsvSource(value={
		"test:test", "tEst:test2", "Java:java"}, delimiter = ':'
		)
	@DisplayName("Parameterized String test")
	void toLowerCase_ShouldGenerateTheExpectedLowercaseValue(String input, String expected) {
	    String actualValue = input.toLowerCase();
	    assertEquals(expected, actualValue);
	}
	
	@AfterEach
	void cleanUp() {
		calc=null;
	}
	

}
