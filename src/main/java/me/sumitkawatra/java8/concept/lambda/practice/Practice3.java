package me.sumitkawatra.java8.concept.lambda.practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Chaining Predicate | Composing predicate
 * @author sumkawat
 *
 */
public class Practice3 {
	
	public static void main(String[] args) {
			
		List<Car> cars = Arrays.asList(
				new Car(200, "red"),
				new Car(100, "red"),
				new Car(300, "green"),
				new Car(200, "yellow"));
		
		System.out.println("Red cars");
		
		cars.stream().filter(Car::isRedCar).collect(Collectors.toList()).forEach((car) -> {System.out.println(car);});
		
		System.out.println("Racing Car car");
		
		cars.stream().filter(Car::isRacingcar).collect(Collectors.toList()).forEach((car) -> {System.out.println(car);});
		
		System.out.println("Racing car but not red");
		
		Predicate<Car> redCar = Car::isRedCar;
		Predicate<Car> speedCarButNotRed = redCar.negate().and(Car::isRacingcar);
		
		cars.stream().filter(speedCarButNotRed).collect(Collectors.toList()).forEach((car) -> {System.out.println(car);});
		
	}
	
}


class Car {
	
	private int speed;
	
	private String color;

	public Car(int speed, String color) {
		super();
		this.speed = speed;
		this.color = color;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public boolean isRedCar() {
		return "red".equals(this.getColor());
	}
	
	public boolean isRacingcar() {
		return speed >= 200;
	}

	@Override
	public String toString() {
		return "Car [speed=" + speed + ", color=" + color + "]";
	}
		
}