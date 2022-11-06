package com.skilldistillery.jets.entities;

public class ReconAircraft extends Jet implements EyesInTheSky {

	public ReconAircraft(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void readyToLook() {
		System.out.println(getModel() + " is eyes on target. Raptor22 prepare to intercept in 80 miles." );
	
	}

	@Override
	public void fly() {
		System.out.println(toString());
		System.out.println(getModel() + " can travel at top speed for " + (getRange()/getSpeed()) + " hours.");
	
		
	}

}
