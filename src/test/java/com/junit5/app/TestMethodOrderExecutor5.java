package com.junit5.app;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import java.util.logging.Logger;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/*Alphanumeric: sorts test methods alphanumerically based on their names and formal parameter lists.

OrderAnnotation: sorts test methods numerically based on values specified via the @Order annotation.

Random: orders test methods pseudo-randomly and supports configuration of a custom seed.*/

@TestMethodOrder(OrderAnnotation.class)
public class TestMethodOrderExecutor5 {
	static final Logger logger=Logger.getLogger(CalcTest3.class.getName());
	
	@Test
	@Order(1)
	void _first() {
		logger.info("First method");	
	}
	
	@Test
	@Order(3)
	void _second() {
		logger.info("second method");
	}
	
	@Test
	@Order(2)
	void _third() {
		logger.info("third method");
	}
}
