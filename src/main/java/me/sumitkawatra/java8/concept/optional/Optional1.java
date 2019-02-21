package me.sumitkawatra.java8.concept.optional;

import java.util.Optional;

public class Optional1 {

	public static void main(String[] args) {
		System.out.println(foo().orElse("Choo"));

		System.out.println(foo().isPresent());
	}

	public static Optional<String> foo() {
		return Optional.ofNullable(null);
	}

}
