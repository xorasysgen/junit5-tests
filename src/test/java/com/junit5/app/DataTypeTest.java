package com.junit5.app;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.logging.Logger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.junit5.app.ext.TimingExtension;
import com.junit5.app.math.JavaDataTypeLength;

@ExtendWith(TimingExtension.class)
public class DataTypeTest {

	private static final Logger logger=Logger.getLogger(DataTypeTest.class.getName());
	private JavaDataTypeLength javaDataTypeLength;
	
	@BeforeEach
	void init() {
		javaDataTypeLength=new JavaDataTypeLength();
	}
	
	
	@Test
	@DisplayName("Testing data type min max")
	void doDataTypeTest() {
		String Datatype="Float";
		String [] expected=new String[2] ;
		expected[0]=Long.MIN_VALUE+"";
		expected[1]=Long.MAX_VALUE+"";
		String [] actual=javaDataTypeLength.getMinValueMaxValue(Datatype);
		logger.info("[ Min , Max ]" + Arrays.deepToString(actual));
		assertArrayEquals(expected, actual);
	}
	
	@AfterEach
	void clean() {
		javaDataTypeLength=null;
	}
	
}
