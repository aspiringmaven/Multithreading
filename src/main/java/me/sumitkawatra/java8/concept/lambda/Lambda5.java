package me.sumitkawatra.java8.concept.lambda;

import java.util.function.Function;

public class Lambda5 {
	
	public static void main(String[] args) {
		
		/**
		 * Function interface accept method
		 */
		Function<String, Integer> length = (String input) ->  {return input.length();};
		
		System.out.println(length.apply("hello"));
	}

}
