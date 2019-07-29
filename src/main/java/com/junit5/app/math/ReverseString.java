package com.junit5.app.math;



public class ReverseString {

	public  static String reverseString(String string) {
		StringBuilder sb=new StringBuilder();
		
		if(string==null || string.length()==0)
			 throw new NullPointerException("string can`t be null");
		
		char [] c=string.toCharArray();
		int i=string.toCharArray().length-1;
		while(i>0) {
			sb.append(c[i--]);
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(ReverseString.reverseString("sushil"));
		System.out.println(ReverseString.reverseString(""));

	}

}
