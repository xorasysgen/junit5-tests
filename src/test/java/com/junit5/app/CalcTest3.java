package com.junit5.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.logging.Logger;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.junit5.app.java8.Calc;

@DisplayName("Calc Test Case Class") /* Declares a custom display name for the test class or test method */
public class CalcTest3 {

	private Calc calc;
	static final Logger logger=Logger.getLogger(CalcTest3.class.getName());
	@BeforeAll
	static void initAll() {
		logger.info("Before all:Test case started...");
	}

	@BeforeEach
	void init() {
		logger.info("Object creation...");
		calc = new Calc();
	}

	@Test
	@Disabled("for demonstration purposes")
	@DisplayName("@Disabled demonstration")
	void skippedTest() {
		// not executed
	}

	@Test /* Denotes that a method is a test method */
	@DisplayName("Case For n numbers of param") /* Declares a custom display name for the test class or test method. */
	void calcCase1() {
		assertEquals(21, calc.Calculator(1, 2, 3, 4, 5, 6));
	}

	@Test
	@DisplayName("Case For 0 number of param")
	void calcCase2() {
		assertEquals(0, calc.Calculator());
	}

	@Test
	@DisplayName("Test Abort Test")
    void abortedTest() {
        assumeTrue("Sushil".contains("x"));// if sushil contains x test would be aborted
        fail("test has been aborted, sushil contains x");
    }
	
	
	@Test
	@DisplayName("Aborted Test Next")
    void abortedTestNext() {
        assumeTrue("xsushil".contains("x"));// if sushil contains x test would be aborted
        fail("test has been aborted, sushil contains x");
    }
	
	
	@AfterEach
	void clenUp() {
		logger.info("Clean Up Memory...");
		calc = null;
	}

	@AfterAll
	static void tearDownAll() {
		System.out.println("After all:Test case completed...");
	}
}
