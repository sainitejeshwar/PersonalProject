package implementing.inheritance;

public class SUV extends Car{

	@Override
	public void Start() {
		System.out.println("SUV Starts");
	}

	@Override
	public void Stop() {
		System.out.println("SUV Stops");
	}
	
	
	//CANNOT OVERRIDE showCarInfo() method here
}
