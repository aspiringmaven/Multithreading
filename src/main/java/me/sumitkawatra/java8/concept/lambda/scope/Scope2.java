package me.sumitkawatra.java8.concept.lambda.scope;

import java.util.function.Supplier;

public class Scope2 {
	
	private static int staticVar = 11;
	
	public static void main(String[] args) {
		
		final int localVar = 12;
		
		/**
		 * Only final local variable are allowed as it stores in stack
		 * 
		 * 
		 * just think local inner class accesibility.
		 */
		Supplier<Object> fun = () -> {
			
			System.out.println(localVar);
			System.out.println(staticVar);
			
			return null;
		};
		
		fun.get();
	}
	
}
