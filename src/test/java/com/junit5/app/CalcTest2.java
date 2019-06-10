package com.junit5.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.logging.Logger;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.junit5.app.java8.Calc;

@DisplayName("Calc Test Case Class") /* Declares a custom display name for the test class or test method */
public class CalcTest2 {
	
	private Calc calc;
	static final Logger logger=Logger.getLogger(CalcTest2.class.getName());
	
	@BeforeAll
    static void initAll() {
		logger.info("Before all:Test case started...");
    }
	
	
	@BeforeEach
	void init() {
		logger.info("Object creation...");
		calc=new Calc();
	}
	
	@Test /* Denotes that a method is a test method */
	@DisplayName("Case For n numbers of param") /* Declares a custom display name for the test class or test method. */
	void calcCase1() {
		assertEquals(21, calc.Calculator(1,2,3,4,5,6));
	}
	
	@Test
	@DisplayName("Case For 0 number of param")
	void calcCase2() {
		assertEquals(0, calc.Calculator());
	}
	
	@AfterEach
	void clenUp() {
		logger.info("Clean Up Memory...");
		calc=null;
	}
	
	@AfterAll
    static void tearDownAll() {
		logger.info("After all:Test case completed...");
    }
}
