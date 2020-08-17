package programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;

public class programmers_42888 {
	public static void main(String[] args) {

		String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" };
		solution(record);

	}

	public static String[] solution(String[] record) {
		int recodesize = record.length;
		String[][] sentence = new String[recodesize][3];
		for (int i = 0; i < recodesize; i++) {
			sentence[i] = record[i].split(" ");
		}
		HashMap<String, String> id = new HashMap<String, String>();

		for (int i = 0; i < recodesize; i++) {
			if (sentence[i][0].equals("Enter")) {
				id.put(sentence[i][1], sentence[i][2]);
			} else if (sentence[i][0].equals("Change")) {
				id.put(sentence[i][1], sentence[i][2]);
			}
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < recodesize; i++) {
			if (sentence[i][0].equals("Enter")) {
				sb.append(id.get(sentence[i][1]));
				sb.append("´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.,");
			} else if (sentence[i][0].equals("Leave")) {
				sb.append(id.get(sentence[i][1]));
				sb.append("´ÔÀÌ ³ª°¬½À´Ï´Ù.,");
			}
		}
		return sb.toString().split(",");
	}
}