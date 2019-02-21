package me.sumitkawatra.java8.concept.optional;

import java.util.Optional;

public class Optional2 {
	public static void main(String[] args) {
		
		Optional<Owner> owner = Optional.ofNullable(new Owner());
		
//		owner.map(Owner::getCar).map(Car::getInsurance).map(Insurance::getInstitution);
		
	}
}

class Car { 
	private Optional<Insurance> insurance;

	public Optional<Insurance> getInsurance() {
		return insurance;
	}

	public void setInsurance(Optional<Insurance> insurance) {
		this.insurance = insurance;
	}
}

class Owner {
	private Optional<Car> car;

	public Optional<Car> getCar() {
		return car;
	}

	public void setCar(Optional<Car> car) {
		this.car = car;
	}
}

class Insurance {
	
	private String institution = "Punjab Bank";

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}
}