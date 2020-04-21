package programmers.lesson.Hash;

import java.util.HashMap;

public class Hash02 {
	public static void main(String[] args) {
		String[] phone_book = new String[] { "123", "12", "789" };
		System.out.println(solution(phone_book));
	}

	public static boolean solution(String[] phone_book) {
		HashMap<String, String> map = new HashMap<String, String>();
		for (int j = 0; j < phone_book.length; j++) {
			map.put(phone_book[j], phone_book[j]);
		}
		boolean answer = true;
		for (int j = 0; j < phone_book.length; j++) {
			for (int i = 0; i < phone_book[j].length(); i++) {
				if (map.containsKey(phone_book[j].substring(0, i))) {
					answer = false;
				} else {
					map.put(phone_book[j], phone_book[j]);
				}
			}
		}

		return answer;
	}
}
