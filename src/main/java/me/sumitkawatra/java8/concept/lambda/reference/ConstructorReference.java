package me.sumitkawatra.java8.concept.lambda.reference;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * make a note method reference always hold by Functional interface type.
 * 
 * on the left.
 * 
 * @author sumkawat
 *
 */
public class ConstructorReference {
	public static void main(String[] args) {

		/**
		 * Constructor reference. make a note left side always functional reference.
		 */
		Supplier<Zoo> zoo = Zoo::new;
		zoo.get();// created here
		
		Function<Integer, Zoo> anotherZoo = Zoo::new;
		
		anotherZoo.apply(12); //created another Zoo

	}
}

class Zoo {

	Integer animalCount;

	public Zoo() {
		super();
		animalCount = Integer.valueOf(0);
		System.out.println("Zoo Created !!!");
	}
	
	public Zoo(Integer animalCount) {
		super();
		this.animalCount = animalCount;
		System.out.println("Zoo Created with"+this.animalCount+" Animal!!!");
	}



	@Override
	public String toString() {
		return "Zoo [animalCount=" + animalCount + "]";
	}

}
