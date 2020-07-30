package programmers;

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

		/* 다리위에 올라가있는 트럭의 무게 */
		int weightOnBridge = 0;
		/* 총 걸린 시간*/
		int totalTime = 0;
		
		/* 아직 출발 안한 트럭 대기열 */
		Queue<Integer> q_wait = new LinkedList<Integer>();
		/* 다리 위 트럭 */
		Queue<Integer> q_bridge = new LinkedList<Integer>();
		/* 다리위에 있는 트럭이 머무를 수 있는 시간 */
		List<Integer> list_bridge = new ArrayList<Integer>();
		/* 배열을 큐에 저장 */
		for (int i = 0; i < truck_weights.length; i++) {
			q_wait.add(truck_weights[i]);
		}
		/* 다리위에도 트럭이 없고, 대기열에도 트럭이 없을 때까지 무한루프 */
		while (!q_wait.isEmpty() || !q_bridge.isEmpty()) {
			/* 루프 한번당 1초 */
			totalTime++;
			/* 1초가 지나면 다리위에 있는 트럭이 머무를 수 있는 시간 1초 감소 */
			for (int i = 0; i < list_bridge.size(); i++) {
				list_bridge.set(i, list_bridge.get(i) - 1);
			}
			/* 맨 앞에있는 트럭이 머무를 수 있는 시간이 0초가 되면 다리 밖으로 빼주고, 리스트, 큐에서 제거 */
			while (!list_bridge.isEmpty()) {
				if (list_bridge.get(0) != 0) {
					break;
				}
				list_bridge.remove(0);
				weightOnBridge -= q_bridge.poll();
			}
			/* 다리위에 트럭이 있는데 대기열에 트럭이 없을 때 널포인트익셉션 뜨는 상황 방지 */
			if (!q_wait.isEmpty()) {
				/* 다리위에 트럭의 총 무게가 감당할 수 있어야 다리에 트럭올림, 아니면 else로 빠져서 아무것도 안하고 시간만 증가 */
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
