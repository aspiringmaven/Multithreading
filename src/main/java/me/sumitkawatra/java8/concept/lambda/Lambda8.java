package me.sumitkawatra.java8.concept.lambda;

import java.util.Comparator;

public class Lambda8 {
	
	public static void main(String[] args) {
		/**
		 * With Type reference
		 */
		Comparator<Metal> order1 = (Metal m1,Metal m2) -> {return m1.weight - m2.weight; };
		
		/**
		 * Without Type reference.
		 */
		Comparator<Metal> order2 = (m1,m2) -> {return m1.weight - m2.weight; };
	}

}


class Metal {
	
	public int weight;
}