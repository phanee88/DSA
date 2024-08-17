package com.dsa.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LogestSubStringKdistinctChars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "araaci";
		int k = 1;
		System.out.println(findLengthWindow(s, k));

	}

	public static int findLengthWindow(String s, int k) {

		int maxLength = 0;
		int windowStart = 0;
		Map<Character, Integer> charMap = new HashMap<>();

		for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
			char rightChar = s.charAt(windowEnd);
			charMap.put(rightChar, charMap.getOrDefault(rightChar, 0) + 1);
			while (charMap.size() > k) {
				char leftChar = s.charAt(windowStart);
				charMap.put(leftChar, charMap.getOrDefault(rightChar, 0) - 1);
				if (charMap.get(leftChar) == 0) {
					charMap.remove(leftChar);
				}
				windowStart++;
			}
			maxLength = Math.max(maxLength, windowEnd - windowStart + 1);

		}

		return maxLength;

	}

	public static int findLength(String s, int k) {
		int maxLength = 0;
		int n = s.length();
		for (int i = 0; i < n; i++) {
			Set<Character> set = new HashSet<>();
			int currLength = 0;

			for (int j = i; j < n; j++) {
				set.add(s.charAt(j));
				currLength++;

				if (set.size() > k)
					break;
			}

			maxLength = Math.max(maxLength, currLength);
		}

		return maxLength;
	}

}
