package com.dtcc.dsa.mergeintervals;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Job {
	int start;
	int end;
	int cpuload;
}

public class MaxCPULoad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int maxLoad(List<Job> jobs) {

		jobs.sort(Comparator.comparingInt(interval -> interval.start));

		PriorityQueue<Job> minHeap = new PriorityQueue<>(jobs.size(),
				Comparator.comparingInt(interval -> interval.end));

		int maxCpuLoad = 0;
		int currentCpuLoad = 0;
		for (Job job : jobs) {
			while (!minHeap.isEmpty() && job.start > minHeap.peek().end) {
				currentCpuLoad -= minHeap.poll().cpuload;
			}
			minHeap.offer(job);
			currentCpuLoad += job.cpuload;
			maxCpuLoad = Math.max(maxCpuLoad, currentCpuLoad);
		}
		return maxCpuLoad;

	}

}
