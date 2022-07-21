package com.hcl.A3;

public class Vehicle {
	protected int no = 0;
	protected String model;
	protected String manufacturer;
	protected String color;
	
	public static void main(String[] args) {
		Vehicle vehicle = new Vehicle(1234567, "Accord", "Audi", "red");
		Truck truck = new Truck(1524367, "Truck", "G&P", "blue");
		System.out.println(vehicle.toString());
		System.out.println(truck.toString());
		truck.changeAttributes("green", 999);
	}
	
	Vehicle(int no, String model, String manufacturer, String color){
		this.no = no;
		this.model = model;
		this.manufacturer = manufacturer;
		this.color = color;
	}

	@Override
	public String toString() {
		return "Vehicle [no=" + no + ", model=" + model + ", manufacturer=" + manufacturer + ", color=" + color + "]";
	}
}

class Truck extends Vehicle {

	@Override
	public String toString() {
		return "Truck [loadingCapacity=" + loadingCapacity + ", no=" + no + ", model=" + model + ", manufacturer="
				+ manufacturer + ", color=" + color + "]";
	}

	protected int loadingCapacity = 100;
	
	Truck(int no, String model, String manufacturer, String color) {
		super(no, model, manufacturer, color);
	}
	
	void changeAttributes(String color, int loadingCapacity) {
		this.color = color;
		this.loadingCapacity = loadingCapacity;
		System.out.println("Edited the truck.");
		System.out.println(this.toString());
	}
}
