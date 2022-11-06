package com.skilldistillery.jets.entities;

public class CombatAircraft extends Jet implements CombatReady {

	public CombatAircraft(String model, double speed, int range, long price) {
		super(model, speed, range, price);

	}
	
	@Override
	public void fight() {
		System.out.println(getModel() + " has target acquired. Engaging missles....hostile 17 miles! break right!");
		
	}

	@Override
	public void fly() {
		System.out.println(toString());
		System.out.println(getModel() + " can travel at top speed for " + (getRange()/getSpeed()) + " hours.");
		
	}

}
