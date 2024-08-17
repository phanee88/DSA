package com.dtcc.dsa.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class IntrervalIntersections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		testcase1();

	}
	
	public static List<Interval> intersrctions(List<Interval> firstList,List<Interval> secondList)
	{ 
		List<Interval> intersections=new ArrayList<>();
		
		firstList.sort(Comparator.comparingInt(firstInterval->firstInterval.start));
		secondList.sort(Comparator.comparingInt(secondInterval -> secondInterval.start));
		
		int i=0;int j=0;
		
		while(i<firstList.size() && j<secondList.size())
		{
			int startMax=Math.max(firstList.get(i).start, secondList.get(j).start);
			int endMin=Math.min(firstList.get(i).end, secondList.get(j).end);
			
			if(startMax<=endMin) {
				intersections.add(new Interval(startMax, endMin));
			}
			if(firstList.get(i).start<secondList.get(j).start)
			{
				i++;
			}else {
				j++;
			}
			
		}
		
		return intersections;
	}

	
	public static void testcase1() {
		List<Interval> firstList = Arrays.asList(new Interval(1, 4), new Interval(5, 6), new Interval(7, 8),
				new Interval(9, 15));
		List<Interval> secondList = Arrays.asList(new Interval(2, 4), new Interval(5, 7), new Interval(9, 15)
				);
		System.out.println("Test case 1");
		List<Interval> output = intersrctions(firstList, secondList);
		System.out.println(output);

	}
}
