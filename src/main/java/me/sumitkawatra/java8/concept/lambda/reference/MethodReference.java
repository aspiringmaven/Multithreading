package me.sumitkawatra.java8.concept.lambda.reference;

import java.util.function.Supplier;

public class MethodReference {

	public static void main(String[] args) {
		/**
		 * Static Method reference.
		 */
		Supplier<Integer> methodReference1 = MyClass::staticMethod;
		
		/**
		 * Non static method reference
		 */
		Supplier<String> methodReference = new MyClass()::myMethod;
		
		System.out.println(methodReference.get());
		
		System.out.println(methodReference1.get());
		
		
	}

}

class MyClass {

	public String myMethod() {
		return "myMethod";
	}
	
	public static Integer staticMethod() {
		return Integer.valueOf(12);
	}
}
