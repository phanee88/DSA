package com.dtcc.dsa.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumMeetingRooms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Interval> intervals = new ArrayList<>(
				Arrays.asList(new Interval(1, 3), new Interval(2, 6), new Interval(8, 10), new Interval(15, 18)));

		minimumRoomsRequired(intervals);

	}

	public static int minimumRoomsRequired(List<Interval> intervals) {

		if (intervals.size() == 0)
			return 0;

		intervals.sort(Comparator.comparingInt(interval -> interval.start));
		int minRoomsRequired = 0;

		PriorityQueue<Interval> minHeap = new PriorityQueue<>(intervals.size(),
				Comparator.comparingInt(interval -> interval.end));
		System.out.println(minHeap);
		for (Interval interval : intervals) {
			//remove the meeting ended, to find get the meeting from the top 
			while (!minHeap.isEmpty() && interval.start >= minHeap.peek().end) {
				minHeap.poll();
			}

			minHeap.offer(interval);

			minRoomsRequired = Math.max(minRoomsRequired, minHeap.size());

		}

		return minRoomsRequired;
	}
}
