package me.sumitkawatra.java8.concept.collection;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Flatmap concur multiple stream into one.
 * 
 * @author sumkawat
 *
 */
public class Stream4 {
	
	static String []  words = {"hello", "world"};
	
	public static void main(String[] args) {
		
		/**
		 * map method here convert String to String[]
		 */
		 List<String[]> wordsAsStringArray = Stream.of(words).map(name -> name.split("")).distinct().collect(Collectors.toList());
		 
		 /**
		  * flat map concur multiple String[] into one stream :)
		  */
		 Arrays.stream(words).map(name -> name.split("")).flatMap(Arrays::stream).distinct().forEach(System.out::println);
	}
	
	

}
