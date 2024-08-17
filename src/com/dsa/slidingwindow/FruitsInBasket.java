package com.dsa.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FruitsInBasket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[] fruits = { 'A', 'B', 'C', 'A', 'C' };
		int maxFruits = maxFruits(fruits);
		System.out.println(maxFruits);

	}

	public static int maxFruits(char[] fruits) {

		int maxFruits = 0;

		int n = fruits.length;

		for (int i = 0; i < n; i++) {
			Set<Character> charSet = new HashSet<>();
			int currLength = 0;

			for (int j = i; j < n; j++) {
				charSet.add(fruits[i]);

				if (charSet.size() > 2)
					break;
				currLength++;
			}

			maxFruits = Math.max(maxFruits, currLength);
		}
		return maxFruits;

	}

	/*
	 * Input: String="araaci", K=2 Output: 4 Explanation: The longest substring with
	 * no more than '2' distinct characters is "araa".
	 */
	public static int longestSubString(String s, int k) {

		// longest substring with k distinct char

		int n = s.length();

		int maxLength = 0;
		int windowStart = 0;
		Map<Character, Integer> map = new HashMap<>();

		for (int windowEnd = 0; windowEnd < n; windowEnd++) {
			char rightChar = s.charAt(windowEnd);
				map.put(rightChar, map.getOrDefault(rightChar,0) + 1);
				
				//a 1 2 2
				//r1
				//c1
				//i1
				
				
			}

		

		return 0;
	}

}
