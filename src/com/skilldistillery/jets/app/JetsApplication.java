package com.skilldistillery.jets.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;
import com.skilldistillery.jets.entities.CombatAircraft;
import com.skilldistillery.jets.entities.Jet;
import com.skilldistillery.jets.entities.JetImpl;
import com.skilldistillery.jets.entities.ReconAircraft;

public class JetsApplication {

	public static void main(String[] args) {
		AirField afield = new AirField();
		List<Jet> jets = afield.readFile();

		launchMenu(jets, afield);
	}

	private static void launchMenu(List<Jet> jets, AirField airfield) {
		int choice = promptMenu();

		while (choice != 9) {
			processMenu(choice, jets, airfield);

			System.out.println();
			choice = promptMenu();
		}

		System.out.println("The planes are out of gas, time to pack it up.");

	}

	private static int promptMenu() {
		Scanner sc = new Scanner(System.in);

		System.out.println("There is a menu with these options:");
		System.out.println("1. List fleet");
		System.out.println("2. Fly all jets");
		System.out.println("3. View fastest jets");
		System.out.println("4. View jet with longest range");
		System.out.println("5. Launch reconnaissance aircraft. Activate radars!");
		System.out.println("6. Launch combat Aircraft. It's time to fight!");
		System.out.println("7. Add a jet to Fleet");
		System.out.println("8. Remove jet from Fleet");
		System.out.println("9. Quit");

		return sc.nextInt();
	}

	private static void processMenu(int menuChoice, List<Jet> jets, AirField airfield) {

		switch (menuChoice) {
		case 1:
			airfield.listFleet();
			break;
		case 2:
			airfield.flyJets();
			break;
		case 3:
			airfield.viewFastestJet();
			break;
		case 4:
			airfield.viewLongestRangeJet();
			break;
		case 5:
			eyesInTheSkies(jets);
			break;
		case 6:
			fight(jets);
			break;
		case 7:
			Jet newJet = addCustomJet();
			jets.add(newJet);
			break;
		case 8:
			removeJet(jets);
			break;
		default:
			break;
		}
	}

	private static void eyesInTheSkies(List<Jet> jets) {
		for (Jet jet : jets) {
			if (jet instanceof ReconAircraft) {
				((ReconAircraft) jet).readyToLook();
			}
		}
	}

	private static void fight(List<Jet> jets) {
		for (Jet jet : jets) {
			if (jet instanceof CombatAircraft) {
				((CombatAircraft) jet).fight();
			}
		}
	}

	private static Jet addCustomJet() {
		Scanner sc = new Scanner(System.in);

		System.out.println(
				"Choose what plane you would like to input:\n 1. Recon Aircraft\n 2. Combat Aircraft\n 3. Other Plane");
		int userInput = sc.nextInt();
		switch (userInput) {
		case 1:
			Jet newJet = promptForReconAircraft();
			System.out.println();
			return newJet;
		case 2:
			newJet = promptForFighter();
			System.out.println();
			return newJet;
		case 3:
			newJet = promptForOtherAircraft();
			System.out.println();
			return newJet;
		}

		return null;
	}

	private static void removeJet(List<Jet> jets) {
		System.out.println("Which jet would you like to remove?");
		for (int i = 0; i < jets.size(); i++) {
			System.out.println(i + ": " + jets.get(i));
		}

		Scanner sc = new Scanner(System.in);
		int indexToRemove = sc.nextInt();

		Jet removedJet = jets.remove(indexToRemove);
		System.out.println("Removed: " + removedJet);
	}

	private static Jet promptForReconAircraft() {
		Jet jet;
		String model;
		double speed;
		int range;
		long price;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter a model: ");
		model = sc.nextLine();
		System.out.println("Enter a speed: ");
		speed = sc.nextDouble();
		System.out.println("Enter a range: ");
		range = sc.nextInt();
		System.out.println("Enter a price: ");
		price = sc.nextLong();
		jet = new ReconAircraft(model, speed, range, price);

		return jet;
	}

	private static Jet promptForFighter() {
		Jet jet;
		String model;
		double speed;
		int range;
		long price;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter a model: ");
		model = sc.nextLine();
		System.out.println("Enter a speed: ");
		speed = sc.nextDouble();
		System.out.println("Enter a range: ");
		range = sc.nextInt();
		System.out.println("Enter a price: ");
		price = sc.nextLong();
		jet = new CombatAircraft(model, speed, range, price);

		return jet;
	}

	private static Jet promptForOtherAircraft() {
		Jet jet;
		String model;
		double speed;
		int range;
		long price;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter a model: ");
		model = sc.nextLine();
		System.out.println("Enter a speed: ");
		speed = sc.nextDouble();
		System.out.println("Enter a range: ");
		range = sc.nextInt();
		System.out.println("Enter a price: ");
		price = sc.nextLong();
		jet = new JetImpl(model, speed, range, price);

		return jet;
	}

}
