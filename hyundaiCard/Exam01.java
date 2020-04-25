package hyundaiCard;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * 1월 1일 ~ 1월 19일은 브론즈 등급입니다.(19일)
1월 20일 ~ 1월 30일은 골드 등급입니다.(11일)
1월 31일 ~ 2월 8일은 실버 등급입니다. (9일)
2월 9일 ~ 2월 18일은 다이아 등급입니다. (10일)
2월 19일 ~ 3월 10일은 플래티넘 등급입니다. (20일)
3월 11일 ~ 12월 31일은 브론즈 등급입니다. (296일)
 */
public class Exam01 {
	public static void main(String[] args) {
		String[] purchase = new String[] { "2019/01/30 5000", "2019/04/05 10000", "2019/06/10 20000", "2019/08/15 50000", "2019/12/01 100000" };

		int[] answer = solution(purchase);
		for (int i = 0; i < answer.length; i++)
			System.out.println(answer[i]);

	}

	public static int[] solution(String[] purchase) {
		int b = 0;
		int s = 0;
		int g = 0;
		int f = 0;
		int d = 0;
		int[] day = new int[366];
		int max = 0;
		for (int i = 0; i < purchase.length; i++) {
			String[] temp = purchase[i].split(" ");
			if (max > String2Day(temp[0]) + 30)
				max = 366;
			else
				max = String2Day(temp[0]) + 30;

			for (int j = String2Day(temp[0]); j < max; j++) {
				day[j] = day[j] + Integer.parseInt(temp[1]);
			}
		}
		for (int i = 1; i < day.length; i++) {
			if (day[i] >= 0 && 10000 > day[i])
				b++;
			if (day[i] >= 10000 && 20000 > day[i])
				s++;
			if (day[i] >= 20000 && 50000 > day[i])
				g++;
			if (day[i] >= 50000 && 100000 > day[i])
				f++;
			if (day[i] >= 100000)
				d++;
		}

		int[] answer = new int[] { b, s, g, f, d };
		return answer;
	}

	public static String Day2String(int day) {
		int month = 0;
		for (int i = 1; i <= 12; i++) {
			if (day - month2().get(i) <= 0) {
				month = i;
				break;
			}
		}

		return "";
	}

	public static int String2Day(String day1) {
		String[] day1arr = day1.split("/");
		int day = 31 - month().get(Integer.parseInt(day1arr[1])) + Integer.parseInt(day1arr[2]);

		return day;
	}

	public static HashMap<Integer, Integer> month() {
		HashMap<Integer, Integer> month = new HashMap<Integer, Integer>();
		month.put(1, 31);
		month.put(2, month.get(1) - 31);
		month.put(3, month.get(2) - 28);
		month.put(4, month.get(3) - 31);
		month.put(5, month.get(4) - 30);
		month.put(6, month.get(5) - 31);
		month.put(7, month.get(6) - 30);
		month.put(8, month.get(7) - 31);
		month.put(9, month.get(8) - 31);
		month.put(10, month.get(9) - 30);
		month.put(11, month.get(10) - 31);
		month.put(12, month.get(11));
		return month;
	}

	public static HashMap<Integer, Integer> month2() {
		HashMap<Integer, Integer> month = new HashMap<Integer, Integer>();
		month.put(1, 31);
		month.put(2, month.get(1) + 29);
		month.put(3, month.get(2) + 31);
		month.put(4, month.get(3) + 30);
		month.put(5, month.get(4) + 31);
		month.put(6, month.get(5) + 30);
		month.put(7, month.get(6) + 31);
		month.put(8, month.get(7) + 31);
		month.put(9, month.get(8) + 30);
		month.put(10, month.get(9) + 31);
		month.put(11, month.get(10) + 30);
		month.put(12, month.get(11) + 31);
		return month;
	}
}
