package com.dtcc.dsa.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ConflictingAppointments {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Interval> intervals = new ArrayList<>(Arrays.asList(
	            new Interval(1, 3),
	            new Interval(2, 6),
	            new Interval(8, 10),
	            new Interval(15, 18)
	        ));
		boolean isConflicted=AreconlfictedIntervals(intervals);
		System.out.println("intervals "+intervals +" is any interval conflicted ? "+isConflicted);
		
	}

	/**
	 * This method will merge the overlapping intervals
	 * 
	 * @param intervals
	 * @return
	 */
	public static boolean AreconlfictedIntervals(List<Interval> intervals)

	{
		List<Interval> result = new ArrayList<>();
		intervals.sort(Comparator.comparingInt(interval -> interval.start));

		for (Interval interval : intervals) {

			if (result.isEmpty()) {
				result.add(interval);
			}
			if (interval.start < result.get(result.size() - 1).end) {
				return true;
			}
		}

		return false;
	}
}
