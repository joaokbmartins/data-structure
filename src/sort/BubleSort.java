package sort;

import java.util.Arrays;

public class BubleSort {

	public static void main(String[] args) {

		int[] initial = { 2345243, 543, 25, 4236, 432, 423, 6, 214, 1, 24, 6, 7434743, 62, 5, 23, 532, 5 };
//		int[] initial = { 5, 4, 3, 2, 1 };

		System.out.println("Initial: " + Arrays.toString(initial));

		for (int i = 0; i < initial.length; i++) {
			for (int j = 0; j < initial.length; j++) {

				if (initial[j] > initial[i]) {
					int aux = initial[i];
					initial[i] = initial[j];
					initial[j] = aux;
				}

			}
		}

		System.out.println("Reverse: " + Arrays.toString(initial));

	}

}
