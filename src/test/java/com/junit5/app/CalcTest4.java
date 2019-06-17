package com.junit5.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.condition.JRE.JAVA_10;
import static org.junit.jupiter.api.condition.JRE.JAVA_8;
import static org.junit.jupiter.api.condition.JRE.JAVA_9;
import static org.junit.jupiter.api.condition.OS.WINDOWS;

import java.util.logging.Logger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;

import com.junit5.app.java8.Calc;

@DisplayName("CalcTest4") /* Declares a custom display name for the test class or test method */
public class CalcTest4 {
	
	private Calc calc;
	static final Logger logger=Logger.getLogger(CalcTest4.class.getName());
	
	@BeforeEach
	void init() {
		logger.info("Object creation...");
		calc = new Calc();
	}

	@Test /* Denotes that a method is a test method */
	@DisplayName("Case For n numbers of param") /* Declares a custom display name for the test class or test method. */
	void calcCase1() {
		assertEquals(20, calc.Calculator(1, 2, 3, 4, 5, 6),"Test Failed");
	}

	@Test
	@EnabledOnJre(JAVA_8)
	@DisplayName("onJava8 JRE")
	void onJava8() {
		logger.info("Java 8 running");
	}

	@Test
	@EnabledOnJre({ JAVA_9, JAVA_10 })
	void onJava9Or10() {
		logger.info("is Java 9 or Java 10 running : Yes");
	}

	@Test
	@EnabledOnOs(WINDOWS)
	void onWindows() {
		logger.info("is Windows running: True");
	}

	
	@RepeatedTest(5) // run 5 times
	@DisabledIf("0.5 < 0.314159")
	void mightNotBeExecuted() {
		logger.info("might Not Be Executed");
	}
	
	@RepeatedTest(5)
    void repeatedTestWithRepetitionInfo(RepetitionInfo repetitionInfo) {
        assertEquals(5, repetitionInfo.getTotalRepetitions());
    }
	
	@AfterEach
	void clenUp() {
		logger.info("Clean Up Memory...");
		calc = null;
	}

}
