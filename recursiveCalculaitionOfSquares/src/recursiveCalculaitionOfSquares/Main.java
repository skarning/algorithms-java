package recursiveCalculaitionOfSquares;

public class Main {

	public static void main(String[] args) {
		System.out.println(calculateSquares(10));
	}
	
	private static int calculateSquares(int n) {
		if(n==1)
			return 1;
		return 2 * n + calculateSquares(n - 1) - 1;
	}

}
