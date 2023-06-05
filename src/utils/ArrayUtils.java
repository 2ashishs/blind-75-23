package utils;

import java.util.HashSet;
import java.util.Random;

/**
 * ArrayUtils class provides methods to generate test data for the problems
 * - Generate an array of random Integers with
	 * - `size` elements
	 * - `bound` max value
	 * - `canRepeat`
	 * - `isNegativeAllowed`
 * - Generate a 2d array of random Integers with
	 * - `rows` rows
	 * - `cols` columns
	 * - `bound` max value
	 * - `isNegativeAllowed`
 */
public class ArrayUtils {

    private final Random random;

	public ArrayUtils() {
		random = new Random(System.currentTimeMillis());
	}

	/**
	 * @return multiplier sign for random number
	 */
	public int getSign() {
		return (random.nextBoolean() ? 1 : -1);
	}

	/**
	 * @param bound - max value
	 * @param isNegativeAllowed - allow -ve random integers
	 * @return random integer
	 */
    public int getInt(int bound, boolean isNegativeAllowed) {
		int result = random.nextInt(bound);
		if (isNegativeAllowed) {
			return (result * getSign());
		}
		return result;
    }

	/**
	 * @param size - length of array
	 * @param bound - max value of elements
	 * @param canRepeat - should array elements be unique
	 * @param isNegativeAllowed - allow -ve random integers
	 * @return 1d array of random integers
	 */
	public int[] get1dInt(int size, int bound, boolean canRepeat, boolean isNegativeAllowed) {
		int[] result = new int[size];
		int element;
		HashSet<Integer> uniqueElements = new HashSet<>();
		for (int i = 0; i < size; i++) {
			element = getInt(bound, isNegativeAllowed);
			if (canRepeat) {
				result[i] = element;
			} else {
				if (uniqueElements.contains(element)) {
					i--;
				} else {
					uniqueElements.add(element);
				}
			}
		}
		return result;
	}

	public void print1dInt(int[] arr, String description, boolean isIdxRequired) {
		System.out.print(description + " :");
		for (int i = 0; i < arr.length; i++) {
			if (isIdxRequired) {
				System.out.print(" " + i + ":" + arr[i]);
			} else {
				System.out.print(" " + arr[1]);
			}
		}
		System.out.println();
	}

	public int[][] get2dInt(int rows, int cols, int bound, boolean isNegativeAllowed) {
		int[][] result = new int[rows][cols];
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				result[r][c] = getInt(bound, isNegativeAllowed);
			}
		}
		return result;
	}
	//Try with builder pattern
}