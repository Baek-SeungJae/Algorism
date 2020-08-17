package programmers.level2;

import java.util.ArrayList;
import java.util.TreeMap;

public class programmers_17686 {

	public static void main(String[] args) {
		String[] files = new String[] { "a1", "a01" };
		solution(files);
	}

	public static String[] solution(String[] files) {

		TreeMap<String, TreeMap<Integer, ArrayList<String>>> tm = new TreeMap<>();
		String head = "";
		Integer number = 0;
		String tail = "";
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < files.length; i++) {
			int j = 0;
			while (!(files[i].charAt(j) >= 48 && files[i].charAt(j) <= 57)) {
				sb.append(files[i].charAt(j));
				j++;
			}
			head = sb.toString();
			sb = new StringBuilder("");
			while ((files[i].charAt(j) >= 48 && files[i].charAt(j) <= 57)) {
				sb.append(files[i].charAt(j));
				j++;
				if(files[i].length()<=j) {
					break;
				}
			}
			number = Integer.parseInt(sb.toString());
			sb = new StringBuilder("");
			tail = files[i].substring(j);
			System.out.println(head + " " + number + " " + tail);

			head = head.toUpperCase();
			tail = tail.toUpperCase();
			if (tm.getOrDefault(head, null) == null) {
				tm.put(head, new TreeMap<Integer, ArrayList<String>>());
				if (tm.get(head).getOrDefault(number, null) == null) {
					tm.get(head).put(number, new ArrayList<String>());
					tm.get(head).get(number).add(files[i]);
				} else {
					tm.get(head).get(number).add(files[i]);
				}
			} else {
				if (tm.get(head).getOrDefault(number, null) == null) {
					tm.get(head).put(number, new ArrayList<String>());
					tm.get(head).get(number).add(files[i]);
				} else {
					tm.get(head).get(number).add(files[i]);
				}
			}
		}
		System.out.println(tm);
		String[] answer = new String[files.length];
		int index = 0;
		for (String h : tm.keySet()) {
			for (Integer n : tm.get(h).keySet()) {
				for (int i = 0; i < tm.get(h).get(n).size(); i++) {
					answer[index] = tm.get(h).get(n).get(i);
					index++;
				}
			}
		}
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
		return answer;
	}
}
