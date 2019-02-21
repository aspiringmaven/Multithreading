package me.sumitkawatra.java8.concept.lambda.scope;

import java.util.function.Supplier;

public class Scope1 {

	private int refVar = 12;

	private static int classRef = 11;

	public static void main(String[] args) {
		
	Scope1 scope1 =	new Scope1().printer.get();
	
   Supplier<Scope1> hello = Scope1::new;
   Supplier<Scope1> printer = hello.get().printer;
   
    System.out.println(printer.get());
	System.out.println(scope1);
		
	}
	
	/**
	 * local and static var Accessibility in lambda.
	 * 
	 *  just derive from inner class logic.
	 */
	public Supplier<Scope1> printer = () -> {

		System.out.println(this.refVar);
		System.out.println(classRef);

		return this;
	};

}