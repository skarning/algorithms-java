
public class FibTest {

	public static void main(String[] args) {
		System.out.println(metode_c(100));
		System.out.println(10%100);
		
	}
	
	public static long fib(int n) {
		if(n <= 2)
			return 1;
		return fib(n - 1) + fib(n - 2);
	}
	
	public static int metode_c(int n) {
		int i = n;
		int l = 0;
		while(i > 0) {
			l++;
			i/=10;
		}
		return l;
	}
}
