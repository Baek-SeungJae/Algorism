package programmers.level3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class programmers_42627 {

	public static void main(String[] args) {
/*
		int[][] jobs = { { 0, 3 }, { 1, 9 }, { 2, 6 } };
		System.out.println("9: " + solution(jobs));
		int[][] jobs2 = { { 0, 3 }, { 4, 3 }, { 10, 3 } };
		System.out.println("3: " + solution(jobs2));
		int[][] jobs3 = { { 0, 10 }, { 2, 3 }, { 9, 3 } };
		System.out.println("9: " + solution(jobs3));
		int[][] jobs4 = { { 1, 10 }, { 3, 3 }, { 10, 3 } };
		System.out.println("9: " + solution(jobs4));
		int[][] jobs5 = { { 0, 10 } };
		System.out.println("10: " + solution(jobs5));
		int[][] jobs6 = { { 0, 10 }, { 4, 10 }, { 5, 11 }, { 15, 2 } };
		System.out.println("15: " + solution(jobs6));
	*/	
		int[][] jobs7 = { { 0, 1}, { 1, 3 }, { 1, 1 } };
		System.out.println("3: " + solution(jobs7));
	}

	public static int solution(int[][] jobs) {
		Arrays.sort(jobs,comparator2);
		for(int i=0; i<jobs.length;i++)
			System.out.println(jobs[i][0]+ ","+jobs[i][1]);
		PriorityQueue<int[]> heap = new PriorityQueue<int[]>(comparator);
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < jobs.length; i++) {
			q.add(jobs[i]);
		}
		int time = 0;
		int current = 0;
		int total = 0;
		int prior = 0;
		while (!(q.isEmpty() && heap.isEmpty())) {
			//System.out.println(time + " " + current);
			if (!q.isEmpty() && q.peek()[0] <= time) {
				heap.add(q.poll());
			}
			if (current == 0) {
				//System.out.println(time);
				total += time - prior;
				System.out.println(total);
			}
			if (!heap.isEmpty() && current <= 0) {
				current = heap.peek()[1];
				prior = heap.poll()[0];
			}
			time++;

			current--;

		}
		total += time - prior + current;
		System.out.println(total);

		int answer = total / jobs.length;
		return answer;
	}

	static Comparator<int[]> comparator = new Comparator<int[]>() {

		@Override
		public int compare(int[] o1, int[] o2) {
			if (o1[1] > o2[1]) {
				return 1;
			} else if (o1[1] < o2[1]) {
				return -1;
			} else {
				if (o1[0] > o1[0]) {
					return 1;
				} else {
					return -1;
				}
			}
		}
	};
	static Comparator<int[]> comparator2 = new Comparator<int[]>() {

		@Override
		public int compare(int[] o1, int[] o2) {
			if (o1[0] > o2[0]) {
				return 1;
			} else if (o1[0] < o2[0]) {
				return -1;
			} else {
				if (o1[1] > o1[1]) {
					return 1;
				} else {
					return -1;
				}
			}
		}
	};
}
