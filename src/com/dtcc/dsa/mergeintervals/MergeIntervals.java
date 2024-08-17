package com.dtcc.dsa.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Interval {
	int start;
	int end;

	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	 @Override
	    public String toString() {
	        return "[" + start + ", " + end + "]";
	    }

}

public class MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Interval> intervals = new ArrayList<>(Arrays.asList(
	            new Interval(1, 3),
	            new Interval(2, 6),
	            new Interval(8, 10),
	            new Interval(15, 18)
	        ));
		
		List<Interval> mergedList=mergeIntervals(intervals);
		 // Print the merged intervals
        for (Interval interval : mergedList) {
            System.out.println(interval);
        }

	}

	/**
	 * This method will merge the overlapping intervals 
	 * 
	 * @param intervals
	 * @return
	 */
	public static List<Interval> mergeIntervals(List<Interval> intervals)

	{
		
		if(intervals.size()<2) {
			return intervals;
		}
		
		// sort the intervals based on the start time
		intervals.sort(Comparator.comparingInt(interval -> interval.start));
		List<Interval> result = new ArrayList<Interval>();
		
		

		// Iterate through the input list
		for (Interval interval : intervals) {
			// if input list is empty add it to result
			if (result.isEmpty()) {

				result.add(interval);

			}

			Interval lastAddedElement = result.get(result.size() - 1);
			// no overlap, so just add it as an element
			if (lastAddedElement.end < interval.start) {
				result.add(interval);
			}

			else {
				lastAddedElement.end=Math.max(lastAddedElement.end, interval.end);
			}
		}
		
		return result;

	}

}
