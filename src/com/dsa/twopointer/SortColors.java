package com.dsa.twopointer;

import java.util.Arrays;

public class SortColors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] colors=new int[] {2,1,1,0,0};
		
		int [] output = sortColors(colors);
		
		Arrays.stream(output).forEach(System.out::println); 

	}

	
	public static int[] sortColors (int[] colors) {
		
		int start=0;
		int current=0;
		int end=colors.length-1;
		
		while (current<=end)
		{
			//swap the start element  with current element
			if(colors[current]==0)
			{
				int temp= colors[start];
				colors[start]=colors[current];
				colors[current]=temp;
				
				start++;
				current++;
			}else if(colors[current]==1)
			{
				current++;
			}else {
				int a=colors[end];
				colors[end]=colors[current];
				colors[current]=a;
				end--;
//				current++;
			}
		}
		
		
		
		return colors;
	}
}
