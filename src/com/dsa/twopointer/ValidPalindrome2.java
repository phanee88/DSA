package com.dsa.twopointer;

public class ValidPalindrome2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "RACEABCAR";
		System.out.println("isPalindrome :: " + isPalindrome(s));
	}

	public static boolean isPalindrome(String s) {

		int start = 0;
		int end = s.length() - 1;

		while (start < end) {
			if (s.charAt(start) == s.charAt(end)) {
				start++;
				end--;

			} else {
				//If not matching, advance the left pointer which means we are skipping the left char and check
				//if first statement returns false second call in advancing the right pointer backwards and compare
				return isPalindrome(s, start++, end) || isPalindrome(s, start, end--);

			}

		}
		return true;

	}

	public static boolean isPalindrome(String s, int start, int end) {
		while (start < end) {
			if (s.charAt(start) == s.charAt(end)) {

				start++;
				end--;
			} else {
				return false;
			}
		}
		return true;
	}

}
