package com.junit5.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.junit5.app.security.PasswordHashing;

@DisplayName("Password Hashing")
public class PasswordHashingTest7 {
	
	private PasswordHashing passwordHashing;
	private static Logger logger=Logger.getLogger(PasswordHashingTest7.class.getName());
	
	@BeforeEach
	void init() {
		logger.info("Init object");
		passwordHashing=new PasswordHashing();
	}
	
	@Test
	@DisplayName("bcrypt Testing")
	void BcryptTest() {
		String password=passwordHashing.EncodePassword__Bcrypt("Xorasysgen00#$%^&");
		logger.info("Encoded password # " + password);
		
	}
	
	@Test
	@DisplayName("Password Matcher")
	void PasswordMatcher() {
		boolean expected=true;
		boolean actual=passwordHashing.validatePasssword__Bcrypt("Sushil", "$2a$10$ncSTr3IYnn42glQsn42oguoiejFdNu8S.MK.ctnR7tfi8HqL5URnW");
		assertEquals(expected,actual,"this should not be succeed" );
				
	}
	
	
	@Test
	@DisplayName("Exception testing")
	void PasswordMatcherException() {
		assertThrows(NullPointerException.class,
				()-> passwordHashing.validatePasssword__Bcrypt(null, "$2a$10$ncSTr3IYnn42glQsn42oguoiejFdNu8S.MK.ctnR7tfi8HqL5URnW"),"Exception is not thrown");
	}

}
