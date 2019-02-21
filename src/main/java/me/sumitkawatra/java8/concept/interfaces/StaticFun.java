package me.sumitkawatra.java8.concept.interfaces;

public class StaticFun {
	
	public static void main(String[] args) {
		I i =new A();
		
		I.fun();
		A.fun();
		
	}
}

interface I {
	public static void fun() {
		System.out.println("I");
	}
}

class A implements I {
	public static void fun() {
		System.out.println("A");
	}
}
