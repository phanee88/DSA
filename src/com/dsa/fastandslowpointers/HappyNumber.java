package com.dsa.fastandslowpointers;

public class HappyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(isHappyNumber(1));

	}

	public static boolean isHappyNumber(int n) {
		int slow = n;
		int fast = sumOfSquaredNumbers(n);
		while ( fast != slow) {
			
			if (fast == 1)
				return true;
			
			//move slow pointer one time 
			slow = sumOfSquaredNumbers(slow);
			//move fast pointer two times
			fast = sumOfSquaredNumbers(sumOfSquaredNumbers(fast));
			
			
		}

		
		
			return false;
	}

	public static int sumOfSquaredNumbers(int n) {
		int sum = 0;
		while (n > 0) {
			// Below will fetch the right most digit from the given number
			int remainder = n % 10;
			// if we divide small number(number less than 10) by 10, we get the same
			// digit.ex 4/10=4. 2/10=2
			n = n / 10;
			// by now, for given n 42, we are able to fetch 4 and 2 seperately

			sum += Math.pow(remainder, 2);
		}

		return sum;
	}

}
