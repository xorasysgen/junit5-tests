package com.junit5.app.dto;

import java.util.ArrayList;
import java.util.List;

public class ListBuilder {

	private List<Person> persons=new ArrayList<Person>();
	
	public List<Person> getPersonsList(){
		persons.add(new Person(3 ,"Sushil","Male"));
		persons.add(new Person(2 ,"James","Male"));
		persons.add(new Person(1 ,"Benjamin","Male"));
		persons.add(new Person(4 ,"LILLY","Female"));
		persons.add(new Person(5 ,"ELIZABETH","Female"));
		persons.add(new Person(11 ,"Alexander","Male"));
		persons.add(new Person(10 ,"Matthew","Male"));
		persons.add(new Person(6 ,"John","Male"));
		persons.add(new Person(7 ,"SOPHIE","Female"));
		persons.add(new Person(8 ,"AMELIA","Female"));
		persons.add(new Person(9 ,"EMMA","Female"));
		
		return persons;
	}
	
	public Person ToUpperCase(Person p) {
		p.setName(p.getName().toUpperCase());
		return p;
	}
	
	
	
}
