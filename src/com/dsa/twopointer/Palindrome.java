package com.dsa.twopointer;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("RACECAR "+isPalindrome("RACECAR"));

	}

	public static boolean isPalindrome(String s) {

		// Use one pointer at the begining and another one at the end
		int start = 0;
		int end = s.length() - 1;

		while (start < end) {

			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}

			start++;
			end--;
		}
		
		return true;
	}
}
