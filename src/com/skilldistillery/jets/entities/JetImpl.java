package com.skilldistillery.jets.entities;

public class JetImpl extends Jet {

	public JetImpl(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		
	}

	@Override
	public void fly() {
		System.out.println(toString());
		System.out.println(getModel() + " can travel at top speed for " + (getRange()/getSpeed()) + " hours.");
		
	}
	

}
