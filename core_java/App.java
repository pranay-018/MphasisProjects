package com.java.tax_calculation;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

//*************************TAX CALCULATION APPLICATION********************************* 
public class App {

	public static void main(String[] args) {
		System.out.println("+-----------------------------------------------------+");
		System.out.println("|       WELCOME TO TAX CALCULATION APPLICATION        |");
		System.out.println("+-----------------------------------------------------+");
//		System.out.println("PLEASE LOGIN TO CONTINUE  -");
		Scanner sc = new Scanner(System.in);
//		System.out.println("enter the username : ");
//		String userName = sc.nextLine();
//		System.out.println("Enter the password  : ");
//		String password = sc.nextLine();
//		if (userName.compareTo("pranay") != 0 || password.compareTo("padma@18") != 0) {
//			System.out.println("Invalid Credentials.... try again");
//			return;
//		}
		List<Property> properties = new ArrayList<Property>();
		int option = 4;
		do {
			System.out.println("select the operations : ");
			displayOperationsMenu();
			try {
				option = sc.nextInt();
				switch (option) {
				case 1:
					propertyDetails(properties);
					break;
				case 2:
					vechileDetails();
					break;
				case 3:
					getTotalTax();
					break;
				case 4:
					break;
				default:
					System.out.println("please select the valid option");
				}

			} catch (InputMismatchException Exception) {
				System.out.println("Invalid operation...please select appropriate operation");
				sc.nextLine();
				continue;
			}
		} while (option != 4);
		System.out.println("closing Application.....closed");
	}

	public static void displayOperationsMenu() {
		System.out.println(" 			1.Property tax".toUpperCase());
		System.out.println(" 			2.Vechicle tax".toUpperCase());
		System.out.println("			3.total tax".toUpperCase());
		System.out.println(" 			4.exit".toUpperCase());
	}

	public static void displayPropertyOptions() {
		System.out.println("********enter the option******");
		System.out.println("		1.add property details".toUpperCase());
		System.out.println("		2.calculate property tax".toUpperCase());
		System.out.println("		3.display all property's tax".toUpperCase());
		System.out.println("		4.back to main menu".toUpperCase());

	}

	public static void displayVechileOptions() {
		System.out.println("********enter the option******");
		System.out.println("		1.add vechile details".toUpperCase());
		System.out.println("		2.calculate vechile tax".toUpperCase());
		System.out.println("		3.display all vechile's tax".toUpperCase());
		System.out.println("		4.back to main menu".toUpperCase());

	}

	public static void propertyDetails(List<Property> properties) {
		Scanner sc = new Scanner(System.in);
		int option = 0;
		do {
			try {
				displayPropertyOptions();
				option = sc.nextInt();
				switch (option) {
				case 1:
					Property property = addProperty();
					if (property != null) {
						properties.add(property);
					}
					break;
				case 2:
					for (Property p : properties) {
						System.out.println(p);
					}
					System.out.println("enter the property id to calculate tax");
					int propertyid = sc.nextInt();
					properties.get(propertyid);
					break;
				case 3:
					System.out.println("displaying properties");
					for (Property p : properties) {
						System.out.println(p);
					}
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
			}
		} while (option != 4);
	}

	private static Property addProperty() {
		System.out.println(" Enter the property details : ".toUpperCase());
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter the base value of the property : ");
			double baseValue = sc.nextDouble();
			if (baseValue <= 0)
				throw new InValidException("base Value must be greater than 0");
			System.out.print("Enter the Built-Up of the property : ");
			int area = sc.nextInt();
			if (area <= 0)
				throw new InValidException("area must be greater than 0");
			System.out.print("Enter the Age of the property : ");
			int age = sc.nextInt();
			if (area <= 0)
				throw new InValidException("area must be greater than 0");
			System.out.print("Is Land loacted in city ? (Y: yes, N: No");
			String city = sc.nextLine().toLowerCase();
			char inCity = city.charAt(0);
			if (inCity != 'y' || inCity != 'n') {
				throw new InValidException("invalid option");
			}
			boolean isInCity = inCity == 'y' ? true : false;
			return new Property(area, baseValue, age, isInCity);
		} catch (InputMismatchException inputMismatchException) {
			System.out.println("Invalid data , please enter the valid format data");
			return null;
		} catch (InValidException invalidException) {
			System.out.println(invalidException.getMessage());
			return null;
		}
	}

	public static void vechileDetails() {
		Scanner sc = new Scanner(System.in);
		int option = 0;
		do {
			try {
				displayVechileOptions();
				option = sc.nextInt();
				switch (option) {
				case 1:
					System.out.println("vechile is adding");
					break;
				case 2:
					System.out.println("calculating vechile tax");
					break;
				case 3:
					System.out.println("vechile properties");
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
			}
		} while (option != 4);
	}

	public static void getTotalTax() {
		System.out.println("displying all the tax values");
	}
}
