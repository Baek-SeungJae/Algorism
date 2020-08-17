package programmers.level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class programmers_42583 {

	public static void main(String[] args) {
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = { 7, 4, 5, 6 };
		System.out.println(solution(bridge_length, weight, truck_weights));

	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {

		/* ?��리위?�� ?��?���??��?�� ?��?��?�� 무게 */
		int weightOnBridge = 0;
		/* �? 걸린 ?���?*/
		int totalTime = 0;
		
		/* ?���? 출발 ?��?�� ?��?�� ??기열 */
		Queue<Integer> q_wait = new LinkedList<Integer>();
		/* ?���? ?�� ?��?�� */
		Queue<Integer> q_bridge = new LinkedList<Integer>();
		/* ?��리위?�� ?��?�� ?��?��?�� 머무�? ?�� ?��?�� ?���? */
		List<Integer> list_bridge = new ArrayList<Integer>();
		/* 배열?�� ?��?�� ???�� */
		for (int i = 0; i < truck_weights.length; i++) {
			q_wait.add(truck_weights[i]);
		}
		/* ?��리위?��?�� ?��?��?�� ?���?, ??기열?��?�� ?��?��?�� ?��?�� ?��까�? 무한루프 */
		while (!q_wait.isEmpty() || !q_bridge.isEmpty()) {
			/* 루프 ?��번당 1�? */
			totalTime++;
			/* 1초�? �??���? ?��리위?�� ?��?�� ?��?��?�� 머무�? ?�� ?��?�� ?���? 1�? 감소 */
			for (int i = 0; i < list_bridge.size(); i++) {
				list_bridge.set(i, list_bridge.get(i) - 1);
			}
			/* �? ?��?��?��?�� ?��?��?�� 머무�? ?�� ?��?�� ?��간이 0초�? ?���? ?���? 밖으�? 빼주�?, 리스?��, ?��?��?�� ?���? */
			while (!list_bridge.isEmpty()) {
				if (list_bridge.get(0) != 0) {
					break;
				}
				list_bridge.remove(0);
				weightOnBridge -= q_bridge.poll();
			}
			/* ?��리위?�� ?��?��?�� ?��?��?�� ??기열?�� ?��?��?�� ?��?�� ?�� ?��?��?��?��?��?��?�� ?��?�� ?��?�� 방�? */
			if (!q_wait.isEmpty()) {
				/* ?��리위?�� ?��?��?�� �? 무게�? 감당?�� ?�� ?��?��?�� ?��리에 ?��?��?���?, ?��?���? else�? 빠져?�� ?��무것?�� ?��?���? ?��간만 증�? */
				if (weightOnBridge + q_wait.peek() <= weight) {
					q_bridge.add(q_wait.peek());
					list_bridge.add(bridge_length);
					weightOnBridge += q_wait.poll();
				} else {
				}
			}
		}
		return totalTime;
	}
}
