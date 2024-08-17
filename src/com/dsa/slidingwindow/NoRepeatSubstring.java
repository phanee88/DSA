package com.dsa.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NoRepeatSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int length = slidingwindow("aabccbb");
		System.out.println(length);
	}

	public static int longestSubstring(String s) {
		int maxLength = 0;

		for (int i = 0; i < s.length(); i++) {

			for (int j = i; j < s.length(); j++) {
				if (allUnique(s, i, j)) {
					maxLength = Math.max(maxLength, j - i + 1);
				}
			}

		}
		return maxLength;
	}

	private static boolean allUnique(String s, int start, int end) {
		Set<Character> charSet = new HashSet<>();

		for (int i = start; i <= end; i++) {
			char leftChar = s.charAt(i);

			if (charSet.contains(leftChar)) {
				return false;
			}
			charSet.add(leftChar);
		}

		return true;
	}

	public static int slidingwindow(String s) {
		int windowStart = 0;
		int maxLength = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
			char rightChar = s.charAt(windowEnd);
			if (map.containsKey(rightChar)) {
				windowStart = Math.max(windowStart, map.get(rightChar) + 1);
			}
			map.put(rightChar, windowEnd);
			maxLength = Math.max(maxLength, windowEnd - windowStart + 1);

		}

		return maxLength;
	}
}
