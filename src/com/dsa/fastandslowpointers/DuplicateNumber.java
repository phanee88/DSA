  package com.dsa.fastandslowpointers;

public class DuplicateNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int nums[]= {1,2,3,4,5,2};

		System.out.println(duplicateNumber(nums));

	}

	public static int duplicateNumber(int[] nums) {
		
		
		int slow=0;
		int fast=slow*2;
		int duplicateNumber=0   ;
		
		while(slow<fast) {
			
			
			slow++;
			fast++;
		}
		
		return 0;
	}

	
}
