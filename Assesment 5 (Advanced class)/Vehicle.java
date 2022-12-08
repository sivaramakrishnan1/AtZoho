class VehicleMain
{
	public static void main(String args[])
	{
		Car c = new Car();
		Bike b = new Bike();
		
		c.printDetails();
		b.printDetails();		
	}
}

class Vehicle {
	int noOfSeat, noOfWheel;
}

class Car extends Vehicle {
	Car() {
		noOfSeat = 6;
		noOfWheel = 4;
	}
	
	public void printDetails() {
		System.out.println("Seats : " + noOfSeat + "\nWheels : " + noOfWheel);
	}
}

class Bike extends Vehicle {
	Bike() {
		noOfSeat = 2;
		noOfWheel = 2;
	}
	
	public void printDetails() {
		System.out.println("Seats : " + noOfSeat + "\nWheels : " + noOfWheel);
	}
}