package me.sumitkawatra.java8.concept.lambda.practice;

import java.util.function.Function;

/**
 * Composing functional methods.
 * @author sumkawat
 *
 */
public class Practice4 {
	
	public static void main(String[] args) {
		
		Function<Integer, Integer> square = (num) -> {return num * num;};
		
		Function<Integer, Integer> sum5 = (num) -> {return num + Integer.valueOf(5); };
		
		Function<Integer, Integer> squareAndSum5 = square.andThen(sum5).andThen(sum5); //chaining of functions
		
		System.out.println(squareAndSum5.apply(5));
		
		Function<Integer, Integer> fun = square.compose(sum5); // Composition of functions 
		
		System.out.println(fun.apply(5));
		
		
		
	}
}
