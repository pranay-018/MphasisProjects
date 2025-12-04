package com.java.services;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.java.entites.Vechile;
import com.java.enums.FuelType;
import com.java.exceptions.DataNotFound;
import com.java.exceptions.InValidInputException;
import com.java.tax_calculation.Menu;

public class VechileService {

	public VechileService() {

	}

	public static void vechileDetails(List<Vechile> vechiles) {
		Scanner sc = new Scanner(System.in);
		int option = 0;
		do {
			try {
				Menu.displayVechileOptions();
				option = sc.nextInt();
				switch (option) {
				case 1:
					Vechile vechile = addVechile();
					if (vechile != null) {
						vechiles.add(vechile);
					}
					break;
				case 2:
					if (vechiles.size() > 0) {
						displayVechileProperties(vechiles);
						System.out.println("enter the Vechile Registration Number to calculate Tax ");
						int vechileID = sc.nextInt();
						Vechile v = calulateVechiletax(vechileID, vechiles);
						if (v != null)
							System.out.println(" vechile tax : " + v);
						else
							throw new DataNotFound("No data found with Vechile Registration");
					} else {
						System.out.println("No vechiles found");
					}
					break;
				case 3:
					displayVechileProperties(vechiles);
					break;
				case 4:
					System.out.println("back to main menu");
					return;
				default:
					System.out.println("please select correct option");
					break;
				}
			} catch (InputMismatchException inputMismatchException) {
				System.out.println("invalid option...");
				sc.nextLine();
				continue;
			} catch (DataNotFound e) {
				System.out.println(e.getMessage());
				sc.nextLine();
				continue;

			}
		} while (option != 4);
	}

	private static Vechile calulateVechiletax(int vechileID, List<Vechile> vechiles) {
		Vechile vechile = SearchVechile(vechiles, vechileID);
		if (vechile != null) {
			vechile.calculateTax();
			return vechile;
		}
		return null;
	}

	private static Vechile SearchVechile(List<Vechile> vechiles, int vechileID) {
		for (Vechile vechile : vechiles) {
			if (vechile.getRegistrationNumber() == vechileID) {
				return vechile;
			}
		}
		return null;
	}

	private static void displayVechileProperties(List<Vechile> vechiles) {
		if (vechiles.size() == 0) {
			System.out.println("No vechiles found");
		}
		System.out.println("vechile properties");
		for (Vechile v : vechiles) {
			System.out.println(v);
		}
		return;

	}

	private static Vechile addVechile() {
		System.out.println("Enter the Vechile details : ".toUpperCase());
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter the 4 digit Registration Number  : ");
			String regNo = sc.nextLine().trim();

			if (!regNo.matches("\\d{4}")) {
				throw new InValidInputException("Registration number must be 4 digits.");
			}

			if (regNo.equals("0000")) {
				throw new InValidInputException("Registration number cannot be 0000.");
			}
			int registrationNumber = Integer.parseInt(regNo);
			if(registrationNumber<0) {
				throw new InValidInputException("Registration number cannot be negative.");
			}
			System.out.print("Enter the Brand of Vechile: ");
			String brand = sc.nextLine();
			if (brand == null)
				throw new InValidInputException("please enter the valid brand Name");
			System.out.print("Enter the cost of vechile : ");
			int cost = sc.nextInt();
			if (cost <= 0 || cost < 50000 || cost > 10000000)
				throw new InValidInputException("cost must be between 5000 and 1000000");
			System.out.print("Enter the maximum velocity of vechile : ");
			int maxVelocity = sc.nextInt();
			if (maxVelocity <= 0 || maxVelocity < 120 || maxVelocity > 300)
				throw new InValidInputException("speed must be between 120 and 300");
			System.out.print("Enter the capacity  vechile : ");
			int capacity = sc.nextInt();
			if (capacity < 2 || capacity > 50)
				throw new InValidInputException("Capacity must be between 2 and 50");
			System.out.println("Choose the type of fuel : ");
			System.out.println("1.PETROL DRIVEN");
			System.out.println("2.DEISEL DRIVEN");
			System.out.println("3.CNG/LPG Driven");
			int option = 0;
			option = sc.nextInt();
			FuelType fuelType;
			switch (option) {
			case 1:
				fuelType = FuelType.PETROL;
				break;
			case 2:
				fuelType = FuelType.PETROL;
				break;
			case 3:
				fuelType = FuelType.PETROL;
				break;

			default:
				throw new InValidInputException("please select the appropriate option : ");

			}
			return new Vechile(registrationNumber, brand, cost, maxVelocity, capacity, fuelType);
		} catch (InputMismatchException inputMismatchException) {
			System.out.println("Invalid data , please enter the valid format data");
			return null;
		} catch (InValidInputException invalidException) {
			System.out.println(invalidException.getMessage());
			return null;
		}
	}

}
