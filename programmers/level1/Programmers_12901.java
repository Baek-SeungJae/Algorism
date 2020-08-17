package programmers.level1;

public class Programmers_12901 {

	public static void main(String[] args) {
		int a = 5;
		int b = 24;
		solution(a, b);
	}

	public static String solution(int a, int b) {
		String answer = "";
		int day =0;
		String[] week = new String[] {"MON","TUE","WED","THU","FRI","SAT","SUN"};
		int[] month = {0,31,29,31,30,31,30,31,31,30,31,30,31};
		for(int i=1; i<a; i++) {
			day += month[i];
		}
		day += b;
		day += 3;
		day = day%7;
		answer = week[day];
		System.out.println(answer);
		return answer;
	}

}
