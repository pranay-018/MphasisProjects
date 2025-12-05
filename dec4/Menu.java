package com.project.tax_calculation;

public class Menu {

	public Menu() {

	}

	public static void displayOperationsMenu() {
		System.out.println("select the option : ");
		System.out.println("1.Property tax".toUpperCase());
		System.out.println("2.Vechicle tax".toUpperCase());
		System.out.println("3.total tax".toUpperCase());
		System.out.println("4.exit".toUpperCase());
	}

	public static void displayPropertyOptions() {
		System.out.println("enter the required option");
		System.out.println("1.add property details".toUpperCase());
		System.out.println("2.calculate property tax".toUpperCase());
		System.out.println("3.display all property's tax".toUpperCase());
		System.out.println("4.back to main menu".toUpperCase());

	}

	public static void displayVechileOptions() {
		System.out.println("enter the required option");
		System.out.println("1.add vechile details".toUpperCase());
		System.out.println("2.calculate vechile tax".toUpperCase());
		System.out.println("3.display all vechile's tax".toUpperCase());
		System.out.println("4.back to main menu".toUpperCase());

	}

}
