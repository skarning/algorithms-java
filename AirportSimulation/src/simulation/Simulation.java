package simulation;
import java.util.Random;
import java.util.Scanner;
import jsjf.CircularArrayQueue;

public class Simulation {
	private int airplanesLanded = 0;
	private int airplanesTakeoff = 0;
	private int airplanesRejected = 0;
	private int airplanesTreated = 0;
	private double deadTimePercentage = 0;
	private double takeoffTimeSum = 0;
	private double arrivalTimeSum = 0;
	private int currentTime = 0;
	private double averageTimeWaitingForLanding = 0;
	private double averageTimeWaitingForTakeoff = 0;
	private double meanArrivalsPerTimeUnit;
	private double meanDeparturesPerTimeUnit;
	private int timeUnits;
	private CircularArrayQueue<Airplane> arrivalQueue = new CircularArrayQueue<Airplane>();
	private CircularArrayQueue<Airplane> departureQueue = new CircularArrayQueue<Airplane>();
	
	//Starting simulation
	public boolean run(){
		getInitializationDataFromUser();
		//One loop equals one timeUnit of simulation of the airport
		for(int i = 1;i <= timeUnits;i++) {
			generateAirplanesToLists();
			handleAirport();
			addATimeUnitOnAllAirplanes(departureQueue);
			addATimeUnitOnAllAirplanes(arrivalQueue);	
		} 
		printStatistics();
		return true;
	}	
	//Finding Random integer with a parameterized average value
	private int getPoissonRandom(double mean) {
		Random r = new Random();
		double L = Math.exp(-mean);
		int k = 0;
		double p = 1.0;
		do
	        {
		    p = p * r.nextDouble();
		    k++;
		} while (p > L);
		return k - 1;
	}
	//Getting parameters used in simulation from the user
	private void getInitializationDataFromUser() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Velkommen til Halden Airport, tax-free butikken er dessverre stengt.");
		System.out.println("Forventet antall ankomster pr. tidsenhet?");
		meanArrivalsPerTimeUnit = getDoubleFromUser(sc);
		System.out.println("Forventet antall avganger pr. tidsenhet?");
		meanDeparturesPerTimeUnit = getDoubleFromUser(sc);
		System.out.println("Hvor mange tidsenheter skal simuleringen gå?");
		timeUnits = getIntFromUser(sc);
		sc.close();
	}
	//Printing statistics gathered in the current simulation
	private void printStatistics() {
		//Beregner statistikk
		deadTimePercentage = (deadTimePercentage / (timeUnits)) * 100;
		averageTimeWaitingForTakeoff =  takeoffTimeSum / airplanesTakeoff;
		averageTimeWaitingForLanding = arrivalTimeSum / airplanesLanded;
		//Skriver ut statistikk
		System.out.println("Simuleringen ferdig etter          : " + timeUnits +" Tidsenheter");
		System.out.println("Totalt antall fly behandlet        : " + airplanesTreated);
		System.out.println("Antall fly landet                  : " + airplanesLanded);
		System.out.println("Antall fly tatt av                 : " + airplanesTakeoff);
		System.out.println("Antall fly avvist                  : " + airplanesRejected);
		System.out.println("Antall fly klare for landing       : " + arrivalQueue.size());
		System.out.println("Antall fly klare for avgang        : " + departureQueue.size());
		System.out.println("Prosent ledig tid                  : " + deadTimePercentage);
		System.out.println("Gjennomsnittelig ventetid, landing : " + averageTimeWaitingForLanding);
		System.out.println("Gjennomsnittelig ventetid, avgang  : " + averageTimeWaitingForTakeoff);
	}
	//handling landing and takeoff for the current time unit
	private void handleAirport() {
		//Airplanes arriving
		if(arrivalQueue.isEmpty() == false) {
			Airplane airplane = arrivalQueue.dequeue();
			airplanesLanded++;
			airplanesTreated++;
			System.out.println(currentTime+": Fly"+airplane.getAirplaneID()+" klar til landing");
			System.out.println("  Fly"+airplane.getAirplaneID()+ " landet, ventetid " + airplane.getTreatmentTime() + " enheter");
			arrivalTimeSum += airplane.getTreatmentTime();
		}
		//Airplanes taking off
		else if(departureQueue.isEmpty() == false) {
			Airplane airplane = departureQueue.dequeue();
			airplanesTakeoff++;
			airplanesTreated++;
			
			System.out.println(currentTime+": Fly"+airplane.getAirplaneID()+" klar til avgang");
			System.out.println("  Fly" + airplane.getAirplaneID()+" tatt av, ventetid " + airplane.getTreatmentTime() + " enheter");
			takeoffTimeSum += airplane.getTreatmentTime();
		}
		//Airport is empty
		else {
			System.out.println(currentTime+": Flyplassen er tom");
			deadTimePercentage++;
		}
		//Current time increases with one timeunit
		currentTime++;
	}
	//Generating amount of airplanes in landing and takeoff queue for the specific timeunit
	private void generateAirplanesToLists() {
		//Fly ankommer arrival-køen
		int numberOfAirplanesLanding = getPoissonRandom(meanArrivalsPerTimeUnit);
		for(int j = 0;j < numberOfAirplanesLanding;j++) {
			if(arrivalQueue.size()<10) {
				arrivalQueue.enqueue(new Airplane());
			}
			else {
				airplanesRejected++;
			}
		}
	
		//Fly ankommer landingskøen
		int numberOfAirplanesTakingOff = getPoissonRandom(meanDeparturesPerTimeUnit);
		for(int k = 0;k < numberOfAirplanesTakingOff;k++) {
			if(departureQueue.size() < 10) {
				departureQueue.enqueue(new Airplane());
			}
			else {
				airplanesRejected++;
			}
		}
	}
	private double getDoubleFromUser(Scanner sc) {
		double input;
		try{
			input = Double.parseDouble(sc.nextLine());
		}
		catch(NumberFormatException e){
			System.out.println("No input found, setting parameter to 1.0");
			return 1.0;
		}
		return input;
	}
	private int getIntFromUser(Scanner sc) {
		int input;
		try {
			input = Integer.parseInt(sc.nextLine());
		}
		catch(NumberFormatException e) {
			System.out.println("No input found, setting parameter to 24");
			return 24;
		}
		return input;
	}
	//Adding one timeunit to all the airplane objects in the parameterized list
	private void addATimeUnitOnAllAirplanes(CircularArrayQueue<Airplane> buffer) {
			Airplane a = null;
			for(int n = 0; n < buffer.size();n++) {
				a = buffer.dequeue();
				a.addTreatmentDelay();
				buffer.enqueue(a);
			}
		}
}
