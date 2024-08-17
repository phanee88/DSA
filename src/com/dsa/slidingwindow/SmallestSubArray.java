package com.dsa.slidingwindow;

public class SmallestSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 2, 1, 5, 2, 3, 2 };
		int s = 7;
		
		
		int[] arr1 = { 5, 1,3, 5,10,7,4,9, 2, 8 };
		int s1 = 10;

		int output = smallestSubArrayNew(arr1, s1);
		int optimizedOutput = smallestSubArraySlidingWindow(arr1, s1);
		System.out.println("output " + output + "optimizedOutput " + optimizedOutput);

	}

	

	private static int smallestSubArrayNew(int[] arr, int targetSum) {

		int ans = Integer.MAX_VALUE;

		for (int i = 0; i < arr.length; i++) {
			int sum = 0;

			for (int j = i; j < arr.length; j++) {

				if (sum + arr[j] >= targetSum) {
					sum += arr[j];
					ans = Math.min(ans, j - i + 1);
					break;
				}
				sum += arr[j];
			}
		}

		return ans;

	}

	private static int smallestSubArraySlidingWindow(int[] arr, int targetSum) {

		int minLength = Integer.MAX_VALUE;
		int windowStart = 0;
		int windowSum = 0;

		for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {

			windowSum += arr[windowEnd];

			while (windowSum >= targetSum) {
				minLength = Math.min(minLength, windowEnd - windowStart + 1);
				windowSum -= arr[windowStart];
				windowStart++;
			}
		}

		return minLength == Integer.MAX_VALUE ? 0 : minLength;
	}
}
