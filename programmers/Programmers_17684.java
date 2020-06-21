package programmers;

import java.util.ArrayList;
import java.util.HashMap;

public class Programmers_17684 {
	public static void main(String[] args) {
		String msg = "ABABABABABABABAB";

		solution(msg);
	}

	public static int[] solution(String msg) {
		// 변수선언, 초기화
		HashMap<String, Integer> dict = new HashMap<String, Integer>();
		ArrayList<Integer> al = new ArrayList<>();
		dictInit(dict);
		msg += " ";
		char[] charArr = msg.toCharArray();
		StringBuffer sb = new StringBuffer("");
		int dictIndex = 27;
		
		// 로직작성 - char변수를 더하면서 Map에서 검색 -> 검색 실패하면 사전에 추가하고 1자리 빼서 인덱스를 arrayList에 추가, for문 한칸 되돌아가서 다시시작 -> 마지막 indexOut때문에 msg에 공백1칸추가
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
		
		// 답안작성
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