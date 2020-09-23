package programmers.level2;

import java.util.PriorityQueue;

public class programmers_42626 {

	public static void main(String[] args) {
		int[] scoville = { 1, 2, 3, 9, 10, 12 };
		int K = 100;
		System.out.println(solution(scoville, K));
	}

	public static int solution(int[] scoville, int K) {

		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();

		for (int i = 0; i < scoville.length; i++) {
			priorityQueue.add(scoville[i]);
		}
		int loopCount = 0;
		while (priorityQueue.peek()<K) {
			int first = priorityQueue.poll();
			int second = priorityQueue.poll();
			int newScoville = first + second * 2;
			System.out.println(first + "," + second + "," + newScoville);
			priorityQueue.add(newScoville);
			loopCount++;
			if (priorityQueue.size() < 2) {
				if(newScoville>=K){
                    break;
                } else {
                    return -1;
                }
			}
			
		}
		int answer = loopCount;
		return answer;
	}
}
