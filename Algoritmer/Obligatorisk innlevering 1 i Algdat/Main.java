package simulation;

public class Main {
	public static void main(String[] args) {
		Simulation sim = new Simulation();
		if(sim.run() == true)
			System.out.println("Simuleringen er suksessfull");
		else
			System.out.println("Simuleringen var ikke suksefull");
	}
}