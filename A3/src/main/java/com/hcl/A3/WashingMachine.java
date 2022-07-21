package com.hcl.A3;

public class WashingMachine {
	private int noOfClothes = 0;
	private boolean poweredOn = false;
	private boolean hasDetergent = false;
	
	public static void main(String[] args) {
		WashingMachine machine = new WashingMachine();
		machine.switchOn();
		machine.switchOff();
		machine.acceptClothes(10);
		machine.switchOn();
		machine.acceptDetergent();
		machine.acceptClothes(5);
		machine.switchOn();
		machine.switchOff();
	}
	
	void switchOn() {
		if (hasDetergent && noOfClothes > 0) {
			poweredOn = true;
			System.out.println("Powered on washer.");
		}
		else if (!hasDetergent && noOfClothes <= 0) {
			System.out.println("Did not switch on. Must add detergent and clothes first.");
		}
		else if (!hasDetergent) {
			System.out.println("Did not switch on. Must add detergent first.");
		}
		else if (noOfClothes <= 0) {
			System.out.println("Did not switch on. Must add clothes first.");
		}
		
	}
	
	void switchOff() {
		if (poweredOn == false) {
			System.out.println("The machine was already off.");
		}
		else {
			poweredOn = false;
			System.out.println("The machine is off.");
		}
	}
	
	int acceptClothes(int noOfClothes) {
		this.noOfClothes += noOfClothes;
		System.out.println("Added clothes... There are currently " + this.noOfClothes + " in the washer.");
		
		return this.noOfClothes;
	}
	
	void acceptDetergent() {
		if (hasDetergent == true) {
			System.out.println("Did not add detergent. There is already detergent.");
		}
		else {
			hasDetergent = true;
			System.out.println("Added detergent. Ready to wash.");
		}
	}
}
