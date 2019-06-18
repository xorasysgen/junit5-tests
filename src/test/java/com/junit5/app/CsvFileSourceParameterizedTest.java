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

import com.junit5.app.math.Library;

@Tag("Math")
public class CsvFileSourceParameterizedTest {
	

	private static final Logger logger=Logger.getLogger(CsvFileSourceParameterizedTest.class.getName());
	
	private Library library;
	@SuppressWarnings("unused")//if you want to use it remove @SuppressWarnings and use it
	private TestInfo testInfo;
	@SuppressWarnings("unused")//if you want to use it remove @SuppressWarnings and use it
	private TestReporter testReporter;
	
	@BeforeEach
	void init(TestInfo testInfo,TestReporter testReporter) {
		logger.log(Level.FINE, "init successful");
		this.testInfo=testInfo;
		this.testReporter=testReporter;
		library=new Library();
		testReporter.publishEntry("Testing " + testInfo.getDisplayName() + " With tag# " + testInfo.getTags());
	}
	
	@ParameterizedTest(name = "{index} >>> rank={0} , fruit={1}")
	@CsvFileSource(resources = "/fruits.csv", numLinesToSkip = 1)
	@DisplayName("CSV Reader Test")
	void csvTest(Integer inputRank,String expectedFruit) {
		assertEquals(expectedFruit,library.getFruit(inputRank));
	}
	
	
	
	@AfterEach
	void cleanUp() {
		library=null;
	}
	

}
