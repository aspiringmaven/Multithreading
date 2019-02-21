package me.sumitkawatra.java8.concept.async;

public final class Employee {
	
	private final String helo;
	
	private final Address address;
	
	public Employee(String helo, Address address) {
		super();
		this.helo = helo;
		this.address = address;
	}

	public String getHelo() {
		return helo;
	}

	public Address getAddress() {
		return address;
	}
	
	
}
