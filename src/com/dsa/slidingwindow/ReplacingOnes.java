package com.dsa.slidingwindow;

public class ReplacingOnes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int arr[] = {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
		int k=3;

		int maxsubArrayLength=findLength(arr,k);
		System.out.println(maxsubArrayLength);
	}

	// get max consecutive ones with no more than replacing k0's
	//no of zeros to be replaced is k
	public static int findLength(int [] arr,int k)
	{
		
		
		int windowStart=0;
		int zeroCount=0;
		int maxLength=0;
		
		for(int windowEnd=0;windowEnd<arr.length;windowEnd++)
		{
			
			if(arr[windowEnd]==0)
			{
				zeroCount++;
			}
			
			while(zeroCount>k)
			{
				if(arr[windowStart]==0)
					zeroCount--;
				windowStart++;
			}
			
			maxLength= Math.max(maxLength, windowEnd-windowStart+1);
		}
		
		return maxLength;
	}
}
