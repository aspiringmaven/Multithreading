package me.sumitkawatra.java8.concept.collection;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stream6 {

	public static void main(String[] args) {

		List<Integer> listA = Arrays.asList(1, 2, 3, 4, 5);

		List<Integer> listB = Arrays.asList(6, 7, 8, 9);

		/**
		 * to print listA * listB
		 */
		List<Integer[]> pairs = listA.stream()
				.flatMap(a -> listB.stream().map(b -> new Integer[] { a, b }))
				.collect(Collectors.toList());

		for (Integer[] pair : pairs) {
			for (Integer num : pair) {
				System.out.print(num+"-");
			}
			System.out.println();
		}

	}

}
