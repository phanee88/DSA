package com.dsa.cyclic;

public class MissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 4, 0, 3, 1 };
		int missingNumber = findMissingNumber(arr);
		System.out.println(missingNumber);

	}

	public static int findMissingNumber(int[] arr) {

		int i = 0;
		while (i < arr.length) {

			if (arr[i] < arr.length && arr[i] != arr[arr[i]]) {
				swap(arr, i, arr[i]);

			} else {
				i++;
			}

		}

		for (i = 0; i < arr.length; i++) {
			if (arr[i] != i)
				return i;
		}
		return arr.length;
	}

	public static void swap(int[] arr, int i, int j) {

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
