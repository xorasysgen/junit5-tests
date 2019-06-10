package com.junit5.app.java8;

public class Calc {

	public Integer Calculator(Integer... n) {
		Integer sum = 0;
		if (n.length < 1)
			return null;

		for (Integer value : n)
			sum = sum + value;

		return sum;
	}

}
