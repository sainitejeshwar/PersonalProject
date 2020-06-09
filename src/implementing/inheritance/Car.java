package implementing.inheritance;

public class Car extends Vehicle{

	@Override
	public void Start() {
		System.out.println("Car Starts");
		
	}

	@Override
	public void Stop() {
		System.out.println("Car Stops");
	}
	
	final void showCarInfo() {
		System.out.println("Car Chassis Number is 1010");
	}

}
