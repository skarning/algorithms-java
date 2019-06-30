import java.util.Scanner;

public class Main {
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.println("Hvilken størrelse skal brettet ha? angi i n i n*n ruter.");
		n = Integer.parseInt(sc.nextLine());
		
		System.out.println("Angi startsposisjon for springeren \nKoordinat X: ");
		int startPositionX = Integer.parseInt(sc.nextLine());
		System.out.println("Koordinat Y: ");
		int startPositionY = Integer.parseInt(sc.nextLine());
		sc.close();
		
		Board board = new Board(n);
		KnightSolver knightSolver = new KnightSolver(board);
		boolean result = knightSolver.solve(startPositionX, startPositionY);
		if(result)
			System.out.println("\nSolution was found");
		else
			System.out.println("Solution was not found");
	}
}
