package programmers;

import java.util.ArrayList;
import java.util.HashMap;

public class Programmers_17678 {
	public static void main(String[] args) {
		int n = 2; // ���� Ƚ��
		int t = 10; // ���� ����
		int m = 2; // �����
		String[] timetable = { "09:10", "09:09", "08:00" }; // ������� ���� �ð�

		solution(n, t, m, timetable);
	}

	public static String solution(int n, int t, int m, String[] timetable) {
		ArrayList<Integer> crewtime = new ArrayList<Integer>();// ������� �����ð�

		HashMap<Integer, Integer> bustime = new HashMap<Integer, Integer>();
		int[] bustemp = new int[n];
		int lastbus = 0;
		// ���������ð� �ʱ�ȭ
		for (int i = 0; i < n; i++) {
			bustime.put(int2int(0, 540 + (i * t)), 0);
			bustemp[i] = int2int(0, 540 + (i * t));
			System.out.print(int2int(0, 540 + (i * t)) + " ");
			System.out.println(bustime.get(int2int(0, 540 + (i * t))));
			lastbus = bustemp[i];
		}
		int lastcrew = 900;
		System.out.println("�����ð� : " + lastbus);

		// �°��ʱ�ȭ
		for (int i = 0; i < timetable.length; i++) {
			if (str2int(timetable[i]) <= lastbus) {
				crewtime.add(str2int(timetable[i]));
			}
		}
		crewtime.sort(null);
		System.out.println("======������ Ż �� �ִ� �ð��� ������ �°� =======");
		for (int i = 0; i < crewtime.size(); i++) {
			System.out.println(crewtime.get(i));
		}

		System.out.println("======������ ========");

		if (crewtime.size() != 0)
			lastcrew = crewtime.get(crewtime.size() - 1);
		for (int i = 0; i < bustemp.length; i++) {
			for (int j = 0; j < crewtime.size(); j++) {
				if (bustime.get(bustemp[i]) < m) {
					if (bustemp[i] >= crewtime.get(j)) {
						System.out.println(bustemp[i] + "," + bustime.get(bustemp[i]) + "," + crewtime.get(j));
						bustime.put(bustemp[i], bustime.get(bustemp[i]) + 1);
						lastcrew = crewtime.get(j);
						crewtime.set(j, 2400);
					}
				} else {
					break;
				}
			}
		}

		String answer;
		if (bustime.get(lastbus) < m)
			answer = int2str(lastbus);
		else
			answer = int2str(int2int(lastcrew, -1));

		System.out.println("����������:" + lastbus);
		System.out.println("�������°�:" + lastcrew);
		System.out.println("����:" + answer);
		return answer;
	}

	public static int int2int(int time, int interval) {
		int hour = time / 100;
		int minute = time % 100;
		minute += interval;
		if (minute >= 60) {
			hour += minute / 60;
			minute = minute % 60;
		}
		if (minute < 0) {
			hour -= 1;
			minute = 59;
		}
		return hour * 100 + minute;
	}

	public static int str2int(String time) {
		int hour = Integer.parseInt(time.split(":")[0]);
		int minute = Integer.parseInt(time.split(":")[1]);
		return hour * 100 + minute;
	}

	public static String int2str(int time) {
		String hour;
		String minute;
		if (time / 100 < 10) {
			hour = "0" + (time / 100);
		} else {
			hour = "" + (time / 100);
		}
		if (time % 100 < 10) {
			minute = "0" + (time % 100);
		} else {
			minute = "" + (time % 100);
		}
		return hour + ":" + minute;
	}
}