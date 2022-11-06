package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AirField {
	private ArrayList<Jet> fleet = new ArrayList<Jet>();

	public List<Jet> readFile() {
		try (BufferedReader bufIn = new BufferedReader(new FileReader("jets.txt"))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				String[] fields = line.split(",");
				String name = fields[1];
				double speed = Double.parseDouble(fields[2]);
				int range = Integer.parseInt(fields[3]);
				long price = Long.parseLong(fields[4]);
				if (fields[0].equalsIgnoreCase("Recon Aircraft")) {
					ReconAircraft recon = new ReconAircraft(name, speed, range, price);
					fleet.add(recon);
				} else if (fields[0].equalsIgnoreCase("Combat Aircraft")) {
					CombatAircraft combat = new CombatAircraft(name, speed, range, price);
					fleet.add(combat);
				}

			}
		} catch (IOException e) {
			System.err.println(e);
		}
		
		return fleet;
	}
	
	public void listFleet() {
		System.out.println("The Fleet is: ");
		for (Jet jet : fleet) {
			System.out.println(jet);
		}
	}
	public void flyJets() {
		for (Jet jet : fleet) {
			jet.fly();
		}
	}
	public void viewFastestJet() {
		Jet fastestJet = null;
		
		for (Jet jet : fleet) {
			if (fastestJet == null || jet.getSpeed() > fastestJet.getSpeed()) {
				fastestJet = jet;
			}
		}
		
		System.out.println("Fastest jet: " + fastestJet);
	}
	public void viewLongestRangeJet() {
		Jet longestRangeJet = null;
		
		for (Jet jet : fleet) {
			if (longestRangeJet == null || jet.getRange() > longestRangeJet.getRange()) {
				longestRangeJet = jet;
			}
		}
		System.out.println("The longest range jet is " + longestRangeJet);
	}
	
	
	
	
	
	
	
	
	
}