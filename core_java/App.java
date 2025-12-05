package com.project.tax_calculation;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.project.entities.Login;
import com.project.entities.Property;
import com.project.entities.Vehicle;
import com.project.enums.FuelType;
import com.project.exceptions.InValidCredentials;
import com.project.exceptions.InValidInputException;
import com.project.services.PropertyService;
import com.project.services.VechileService;

//*************************TAX CALCULATION APPLICATION********************************* 
public class App {

	public static void main(String[] args) {
		System.out.println("+-----------------------------------------------------+");
		System.out.println("|       WELCOME TO TAX CALCULATION APPLICATION        |");
		System.out.println("+-----------------------------------------------------+");
		System.out.println("PLEASE LOGIN TO CONTINUE  -");
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the username : ");
		String userName = sc.nextLine();
		System.out.println("Enter the password  : ");
		String password = sc.nextLine();
		try {
			Login.validateCredentials(userName, password);
		} catch (InValidCredentials e) {
			System.out.println(e.getMessage());
			return;

		}
		List<Property> properties = new ArrayList<Property>();
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		int option = 4;
		do {
			Menu.displayOperationsMenu();
			try {
				option = sc.nextInt();
				switch (option) {
				case 1:
					PropertyService.propertyDetails(properties);
					break;
				case 2:
					VechileService.vechileDetails(vehicles);
					break;
				case 3:
					getTotalTax(vehicles, properties);
					break;
				case 4:
					break;
				default:
					System.out.println("please select the valid option");
				}

			} catch (InputMismatchException Exception) {
				System.out.println("Invalid operation...please enter the valid format data");
				sc.nextLine();
				continue;
			}
		} while (option != 4);
		System.out.println("closing Application.....closed");
	}

	public static void getTotalTax(List<Vehicle> vehicles, List<Property> properties) {
		double vehicleTax = 0.0;
		double propertyTax = 0.0;

		for (Vehicle vehicle : vehicles) {
			vehicleTax += vehicle.getTax();
		}

		for (Property property : properties) {
			propertyTax += property.getTax();
		}

		double totalTax = vehicleTax + propertyTax;
		System.out.println("+-----------------------------------------------------------------------+");
		System.out.printf("| %-6s | %-20s | %-10s | %-15s |\n", "SR. NO.", "PARTICULAR", "QUANTITY", "TAX");
		System.out.println("+-----------------------------------------------------------------------+");

		System.out.printf("| %-6d | %-20s | %-10d | %-15.2f |\n", 1, "PROPERTIES", properties.size(), propertyTax);

		System.out.printf("| %-6d | %-20s | %-10d | %-15.2f |\n", 2, "VEHICLES", vehicles.size(), vehicleTax);

		System.out.println("+-----------------------------------------------------------------------+");

		System.out.printf("| %-6s | %-20s | %-10d | %-15.2f |\n", "TOTAL", "--------",
				(properties.size() + vehicles.size()), totalTax);

		System.out.println("+-----------------------------------------------------------------------+");

	}
}
