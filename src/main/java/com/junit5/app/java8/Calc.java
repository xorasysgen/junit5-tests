package com.junit5.app.java8;

public class Calc {

	
	public Integer Calculator(Integer ... n){
		Integer sum=0;
		if(n.length<1) 
			return sum;
	
		for (Integer value : n)
			sum=sum+value;
			
		return sum;	
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
