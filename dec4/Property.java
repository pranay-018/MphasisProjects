package com.java.entites;

import com.java.interfaces.TaxPayement;

public class Property implements TaxPayement {
	static int id = 0;
	private int propertyID;
	private int builtUpArea;
	private double landBaseValue;
	private int landAge;
	private boolean isInCity;
	private double tax;

	public Property() {
	}

	public Property(int builtUpArea, double landBaseValue, int landAge, boolean isInCity) {
		super();
		this.propertyID = id + 1;
		this.builtUpArea = builtUpArea;
		this.landBaseValue = landBaseValue;
		this.landAge = landAge;
		this.isInCity = isInCity;
		this.id++;

	}

	public int getPropertyID() {
		return propertyID;
	}

	public int getBuiltUpArea() {
		return builtUpArea;
	}

	public void setBuiltUpArea(int builtUpArea) {
		this.builtUpArea = builtUpArea;
	}

	public double getLandBaseValue() {
		return landBaseValue;
	}

	public void setLandBaseValue(double landBaseValue) {
		this.landBaseValue = landBaseValue;
	}

	public int getLandAge() {
		return landAge;
	}

	public void setLandAge(int landAge) {
		this.landAge = landAge;
	}

	public boolean isInCity() {
		return isInCity;
	}

	public void setInCity(boolean isInCity) {
		this.isInCity = isInCity;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public void setPropertyID(int propertyID) {
		this.propertyID = propertyID;
	}

	@Override
	public String toString() {
		return "Property [propertyID=" + propertyID + ", builtUpArea=" + builtUpArea + ", landBaseValue="
				+ landBaseValue + ", landAge=" + landAge + ", isInCity=" + isInCity + ", tax=" + tax + "]";
	}

	@Override
	public void calculateTax() {
		double tax = 0.0;
		if (this.isInCity) {
			tax = (double) (this.builtUpArea * this.landAge * this.landBaseValue) + (this.builtUpArea) / (double) 2;
		} else {
			tax = (double) (this.builtUpArea * this.landAge * this.landBaseValue);
		}
		this.tax = tax;
	}

}
