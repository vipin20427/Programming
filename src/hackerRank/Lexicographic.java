package hackerRank;

import java.util.Scanner;

public class Lexicographic {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */

		Scanner scanner = new Scanner(System.in);
		int numberOfTests = scanner.nextInt();

		while (numberOfTests-- != 0) {

			int n = scanner.nextInt();
			char array[][] = new char[n][n];

			for (int i = 0; i < n; i++) {
				String input = scanner.nextLine();
				for (int j = 0; j < input.length(); j++)
					array[i][j] = input.charAt(j);
			}

			for (int row = 0; row < n; row++)
				for (int i = 0; i < n; i++) {
					char key = array[row][i];

					for (int j = i - 1; j > 0; j--) {
						if (array[row][j] > key) {

							array[row][j + 1] = array[row][j];
							array[row][j] = key;

							continue;
						} else {
							break;
						}
					}
				}

			
			for (int col = 0; col < n - 1; col++) {
				for (int row = 0; row < n - 1; row++) {
					if (array[row][col] > array[row + 1][col]) {
						System.out.println("NO");
						
				
			}

			if ((!isDone && !isPossible) || isPossible) 
				System.out.println("YES");
		}

	}
}