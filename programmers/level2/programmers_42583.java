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

		/* ?‹¤ë¦¬ìœ„?— ?˜¬?¼ê°??ˆ?Š” ?Š¸?Ÿ­?˜ ë¬´ê²Œ */
		int weightOnBridge = 0;
		/* ì´? ê±¸ë¦° ?‹œê°?*/
		int totalTime = 0;
		
		/* ?•„ì§? ì¶œë°œ ?•ˆ?•œ ?Š¸?Ÿ­ ??ê¸°ì—´ */
		Queue<Integer> q_wait = new LinkedList<Integer>();
		/* ?‹¤ë¦? ?œ„ ?Š¸?Ÿ­ */
		Queue<Integer> q_bridge = new LinkedList<Integer>();
		/* ?‹¤ë¦¬ìœ„?— ?ˆ?Š” ?Š¸?Ÿ­?´ ë¨¸ë¬´ë¥? ?ˆ˜ ?ˆ?Š” ?‹œê°? */
		List<Integer> list_bridge = new ArrayList<Integer>();
		/* ë°°ì—´?„ ??— ???¥ */
		for (int i = 0; i < truck_weights.length; i++) {
			q_wait.add(truck_weights[i]);
		}
		/* ?‹¤ë¦¬ìœ„?—?„ ?Š¸?Ÿ­?´ ?—†ê³?, ??ê¸°ì—´?—?„ ?Š¸?Ÿ­?´ ?—†?„ ?•Œê¹Œì? ë¬´í•œë£¨í”„ */
		while (!q_wait.isEmpty() || !q_bridge.isEmpty()) {
			/* ë£¨í”„ ?•œë²ˆë‹¹ 1ì´? */
			totalTime++;
			/* 1ì´ˆê? ì§??‚˜ë©? ?‹¤ë¦¬ìœ„?— ?ˆ?Š” ?Š¸?Ÿ­?´ ë¨¸ë¬´ë¥? ?ˆ˜ ?ˆ?Š” ?‹œê°? 1ì´? ê°ì†Œ */
			for (int i = 0; i < list_bridge.size(); i++) {
				list_bridge.set(i, list_bridge.get(i) - 1);
			}
			/* ë§? ?•?—?ˆ?Š” ?Š¸?Ÿ­?´ ë¨¸ë¬´ë¥? ?ˆ˜ ?ˆ?Š” ?‹œê°„ì´ 0ì´ˆê? ?˜ë©? ?‹¤ë¦? ë°–ìœ¼ë¡? ë¹¼ì£¼ê³?, ë¦¬ìŠ¤?Š¸, ??—?„œ ? œê±? */
			while (!list_bridge.isEmpty()) {
				if (list_bridge.get(0) != 0) {
					break;
				}
				list_bridge.remove(0);
				weightOnBridge -= q_bridge.poll();
			}
			/* ?‹¤ë¦¬ìœ„?— ?Š¸?Ÿ­?´ ?ˆ?Š”?° ??ê¸°ì—´?— ?Š¸?Ÿ­?´ ?—†?„ ?•Œ ?„?¬?¸?Š¸?µ?…‰?…˜ ?œ¨?Š” ?ƒ?™© ë°©ì? */
			if (!q_wait.isEmpty()) {
				/* ?‹¤ë¦¬ìœ„?— ?Š¸?Ÿ­?˜ ì´? ë¬´ê²Œê°? ê°ë‹¹?•  ?ˆ˜ ?ˆ?–´?•¼ ?‹¤ë¦¬ì— ?Š¸?Ÿ­?˜¬ë¦?, ?•„?‹ˆë©? elseë¡? ë¹ ì ¸?„œ ?•„ë¬´ê²ƒ?„ ?•ˆ?•˜ê³? ?‹œê°„ë§Œ ì¦ê? */
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
