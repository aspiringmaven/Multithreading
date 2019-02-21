package me.sumitkawatra.java8.concept.collection;

import java.util.Arrays;
import java.util.List;

public class Stream7 {
	
	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1,2,3,9,4,5,6,7,8);
		
		Integer count =list.stream().reduce(0, (a,b) ->  a+1 );
		 long size = list.stream().count();
		System.out.println(count);
		System.out.println(count);
	}

}
