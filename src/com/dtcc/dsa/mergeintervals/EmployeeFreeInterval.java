package com.dtcc.dsa.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeFreeInterval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Interval>> employeeSchedule = new ArrayList<>();
		employeeSchedule.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(5, 6))));
		employeeSchedule.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 3), new Interval(6, 8))));

		List<Interval> freeTime = freeInterval(employeeSchedule);
		System.out.println(freeTime);
	}

	public static List<Interval> freeInterval(List<List<Interval>> employeeList) {
		List<Interval> result = new ArrayList<>();
		List<Interval> schedules = employeeList.stream().flatMap(listItem -> listItem.stream())
				.collect(Collectors.toList());

		schedules.sort(Comparator.comparingInt(interval -> interval.start));
		System.out.println(schedules);

		Interval previousInterval = schedules.get(0);

		for (int i = 1; i < schedules.size(); i++) {
			Interval currentInterval = schedules.get(i);

			if (previousInterval.end >= currentInterval.start) {
				previousInterval.end = Math.max(previousInterval.end, currentInterval.end);
			} else {
				result.add(previousInterval);
				previousInterval = currentInterval;
			}
		}
		result.add(previousInterval);

		System.out.println("result " + result);
		// Step 4: Find the gaps between the merged intervals
		List<Interval> freeTimes = new ArrayList<>();
		for (int i = 1; i < result.size(); i++) {
			Interval prevMerged = result.get(i - 1);
			Interval currMerged = result.get(i);
			System.out.println("prevMerged " + prevMerged + "currMerged  " + currMerged);
			if (prevMerged.end < currMerged.start) {
				freeTimes.add(new Interval(prevMerged.end, currMerged.start));
			}
		}

		return freeTimes;
	}
}
