package com.junit5.app.java8.stream;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class IntStreamEx {

	public static void runIntStream(int [] ar) {
		IntSummaryStatistics iss=IntStream.of(ar).summaryStatistics();
		System.out.println(iss);
		
	}
	
	
	public static void main(String[] args) {
		int [] ar= {1,2,3,4,5,6,7,8,9};
		IntStreamEx.runIntStream(ar);

	}

}
