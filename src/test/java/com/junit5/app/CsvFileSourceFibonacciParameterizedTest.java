package com.junit5.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.junit5.app.java8.Calc;

@Tag("Statistics")
public class CsvFileSourceFibonacciParameterizedTest {
	

	private static final Logger logger=Logger.getLogger(CsvFileSourceFibonacciParameterizedTest.class.getName());
	
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
	
	@ParameterizedTest(name = "{index}.  Number={0} , Fibonacci={1}")
	@CsvFileSource(resources = "/fib.csv", numLinesToSkip = 0)
	@DisplayName("CSV Reader fibonacci Test")
	@Tag("Trading")
	void csvTest(Long input,String expected) {
		assertEquals(expected,calc.fibonacii(input).toString());
	}
	
	@AfterEach
	void cleanUp() {
		calc=null;
	}
	

}
