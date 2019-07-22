package com.junit5.app.java8.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.junit5.app.dto.ListBuilder;
import com.junit5.app.dto.Person;

public class ObjectStreamEx {

	public static void runObjectStream() {
		System.out.println(new ListBuilder().getPersonsList());
		new ListBuilder().getPersonsList().stream()
		.filter(x->x.getGender().equalsIgnoreCase("feMale"))
		.map(x->x.getName())
		.distinct()
		.forEach(x->System.out.println(x));
		
	} 
	
	public static void searchObjectStream() {
		Comparator<Person> compareAscending=(p1,p2)->p1.getName().compareTo(p2.getName());
		Comparator<Person> compareDecending=compareAscending.reversed();
		
		 System.out.println(new ListBuilder().getPersonsList()
		 .stream()
		 .sorted(compareDecending)
		 .distinct()
		 .collect(Collectors.toList()));
	} 
	
	public static void sortObjectStream() {
		final Function<Person,Integer> byId=p->p.getId();
		final Function<Person,String> byName=p->p.getName();
		
		System.out.println("Multi sort sequence " + new ListBuilder().getPersonsList().stream()
		.sorted(Comparator.comparing(byId).thenComparing(byName))
		.distinct()
		.collect(Collectors.toList()));
	}
	
	public static void sortAndFilterStream() {
		List<Person> person=new ArrayList<Person>();
		System.out.println(new ListBuilder().getPersonsList());
		new ListBuilder().getPersonsList()
		.stream()
		.filter(p -> p.getId()>10)
		.forEach(p -> person.add(p));
		
		System.out.println("person::" + person);
		
	}
	
	public static void pathExplorer(String st) {
		try {
			Files.list(Paths.get(st))
			.filter(Files::isDirectory)
			.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	 
	
	public static void main(String[] args) {
		ObjectStreamEx.runObjectStream();
		ObjectStreamEx.searchObjectStream();
		ObjectStreamEx.sortObjectStream();
		ObjectStreamEx.sortAndFilterStream();
		System.out.println(new ListBuilder().getPersonsList().size());
		ObjectStreamEx.pathExplorer(".");
	}

}
