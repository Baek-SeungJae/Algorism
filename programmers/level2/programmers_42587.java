package programmers.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class programmers_42587 {

	public static void main(String[] args) {
		int[] priorities = new int[] { 1, 1, 9, 1, 1, 1 };
		System.out.println(solution(priorities,0));
	}

	public static int solution(int[] priorities, int location) {
		HashMap<Integer,Integer> hm = new HashMap<>();
		Queue<Integer> priorities_q = new LinkedList<Integer>();
		Queue<Integer> answer_q = new LinkedList<Integer>();
		int answer = 0;
		for(int i=0; i< priorities.length;i++) {
			hm.put(i, priorities[i]);
			priorities_q.add(i);
		}
		Arrays.sort(priorities);
		for(int i= priorities.length-1; i>=0; i--) {
			while(hm.get(priorities_q.peek())<priorities[i]) {
				priorities_q.add(priorities_q.poll());
			}
			answer = priorities_q.poll();
			if(answer==location) {
				return (priorities.length-i);
			}
			answer_q.add(answer);
		}
        return answer;
    }

}
