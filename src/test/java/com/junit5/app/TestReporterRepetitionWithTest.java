package com.junit5.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.condition.JRE.JAVA_8;

import java.util.logging.Logger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.condition.EnabledOnJre;

import com.junit5.app.java8.Calc;


@DisplayName("Main Class")
@Tag("Repeated") // at this place can use
public class TestReporterRepetitionWithTest {
	
	private static final Logger logger=Logger.getLogger(TestReporterRepetitionWithTest.class.getName());
	private Calc calc;
	@SuppressWarnings("unused")//if you want to use it remove @SuppressWarnings and use it
	private TestInfo testInfo;
	@SuppressWarnings("unused")//if you want to use it remove @SuppressWarnings and use it
	private TestReporter testReporter;
	
	@BeforeEach
	void init(TestInfo testInfo,TestReporter testReporter) {
		this.testInfo=testInfo;
		this.testReporter=testReporter;
		calc=new Calc();
		logger.info(testInfo.getDisplayName());
		testReporter.publishEntry("Testing " + testInfo.getDisplayName() + " With tag" + testInfo.getTags());
	}
	
	
	@Test
	@EnabledOnJre(JAVA_8)
	@DisplayName("onJava8 JRE")
	@Tag("SystemInfo")
	void onJava8() {
		logger.info("Java 8 running");
	}
	
	@RepeatedTest(3) // use @test annotation together else will get warning message of multiple similar test case
	@Tag("Repeated")
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
