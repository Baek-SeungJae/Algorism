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

		/* ?€λ¦¬μ? ?¬?Όκ°??? ?Έ?­? λ¬΄κ² */
		int weightOnBridge = 0;
		/* μ΄? κ±Έλ¦° ?κ°?*/
		int totalTime = 0;
		
		/* ?μ§? μΆλ° ?? ?Έ?­ ??κΈ°μ΄ */
		Queue<Integer> q_wait = new LinkedList<Integer>();
		/* ?€λ¦? ? ?Έ?­ */
		Queue<Integer> q_bridge = new LinkedList<Integer>();
		/* ?€λ¦¬μ? ?? ?Έ?­?΄ λ¨Έλ¬΄λ₯? ? ?? ?κ°? */
		List<Integer> list_bridge = new ArrayList<Integer>();
		/* λ°°μ΄? ?? ???₯ */
		for (int i = 0; i < truck_weights.length; i++) {
			q_wait.add(truck_weights[i]);
		}
		/* ?€λ¦¬μ?? ?Έ?­?΄ ?κ³?, ??κΈ°μ΄?? ?Έ?­?΄ ?? ?κΉμ? λ¬΄νλ£¨ν */
		while (!q_wait.isEmpty() || !q_bridge.isEmpty()) {
			/* λ£¨ν ?λ²λΉ 1μ΄? */
			totalTime++;
			/* 1μ΄κ? μ§??λ©? ?€λ¦¬μ? ?? ?Έ?­?΄ λ¨Έλ¬΄λ₯? ? ?? ?κ°? 1μ΄? κ°μ */
			for (int i = 0; i < list_bridge.size(); i++) {
				list_bridge.set(i, list_bridge.get(i) - 1);
			}
			/* λ§? ???? ?Έ?­?΄ λ¨Έλ¬΄λ₯? ? ?? ?κ°μ΄ 0μ΄κ? ?λ©? ?€λ¦? λ°μΌλ‘? λΉΌμ£Όκ³?, λ¦¬μ€?Έ, ??? ? κ±? */
			while (!list_bridge.isEmpty()) {
				if (list_bridge.get(0) != 0) {
					break;
				}
				list_bridge.remove(0);
				weightOnBridge -= q_bridge.poll();
			}
			/* ?€λ¦¬μ? ?Έ?­?΄ ???° ??κΈ°μ΄? ?Έ?­?΄ ?? ? ??¬?Έ?Έ?΅?? ?¨? ??© λ°©μ? */
			if (!q_wait.isEmpty()) {
				/* ?€λ¦¬μ? ?Έ?­? μ΄? λ¬΄κ²κ°? κ°λΉ?  ? ??΄?Ό ?€λ¦¬μ ?Έ?­?¬λ¦?, ??λ©? elseλ‘? λΉ μ Έ? ?λ¬΄κ²? ??κ³? ?κ°λ§ μ¦κ? */
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
