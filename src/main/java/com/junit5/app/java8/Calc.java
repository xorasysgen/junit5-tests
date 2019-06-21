package com.junit5.app.java8;

import java.math.BigInteger;
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
		return number==0 ? new Long("0") : number<=2 ? new Long("1") :number==0 ? new Long(1): number <= 2 ? 1 : fibonacii(number - 1) + fibonacii(number - 2);
	}

	public BigInteger fibonacii(Integer number) {
		return number==0 ? new BigInteger("0") : number<=2 ? new BigInteger("1") : number <= 1 ? BigInteger.ONE : fibonacii(number-1).add(fibonacii(number-2));
	}
	
	public Long factorial(Long number) {
		return	number==0? new Long(1): factorial(number-1) * number;
	}

	
	
}
