package com.dsa.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramsInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "oidbcaf";
		String p = "abc";
		
		String s1="ppqp";
		String p1="pq";

		List<Integer> result=findAnagrams(s1, p1);
		System.out.println(result);
	}

	public static List<Integer> findAnagrams(String str, String pattern) {

		Map<Character, Integer> patternMap = new HashMap<>();
		List<Integer> result = new ArrayList<>();

		int lenP = pattern.length();
		int lenS = str.length();
		
		System.out.println("lenP "+lenP +" lenS "+lenS);

		for (int i = 0; i < lenP; i++) {
			patternMap.put(pattern.charAt(i), patternMap.getOrDefault(pattern.charAt(i), 0) + 1);
		}

		System.out.println("patternMap "+patternMap);

		Map<Character, Integer> windowMap = new HashMap<>();

		for (int i = 0; i < lenP; i++) {
			windowMap.put(str.charAt(i), patternMap.getOrDefault(str.charAt(i), 0) + 1);
		}

		System.out.println("windowMap 1st iteration"+windowMap);

		if (matches(patternMap, windowMap)) {
			result.add(0);
		}

		for (int i = lenP; i < lenS; i++) {
			char startChar = str.charAt(i - lenP);
			char endChar = str.charAt(i);
			System.out.println("i -> "+i+ " startChar :: "+startChar +" endChar:: "+endChar);

			if (windowMap.get(startChar) == 1) {
				windowMap.remove(startChar);
			} else {
				windowMap.put(startChar, windowMap.getOrDefault(startChar, 0) - 1);
			}

			windowMap.put(endChar, windowMap.getOrDefault(endChar, 0) + 1);
			
			if(matches(patternMap, windowMap))
			{
				result.add(i-lenP+1);
			}
		}

		return result;
	}

	public static boolean matches(Map<Character, Integer> patterncount, Map<Character, Integer> windowcount) {
		for (char key : patterncount.keySet()) {
			if (!patterncount.get(key).equals(windowcount.getOrDefault(key,0)))
				return false;

		}
		return true;

	}
}
