package com.java.tax_calculation;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.java.entites.Login;
import com.java.entites.Property;
import com.java.entites.Vechile;
import com.java.enums.FuelType;
import com.java.exceptions.InValidCredentials;
import com.java.exceptions.InValidInputException;
import com.java.services.PropertyService;
import com.java.services.VechileService;

//*************************TAX CALCULATION APPLICATION********************************* 
public class App {

	public static void main(String[] args) {
		System.out.println("+-----------------------------------------------------+");
		System.out.println("|       WELCOME TO TAX CALCULATION APPLICATION        |");
		System.out.println("+-----------------------------------------------------+");
		System.out.println("PLEASE LOGIN TO CONTINUE  -");
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the username : ");
//		String userName = sc.nextLine();
		String userName = "pranay";
		System.out.println("Enter the password  : ");
//		String password = sc.nextLine();
		String password = "pranay@18";
		try {
			Login.validateCredentials(userName, password);
		} catch (InValidCredentials e) {
			System.out.println(e.getMessage());
			return;

		}
		List<Property> properties = new ArrayList<Property>();
		List<Vechile> vechiles = new ArrayList<Vechile>();
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
					VechileService.vechileDetails(vechiles);
					break;
				case 3:
					getTotalTax(vechiles, properties);
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

	public static void getTotalTax(List<Vechile> vechiles, List<Property> properties) {
		double vechiletax = 0.0;
		double propertytax = 0.0;
		for (Vechile vechile : vechiles) {
			vechiletax += vechile.getTax();
		}
		for (Property property : properties) {
			propertytax += property.getTax();
		}

		System.out.println("vechiles total tax : " + vechiletax);
		System.out.println("properties total tax : " + propertytax);
	}
}
