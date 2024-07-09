package com.dsa.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "oidbcaf";
		String p = "abc";
		System.out.println(isPatternPresent(s, p));
	}

	public static boolean isPatternPresent(String str, String ptr) {

		Map<Character, Integer> patternCount = new HashMap<>();

		int lenS = str.length();
		int lenP = ptr.length();

		// first save the chars and the frequencies of the pattern map
		for (int i = 0; i < lenP; i++) {
			patternCount.put(ptr.charAt(i), patternCount.getOrDefault(ptr.charAt(i), 0) + 1);
		}

		System.out.println(patternCount);

		Map<Character, Integer> windowCount = new HashMap<>();
		// Frequency count of characters in the initial window of the string
		for (int i = 0; i < lenP; i++) {
			windowCount.put(str.charAt(i), patternCount.getOrDefault(str.charAt(i), 0) + 1);
		}

		// if pattern count and window count matches return true
		if (matches(patternCount, windowCount))
			return true;

		// slide the window over the string starts from first char

		for (int i = lenP; i < lenS; i++) {
			char startChar = str.charAt(i - lenP);
			char endChar = str.charAt(i);

			System.out.println("i -> "+i+ " startChar :: "+startChar +" endChar:: "+endChar);
			if (windowCount.get(startChar) == 1) {
				windowCount.remove(startChar);
			} else {
				windowCount.put(startChar, patternCount.getOrDefault(startChar, 0) - 1);
			}
			windowCount.put(endChar, windowCount.getOrDefault(endChar, 0) + 1);
			System.out.println("windowCount :: "+windowCount);
			
			if (matches(patternCount, windowCount))
				return true;
		}

		return false;
	}

	private static boolean matches(Map<Character, Integer> patternCount, Map<Character, Integer> windowCount) {
		// TODO Auto-generated method stub

		for (char key : patternCount.keySet()) {
			if (!patternCount.get(key).equals(windowCount.getOrDefault(key, 0)))
				return false;

		}
		return true;
	}

}
