package com.dsa.twopointer;

import java.util.Arrays;
import java.util.LinkedList;

public class SumOfThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = { 1, 3, 4 };
		System.out.println(nums.length);
		int target = 31;

		boolean res = isSumOfThree(nums, target);
		System.out.println("result is " + res);
	}

	public static boolean isSumOfThree(int[] nums, int target) {
		
		//first step is sort the elements 
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {

			int start = i + 1;
			int end = nums.length - 1;

			while (start < end) {
				int sum = nums[i] + nums[start] + nums[end];
				if (sum == target) {
					return true;

				} else if (sum < target) {
					start++;
				} else {
					end--;
				}
			}

		}

		return false;
	}

}
