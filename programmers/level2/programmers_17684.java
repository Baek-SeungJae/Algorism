package programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;

public class programmers_17684 {
	public static void main(String[] args) {
		String msg = "ABABABABABABABAB";

		solution(msg);
	}

	public static int[] solution(String msg) {
		// ë³??ˆ˜?„ ?–¸, ì´ˆê¸°?™”
		HashMap<String, Integer> dict = new HashMap<String, Integer>();
		ArrayList<Integer> al = new ArrayList<>();
		dictInit(dict);
		msg += " ";
		char[] charArr = msg.toCharArray();
		StringBuffer sb = new StringBuffer("");
		int dictIndex = 27;
		
		// ë¡œì§?‘?„± - charë³??ˆ˜ë¥? ?”?•˜ë©´ì„œ Map?—?„œ ê²??ƒ‰ -> ê²??ƒ‰ ?‹¤?Œ¨?•˜ë©? ?‚¬? „?— ì¶”ê??•˜ê³? 1?ë¦? ë¹¼ì„œ ?¸?±?Š¤ë¥? arrayList?— ì¶”ê?, forë¬? ?•œì¹? ?˜?Œ?•„ê°??„œ ?‹¤?‹œ?‹œ?‘ -> ë§ˆì?ë§? indexOut?•Œë¬¸ì— msg?— ê³µë°±1ì¹¸ì¶”ê°?
		for (int i = 0; i < charArr.length; i++) {
			sb.append(charArr[i]);
			if (dict.get(sb.toString()) == null) {
				dict.put(sb.toString(), dictIndex);
				dictIndex++;
				sb.delete(sb.length() - 1, sb.length());
				// System.out.println(dict.get(sb.toString()));
				if (dict.get(sb.toString()) != null)
					al.add(dict.get(sb.toString()));
				sb = new StringBuffer("");
				i--;
			}
		}
		
		// ?‹µ?•ˆ?‘?„±
		int[] answer = new int[al.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = al.get(i);
		}

		return answer;
	}

	public static void dictInit(HashMap<String, Integer> dict) {
		for (int i = 'A'; i <= 'Z'; i++)
			dict.put(String.valueOf((char) i), i - 64);
	}
}