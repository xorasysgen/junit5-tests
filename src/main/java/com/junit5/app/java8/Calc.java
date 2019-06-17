package com.junit5.app.java8;

import java.util.logging.Logger;

public class Calc {

	private static final Logger logger = Logger.getLogger(Calc.class.getName());

	public Integer Calculator(Integer... n) {
		logger.info("Calc invoked.");
		Integer sum = 0;
		
		if (n.length < 1) return null;
		for (Integer value : n)
			sum = sum + value;
 		    return sum;
	}

	public Long fibonacii(Long number) {
		return number <= 0 ? 1 : fibonacii(number - 1) + fibonacii(number - 2);
	}

	public Long factorial(Long number) {
		return	number==0? new Long(1): factorial(number-1) * number;
	}
	
}
