package com.dsa.cyclic;

public class CyclicSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {4, 0, 3, 1};//{ 5, 6, 3, 2, 4, 1 };
		int[] output = sort(arr);

		for (int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}

	}

	public static int[] sort(int[] arr) {

		int i = 0;

		while (i < arr.length) {
			int j = arr[i] - 1;
			if (arr[i] != arr[j]) {
				swap(arr, i, j);

			} else {
				i++;
			}
		}
		return arr;
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}
}
