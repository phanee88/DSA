package com.dsa.slidingwindow;

public class MaxSumOfSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 2, 1, 5, 1, 3, 2 };
		int k = 4;
		int sum = maxSumBruteForce(arr, k);
		int sumOptimized = maxSumSlidingWindow(arr, k);

		System.out.println("sum of first 3 elements is " + sum + " and Optimized Sum " + sumOptimized);
	}

	private static int maxSumBruteForce(int[] arr, int k) {

		int maxSum = 0;

		for (int i = 0; i <= arr.length - k; i++) {

			int windowSum = 0;

			for (int j = i; j < i + k; j++) {
				windowSum += arr[j];
			}

			maxSum = Math.max(maxSum, windowSum);
		}
		return maxSum;
	}

	private static int maxSumSlidingWindow(int[] arr, int k) {

		int maxSum = 0;
		int windowStart = 0;
		int windowSum = 0;

		for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {

			windowSum += arr[windowEnd];
			//
			if (windowEnd >= k - 1) {
				maxSum = Math.max(windowSum, maxSum);
				// substract the element going out
				windowSum -= arr[windowStart];
				windowStart++;
			}

		}

		return maxSum;
	}
	
	
	

}
