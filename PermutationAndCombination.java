import java.util.Scanner;

/**
 * Finding Permutation and Combination
 * Permutation = factorial(n) / factorial(n-r);
 * Combination = factorial(n) / (factorial(r) * factorial(n-r)); 
 * 
 * @author tanmoy.tushar
 * @since 2019-07-07
 *
 */
public class PermutationAndCombination {
	
	static Scanner sc = new Scanner(System.in);
	
	static int fac(int n) {
		if(n == 0) return 1;
		return n * fac(n - 1);
	}
	
	static int combination(int n, int r) {
		int dividend = fac(n);
		int divisor = fac(r) * fac(n - r);
		return dividend / divisor;
	}
	
	static int permutation(int n, int r) {
		int dividend = fac(n);
		int divisor = fac(n - r);
		return dividend / divisor;
	}
	
	public static void main(String[] args) {
		int n = sc.nextInt();
		int r = sc.nextInt();
		
		System.out.println("Combination of " + n + " & " + r + " is: " + combination(n, r));
		System.out.println("Permutation of " + n + " & " + r + " is: " + permutation(n, r));
	}

}
