package programmers;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class programmers_42885 {

	public static void main(String[] args) {
		int[] people = {70, 80, 50};
		int limit = 100;
		System.out.println(solution(people, limit));
	}

	public static int solution(int[] people, int limit) {
		Arrays.sort(people);
		Deque<Integer> boat = new LinkedList<Integer>();
		for(int i=0; i< people.length; i++) {
			boat.addLast(people[i]);
		}
		
		int answer = 0;
		while(!boat.isEmpty()) {
			if(boat.peekLast()+boat.peekFirst()>limit) {
				boat.pollLast();
				answer++;
			} else {
				boat.pollFirst();
				boat.pollLast();
				answer++;
			}
		}
        return answer;
    }
}
