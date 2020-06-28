package programmers.levelTest;

import java.util.HashSet;

public class Level2_Exam1 {
	public static void main(String[] args) {
		int[][] baseball = { { 123, 1, 1 }, { 356, 1, 0 }, { 327, 2, 0 }, { 489, 0, 1 } };
		System.out.println(solution(baseball));
	}

	public static int solution(int[][] baseball) {
		HashSet<Integer> set = new HashSet<Integer>();
		int chk =0;
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				for (int k = 1; k < 10; k++) {
					if (i != j && i != k && j != k) {
						for(int n=0; n<baseball.length;n++) {
							String temp = count(baseball[n][0],(i * 100 + j * 10 + k));
							if(Integer.parseInt(temp.split(",")[0])==(baseball[n][1])&&Integer.parseInt(temp.split(",")[1])==(baseball[n][2])){
								chk++;
							}else {
								break;
							}
							if(chk==baseball.length&&chk!=0) {
								set.add((i * 100 + j * 10 + k));
								System.out.println((i * 100 + j * 10 + k));
								chk=0;
								break;
							}
						}
						chk=0;
					}
				}
			}
		}
		
		System.out.println(set.size());

		return set.size();
	}

	public static String count(int a, int b) {
		int ball = 0;
		int st = 0;
		if (a / 100 == b / 100)
			st++;
		if (a % 10 == b % 10)
			st++;
		if (a % 100 / 10 == b % 100 / 10)
			st++;
		
		
		if (a / 100 == b % 100 / 10)
			ball++;
		if (a / 100 == b % 10)
			ball++;
		
		if (a % 100 / 10 == b / 100)
			ball++;
		if (a % 100 / 10 == b % 10)
			ball++;
		
		if (a % 10 == b / 100)
			ball++;
		if (a % 10 == b % 100 / 10)
			ball++;
		
		

		return st + "," + ball;
	}

}
