package com.junit5.app.java8.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.junit5.app.dto.ListBuilder;
import com.junit5.app.dto.Person;

//https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html
//https://docs.oracle.com/javase/tutorial/collections/index.html
//https://www.oracle.com/technetwork/articles/java/ma14-java-se-8-streams-2177646.html
public class FullStreamTestOracle {
	public List<String> streamFilterSortedMapThenCollectName() {
		List<String> personName=null;
		personName = new ListBuilder().getPersonsList()
				.stream()
				.filter(p -> p.getGender().equalsIgnoreCase("FEMALE"))
				.sorted(Comparator.comparing(Person::getId).thenComparing(Person::getName).reversed())
				.map(Person::getName).collect(Collectors.toList());
		return	personName;
	}
	
	public List<Person> streamFilterSortedMapThenCollectPerson() {
		List<Person> person=new ListBuilder().getPersonsList()
				.stream()
				.filter(p->p.getGender().equalsIgnoreCase("female"))
				.sorted(Comparator.comparing(Person::getId).thenComparing(Person::getName).reversed())
				.collect(Collectors.toList());
		return person;
	}
	
	public Optional<Person> StreamFind(){
		Optional<Person> person= new ListBuilder().getPersonsList()
		.stream()
		.filter(p->p.getName().startsWith("S"))
		.findFirst();
		return person;
		
	} 
	

	public static void main(String[] args) {
		System.out.println(new FullStreamTestOracle().streamFilterSortedMapThenCollectName());
		System.out.println(new FullStreamTestOracle().streamFilterSortedMapThenCollectPerson());
		System.out.println(new FullStreamTestOracle().StreamFind().get());
	}

}
