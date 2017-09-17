import java.util.ArrayList;
import java.util.Scanner;

public class MathSeries {

	/**
	 * @Author: Blazerg 02/04/2017
	 * https://github.com/Blazerg2
	 *          this program calculates any number in the series: f(n) = -f(n-1)
	 *          * f(n-2), with f(0) = 1 and f(1) = 2.
	 * 
	 *          the same result is gonna appear twice because I am using two
	 *          different approaches, using recursion and using an ArrayList
	 */

	public static void main(String[] args) {
		int endingNumber;

		// we ask for the series length
		System.out.println("please, introduce a number higher than 0:");
		Scanner sc = new Scanner(System.in);
		//try/catch is necessary to prevent errors if the user's input is not a number
		try {
			endingNumber = sc.nextInt();
		} catch (Exception e) {
			endingNumber = -1;

		}
		sc.close(); // closing the scanner in order to prevent memory leaks

		// first, using recursion, not a negative number control is required
		// because of the for ending condition.
		for (int i = 0; i <= endingNumber; i++) {
			System.out.print(seriesRecursive(i) + " ");
		}

		// The second approach, calling a function that creates an ArrayList, a
		// negative number control is required in order to avoid
		// arrayIndexException
		if (endingNumber >= 0) {
			serieArray(endingNumber);
		} else {
			System.out.println("\n ERROR: not a valid number");
		}
	}

	static int seriesRecursive(int n) {
		if (n > 1) {
			return -seriesRecursive(n - 1) * seriesRecursive(n - 2); // function recursive
		} else if (n == 1) {
			return 2;
		} else if (n == 0) {
			return 1;
		} else { // just in case something weird happens
			System.out.println("ERROR: not a valid number");
			return -1;
		}
	}

	static ArrayList<Integer> serieArray(int n) {
		ArrayList<Integer> serieList = new ArrayList<Integer>();
		serieList.add(1);
		serieList.add(2);
		if (n > 1) {
			for (int i = 2; i <= n; i++) {
				serieList.add(-serieList.get(i - 1) * serieList.get(i - 2));
			}
		}
		System.out.println("\n" + serieList.subList(0, n + 1)); // serieList.subList to be sure that we are
																// showing the correct List
		return serieList;
	}

}
