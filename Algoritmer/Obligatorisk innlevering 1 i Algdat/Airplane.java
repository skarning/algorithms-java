package simulation;

public class Airplane {
	private static int count = 0;
	private int AirplaneID;
	private int treatmentTime = 0;
	
	public Airplane() {
		count++;
		AirplaneID = count;
	}
	
	public int getAirplaneID() {
		return AirplaneID;
	}
	
	public void addTreatmentDelay() {
		treatmentTime++;
	}
	
	public int getTreatmentTime() {
		return treatmentTime;
	}
}
