package com.dtcc.dsa.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class InsertIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testcase1();
		testcase2();
		testcase3();
		testcase4();
		testcase5();

	}

	private static void extracted(List<Interval> insertList, Interval input) {
		List<Interval> result = insertInterval(insertList, input);
		for (Interval interval : result) {
			System.out.println(interval);
		}
	}

	public static List<Interval> insertInterval(List<Interval> insertList, Interval input) {

		List<Interval> result = new ArrayList<>();
		List<Interval> mutableList = new ArrayList<>(insertList);
		mutableList.add(input);

		mutableList.sort(Comparator.comparingInt(interval -> interval.start));
		System.out.println("Mutable list : "+mutableList);

		for (Interval interval : mutableList) {

			if (result.isEmpty()) {
				result.add(interval);

			}

			// overlapping intervals
			if (result.get(result.size() - 1).end > interval.start) {
				result.get(result.size() - 1).end = Math.max(result.get(result.size() - 1).end, interval.end);
				// non overlapping,just add the interval
			} else {
				result.add(interval);
			}
		}

		return result;
	}

	
	public static List<Interval> insertInterval1(List<Interval> insertList, Interval input) {
        List<Interval> result = new ArrayList<>();
        
        // Add the input interval to the list of intervals
        insertList.add(input);
        
        // Sort the list by start times
        insertList.sort(Comparator.comparingInt(interval -> interval.start));
        
        // Initialize the first interval
        Interval current = insertList.get(0);
        result.add(current);
        
        // Iterate through the sorted intervals
        for (int i = 1; i < insertList.size(); i++) {
            Interval next = insertList.get(i);
            
            if (current.end >= next.start) {
                // Merge overlapping intervals
                current.end = Math.max(current.end, next.end);
            } else {
                // Add non-overlapping intervals
                current = next;
                result.add(current);
            }
        }

        return result;
    }

   
	public static void testcase1() {
		List<Interval> insertList = Arrays.asList(new Interval(1, 3), new Interval(5, 7), new Interval(8, 9),
				new Interval(10, 13));
		System.out.println("Test case 1");
		extracted(insertList, new Interval(2, 6));

	}

	public static void testcase2() {
		List<Interval> insertList = Arrays.asList(new Interval(1, 3), new Interval(6, 9));
		System.out.println("Test case 2");
		extracted(insertList, new Interval(2, 5));

	}

	public static void testcase3() {
		List<Interval> insertList = Arrays.asList(new Interval(1, 3), new Interval(5, 7), new Interval(8, 12));
		System.out.println("Test case 3");
		extracted(insertList, new Interval(4, 6));

	}

	public static void testcase4() {
		List<Interval> insertList = Arrays.asList(new Interval(1, 3), new Interval(5, 7), new Interval(8, 12));
		System.out.println("Test case 4");
		extracted(insertList, new Interval(4, 10));

	}
	
	public static void testcase5() {
		List<Interval> insertList = Arrays.asList(new Interval(2, 3), new Interval(5, 7));
		System.out.println("Test case 5");
		extracted(insertList, new Interval(1, 4));

	}

}
