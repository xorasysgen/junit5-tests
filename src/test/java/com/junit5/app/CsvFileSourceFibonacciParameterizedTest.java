package com.junit5.app;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import com.junit5.app.ext.TimingExtension;
import com.junit5.app.java8.Calc;

@Tag("Statistics")
@ExtendWith(TimingExtension.class)
public class CsvFileSourceFibonacciParameterizedTest {
	

	private static final Logger logger=Logger.getLogger(CsvFileSourceFibonacciParameterizedTest.class.getName());
	
	private Calc calc;
	@SuppressWarnings("unused")//if you want to use it remove @SuppressWarnings and use it
	private TestInfo testInfo;
	@SuppressWarnings("unused")//if you want to use it remove @SuppressWarnings and use it
	private TestReporter testReporter;
	
	@BeforeEach
	void init(TestInfo testInfo,TestReporter testReporter) {
		logger.log(Level.FINE, "init successful");
		this.testInfo=testInfo;
		this.testReporter=testReporter;
		calc=new Calc();
		testReporter.publishEntry("Testing " + testInfo.getDisplayName() + " With tag# " + testInfo.getTags());
	}
	
	@ParameterizedTest(name = "{index}.  Number={0} , Fibonacci={1}")
	@CsvFileSource(resources = "/fib.csv", numLinesToSkip = 1)
	@DisplayName("CSV Reader fibonacci Test")
	@Tag("Trading")
	@Disabled("@Disabled until CSV Reader Factorial Test #Fact active")
	void csvReaderFibonacciTest(Long input,String expected) {
		assertEquals(expected,calc.fibonacii(input).toString());
		assertTimeoutPreemptively(ofMillis(3000),() -> calc.fibonacii(input));
		assertTimeout(ofMillis(3000), () -> calc.fibonacii(input));
	}
	
	
	@ParameterizedTest(name = "{index}#  Number={0} , Factorial={1}")
	@DisplayName("CSV Reader Factorial Test #Fact")
	@Tag("Trading")
	@CsvSource({
		"3 , 6",
		"4 , 24",
		"7 , 5040",
		"8 , 40320",
		"9 , 362880",
		"10 , 3628800",
		"14 , 87178291200",
		"15, 1307674368000",
		"16, 20922789888000",
		"17, 355687428096000",
		"18, 6402373705728000",
		"19,121645100408832000",
		"20 ,2432902008176640000",
		"65, -9223372036854775808"
	}
	)
	void csvReaderFactorialssertTimeoutTest(Long input,Long expected) {
		Long actual=calc.factorial(input);
		assertEquals(expected,actual);
		assertTimeoutPreemptively(ofMillis(1),() -> actual);
		assertTimeout(ofMillis(1), () -> actual);
	}
	
	@AfterEach
	void cleanUp() {
		calc=null;
	}
	

}
