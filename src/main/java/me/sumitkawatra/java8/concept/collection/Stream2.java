package me.sumitkawatra.java8.concept.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Stream2 {
	
	public static void main(String[] args) {

		List<Fruit> inventory = new ArrayList<>();
		
		inventory.add(new Fruit("yelow", 30));
		inventory.add(new Fruit("green", 20));
		inventory.add(new Fruit("red", 30));
		inventory.add(new Fruit("orange", 35));
		
		
		inventory.forEach(System.out::println);
		
		/**
		 * map example to perform any operation on F<D,R> collection.
		 */
		inventory.stream().map(Fruit::getColor).forEach(System.out::println);
		
		
		/**
		 * filter heavy fruits and limit to 2.
		 */
		System.out.println();
		inventory.stream().filter(Fruit::isHeavy).limit(2).forEach(System.out::println);
		System.out.println();
		
		
		/**
		 * filter heavy fruits and Skip first two.
		 */
		System.out.println();
		inventory.stream().filter(Fruit::isHeavy).skip(2).forEach(System.out::println);
		System.out.println();
		
		
		
		/**
		 * To find first heavy fruit.
		 * 
		 * if exist and then do call back and print
		 */
		Optional<Fruit> firstHeavyFruit = inventory.stream().filter(Fruit::isHeavy).findFirst();
		
		firstHeavyFruit.ifPresent(System.out::println);
		
		/**
		 * is exist?
		 */
		Boolean isGreenFruitExist = inventory.stream().anyMatch(Fruit::isGreen);
		System.out.println(isGreenFruitExist);
		
		
		
	}
	
}


class Fruit {

	private String color;
	public int weight;

	public Fruit(String color, int weight) {
		super();
		this.setColor(color);
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
		return "Mango [color=" + getColor() + ", weight=" + weight + "]";
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
