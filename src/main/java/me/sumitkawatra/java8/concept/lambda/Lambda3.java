package me.sumitkawatra.java8.concept.lambda;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class Lambda3 {
	
	public static void main(String[] args) {
		
		List<Apple> inventory = new ArrayList<>();
		
		inventory.add(new Apple("yelow", 30));
		inventory.add(new Apple("green", 20));
		inventory.add(new Apple("red", 30));
		
		
		/**
		 * see how to pass method as an reference in Java 8. 
		 */
		System.out.println(filterApple(inventory, Apple::isGreen));
		
		System.out.println(filterApple(inventory, Apple::isHeavy));
	
	}
	
	
	public static Collection<Apple> filterApple(List<Apple> inventory, Predicate<Apple> predicate) {
		
		Collection<Apple> appleList = new ArrayList<>();
		
		for(Apple apple: inventory) {
			
			if(predicate.test(apple))
			appleList.add(apple);
		}
		
		return appleList;
	}
	
}


class Apple {

	public String color;
	public int weight;

	public Apple(String color, int weight) {
		super();
		this.color = color;
		this.weight = weight;
	}
	
	public static boolean isGreen(Apple apple) {
		return "green".equals(apple.color);
	}
	
	public static boolean isHeavy(Apple apple) {
		return apple.weight > 25;
	}

	@Override
	public String toString() {
		return "Mango [color=" + color + ", weight=" + weight + "]";
	}

}
