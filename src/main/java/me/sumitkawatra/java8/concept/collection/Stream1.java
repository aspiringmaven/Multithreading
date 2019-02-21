package me.sumitkawatra.java8.concept.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Stream1 {
	
	public static void main(String[] args) {

		List<Fruit> inventory = new ArrayList<>();
		
		inventory.add(new Fruit("yelow", 30));
		inventory.add(new Fruit("green", 20));
		inventory.add(new Fruit("red", 30));
		
		/**
		 * stream on collection and filter and  collect as new List.
		 */
		System.out.println(inventory.stream().filter(Apple::isHeavy).collect(Collectors.toList()));
		
		
		/**
		 * To sort collection with sort method
		 */
		inventory.sort((Fruit a1, Fruit a2)-> {return a1.weight - a2.weight; });
		
		System.out.println(inventory);
		
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
	
	public static boolean isGreen(Fruit apple) {
		return "green".equals(apple.getColor());
	}
	
	public static boolean isHeavy(Fruit apple) {
		return apple.weight > 25;
	}

	@Override
	public String toString() {
		return "Mango [color=" + color + ", weight=" + weight + "]";
	}

}
