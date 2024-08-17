package com.dsa.twopointer;

public class ReverseASentence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		
//		System.out.println(reverseSentence("Programming is fun"));
		
		String s="reverse a sentence";
		
		System.out.println(reverseString(s));
		
		//sentence a reverse
		
		String[ ] arra = s.split(" ");
		
		String reversedString="";

		
		for(int i = arra.length-1;i>=0;i--)
		{
			reversedString+=arra[i];
			reversedString+=" ";
			System.out.println(reversedString);
		}
	}
	
	
	public static String reverseString(String str) {
		char[] strArr=str.toCharArray();
		
		int start=0;
		int end=strArr.length-1;
		
		while(start<end)
		{
			swap(strArr, start, end);
			
			start++;
			end--;
		}
		
		
		
		return String.valueOf(strArr);
	}


	private static void swap(char[] strArr, int start, int end) {
		char temp=strArr[start];
		strArr[start]=strArr[end];
		strArr[end]=temp;
	}
	
	public static String reverseSentence(String sentence) {
		
		char[] senCharArr=sentence.trim().toCharArray();
		int length=senCharArr.length;
		System.out.println(senCharArr);
		
		
		return null;
		
	}

}
