package programmers.level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers_49993 {
	public static void main(String[] args) {
		int[] progresses = new int[] { 93, 30, 55 };
		int[] speeds = new int[] { 1, 30, 5 };
		System.out.println(solution(progresses, speeds));
	}

	public static int[] solution(int[] progresses, int[] speeds) {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < progresses.length; i++) {
			int x = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
			q.add(x);
		}
		ArrayList<Integer> al = new ArrayList<>();
		while (!q.isEmpty()) {
			int i = 1;
			int check = q.poll();
			if (!q.isEmpty()) {
				while (check >= q.peek()) {
					i++;
					q.poll();
					if (q.isEmpty()) {
						break;
					}
				}
			}
			al.add(i);
		}
		
		int[] answer = new int[al.size()];
		for(int i=0; i<al.size(); i++) {
			answer[i] = al.get(i);
		}
		return answer;
	}
}