package com.junit5.app.security;

import org.apache.commons.math3.exception.NullArgumentException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordHashing {
	
	private PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	
	
	public String EncodePassword__Bcrypt(String password) {
		return (password!= null) ? passwordEncoder().encode(password):	null;
	}
	
	public String EncodePassword__Bcrypt__Exclusive__Gensalt(String password) {
		return (password!= null) ? BCrypt.hashpw(password, BCrypt.gensalt()):	null;
	}
	
	public Boolean validatePasssword__Bcrypt(String plainPassword,String cypherPassword) throws  NullArgumentException{
		  if (plainPassword!=null && cypherPassword!=null)
			  return  passwordEncoder().matches(plainPassword, cypherPassword);
		  	  throw new  NullPointerException("Either plainPassword or cypherPassword field is null");
		 
		
	}
	
	public Boolean validatePasssword__Bcrypt___Checkpw(String plainPassword,String cypherPassword) throws  NullArgumentException{
		  if (plainPassword!=null && cypherPassword!=null)
			  return  BCrypt.checkpw(plainPassword, cypherPassword);
		  	  throw new  NullPointerException("Either plainPassword or cypherPassword field is null");
		 
		
	}
	
	public static void fewTest(String plaintext) {
		System.out.println(BCrypt.checkpw(plaintext, "$2a$10$ncSTr3IYnn42glQsn42oguoiejFdNu8S.MK.ctnR7tfi8HqL5URnW"));
		System.out.println(BCrypt.checkpw(plaintext, "$2a$10$VYzb7kSJ/RrddCCbQClq1.1o9i9eBDzsKeQh7AZkka0/h4fEYTvRi"));
		String pw_hash = BCrypt.hashpw(plaintext, BCrypt.gensalt());
		System.out.println(pw_hash);
		String strong_salt = BCrypt.gensalt(10);
		String stronger_salt = BCrypt.gensalt(12);
		String strongest_salt = BCrypt.gensalt(31);
				System.out.println(strong_salt);
				System.out.println(stronger_salt);
				System.out.println(strongest_salt);
	}

	
	public static void main(String[] args) {
		fewTest("Sushil");
		
	}
}
