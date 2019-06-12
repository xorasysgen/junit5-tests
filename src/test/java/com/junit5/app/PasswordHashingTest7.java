package com.junit5.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
		String password=passwordHashing.EncodePassword__Bcrypt("Either plainPassword or cypherPassword field is null");
		logger.info("Encoded password # " + password);
		
	}
	
	@Test
	@DisplayName("Password Matcher")
	void PasswordMatcher() {
		assertEquals(true, passwordHashing.validatePasssword__Bcrypt("Sushil", "$2a$10$ncSTr3IYnn42glQsn42oguoiejFdNu8S.MK.ctnR7tfi8HqL5URnW"));
		assertEquals(true, passwordHashing.validatePasssword__Bcrypt("Sushil", "$2a$10$s4QHQ8KBBZRPHHHaDqv5LOvHMb9LmPLyCltCU.GBihlaYTPs1i1Ge"));
		assertEquals(false, passwordHashing.validatePasssword__Bcrypt("Sushijfgj", "$2a$10$fTd4Vs/rhqFyPMY0dp9UBewU7LdrPOVOXRELpDX6/vvW1AixIt/zq"));
		assertEquals(false, passwordHashing.validatePasssword__Bcrypt(null, "$2a$10$fTd4Vs/rhqFyPMY0dp9UBewU7LdrPOVOXRELpDX6/vvW1AixIt/zq"));
		
	}
	

}
