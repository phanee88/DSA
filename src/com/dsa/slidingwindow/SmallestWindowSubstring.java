package com.dsa.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class SmallestWindowSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s="aabdec";
		String Pattern="abc";
		
		String subStr=smallestWindowSubstring(s,Pattern);
		System.out.println("subStr "+subStr);

	}

	public static  String smallestWindowSubstring(String str,String pattern ) {
		
		if (str == null || str.length() == 0 || pattern == null || pattern.length() == 0) {
            return "";
        }
		
		int lenS=str.length();
		int lenP=pattern.length();
		Map<Character,Integer> patternCount=new HashMap<>();
		for(int i=0;i<lenP;i++)
		{
			char c=pattern.charAt(i);
			patternCount.put(c, patternCount.getOrDefault(c, 0)+1);
		}
		
		int start=0; int minLength=Integer.MAX_VALUE;int matched=0;
		 int substrStart = 0;
		Map<Character,Integer> windowCount=new HashMap<>();
		for(int end=0;end<lenS;end++)
		{
			char rightChar=str.charAt(end);
			windowCount.put(rightChar, windowCount.getOrDefault(rightChar, 0)+1);
			
			if(patternCount.containsKey(rightChar) &&
				windowCount.get(rightChar).intValue()<=patternCount.get(rightChar)	)
			{
				matched++;
			}
			
			//Once the matched counter equals the length of the pattern, 
			//the window contains all characters of the pattern,shrink the window
			while(matched==pattern.length())
			{
				
				if(minLength>end-start+1)
				{
					minLength=end-start+1;
					substrStart=start;
				}
				
				//increment starting window
				char leftChar=str.charAt(start++);
				windowCount.put(leftChar, windowCount.getOrDefault(windowCount, 0)-1);
				if(patternCount.containsKey(leftChar) && 
						windowCount.get(leftChar).intValue()<patternCount.get(leftChar).intValue()) {
					matched--;
				}
			}
			
		}
		System.out.println(patternCount);
		
		return minLength==Integer.MAX_VALUE?"":str.substring(substrStart, substrStart+minLength);
		
		
		
	}
}
