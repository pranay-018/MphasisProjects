package com.java.tax_calculation;

public class Vechile implements TaxPayement {
	private int registrationNumber;
	private String brandName;
	private double cost;
	private int maxVelocity;
	private int capacity;
	private FuelType fuelType;
	private double tax;

	public Vechile() {

	}

	public Vechile(int registrationNumber, String brandName, double cost, int maxVelocity, int capacity,
			FuelType fuelType) {
		super();
		this.registrationNumber = registrationNumber;
		this.brandName = brandName;
		this.cost = cost;
		this.maxVelocity = maxVelocity;
		this.capacity = capacity;
		this.fuelType = fuelType;
		this.tax = this.calculateTax();
	}

	public int getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(int registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getMaxVelocity() {
		return maxVelocity;
	}

	public void setMaxVelocity(int maxVelocity) {
		this.maxVelocity = maxVelocity;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public FuelType getFuelType() {
		return fuelType;
	}

	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}

	@Override
	public String toString() {
		return "Vechile [registrationNumber=" + registrationNumber + ", brandName=" + brandName + ", cost=" + cost
				+ ", maxVelocity=" + maxVelocity + ", capacity=" + capacity + ", fuelType=" + fuelType + ", tax=" + tax
				+ "]";
	}

	@Override
	public double calculateTax() {
		double tax = 0.0;
		if (this.fuelType == FuelType.PETROL) {
			tax = this.maxVelocity + this.capacity + (double) (0.10 * this.cost);
		} else if (this.fuelType == FuelType.DIESEL) {
			tax = this.maxVelocity + this.capacity + (double) (0.11 * this.cost);
		} else {
			if (this.fuelType == FuelType.PETROL) {
				tax = this.maxVelocity + this.capacity + (double) (0.12 * this.cost);
			}
		}
		return tax;
	}

}
