package me.sumitkawatra.java8.concept.lambda;

import java.util.function.Predicate;

public class Lambda2 {
	public static void main(String[] args) {
		
		/**
		 * Functional Interface that have boolean output always.
		 */
		Predicate<Mango> isGreen = (Mango f) -> { return "green".equals(f.color);};
		
		System.out.println(isGreen.test(new Mango("green", 12)));
		
	}
}

class GreenMango implements Predicate<Mango> {

	@Override
	public boolean test(Mango t) {
		return false;
	}
	
}

interface Fruit {

}

class Mango implements Fruit {

	public String color;
	public int weight;

	public Mango(String color, int weight) {
		super();
		this.color = color;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Mango [color=" + color + ", weight=" + weight + "]";
	}

}
