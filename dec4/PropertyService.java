package com.java.services;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.java.entites.Property;
import com.java.exceptions.DataNotFound;
import com.java.exceptions.InValidInputException;
import com.java.tax_calculation.Menu;

public class PropertyService {

	public PropertyService() {
	}

	public static void propertyDetails(List<Property> properties) {
		Scanner sc = new Scanner(System.in);
		int option = 0;
		do {
			try {
				Menu.displayPropertyOptions();
				option = sc.nextInt();
				switch (option) {
				case 1:
					Property property = addProperty();
					if (property != null) {
						properties.add(property);
					}
					break;
				case 2:
					if (properties.size() > 0) {
						displayProperties(properties);
						System.out.println("enter the property id to calculate tax");
						int propertyid = sc.nextInt();
						Property p = calulatePropertytax(propertyid, properties);

						if (p != null)
							System.out.println(" property  tax : " + p);
						else
							throw new DataNotFound("No data found with property ID");
					} else {
						System.out.println("No properties found");
					}
					break;
				case 3:
					displayProperties(properties);
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
				e.getMessage();
				sc.nextLine();
				continue;
			}

		} while (option != 4);
	}

	private static void displayProperties(List<Property> properties) {
		if (properties.size() == 0) {
			System.out.println("No properties found");
			return;
		}
		System.out.println("vechile properties");
		for (Property property : properties) {
			System.out.println(property);
		}
		return;

	}

	private static Property calulatePropertytax(int propertyID, List<Property> properties) {
		Property property = SearchProperty(properties, propertyID);
		if (property != null) {
			property.calculateTax();
			return property;
		}
		return null;
	}

	private static Property SearchProperty(List<Property> properties, int propertyID) {
		for (Property property : properties) {
			if (property.getPropertyID() == propertyID) {
				return property;
			}
		}
		return null;
	}

	private static Property addProperty() {
		System.out.println("Enter the property details : ".toUpperCase());
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter the base value of the property : ");
			double baseValue = sc.nextDouble();
			if (baseValue <= 0)
				throw new InValidInputException("base Value must be greater than 0");
			System.out.print("Enter the Built-Up of the property : ");
			int area = sc.nextInt();
			if (area <= 0)
				throw new InValidInputException("area must be greater than 0");
			System.out.print("Enter the Age of the property : ");
			int age = sc.nextInt();
			if (age <= 0)
				throw new InValidInputException("area must be greater than 0");
			System.out.print("Is Land located in city ? (Y: yes, N: No) : ");
			Scanner sc2 = new Scanner(System.in);
			String city = sc2.nextLine().toLowerCase();
			char inCity = city.charAt(0);

			if (inCity != 'y' && inCity != 'n') {
				throw new InValidInputException("invalid option");
			}
			boolean isInCity = inCity == 'y' ? true : false;
			return new Property(area, baseValue, age, isInCity);
		} catch (InputMismatchException inputMismatchException) {
			System.out.println("Invalid data , please enter the valid format data");
			return null;
		} catch (InValidInputException invalidException) {
			System.out.println("InVlaid : " + invalidException.getMessage());
			return null;
		}
	}

}
