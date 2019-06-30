import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please insert data");
		System.out.println("N:");
		int n = sc.nextInt();
		double[] input = new double[n];
		double avg = 0;
		for(int i = 0; i < n; i++) {
			System.out.println("Value" + i + ": ");
			input[i] = sc.nextDouble();
			avg += input[i];
		}
		avg = avg / n;
		sc.close();
		double standardDeviation = calculateSD(input, n, avg);
		System.out.println("Standard-deviation is: " + standardDeviation);
		System.exit(1);
	}
	private static double calculateSD(double input[], int n, double avg) {
		double sum = 0;
		for(int i = 0; i < n; i++) {
			sum += Math.pow(input[i] - avg, 2);
		}
		return Math.sqrt(Math.pow(sum / n - 1, 2));
	}
}
