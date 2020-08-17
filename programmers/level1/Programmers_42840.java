package programmers.level1;

import java.util.ArrayList;

public class Programmers_42840 {
	public static void main(String[] args) {
		int[] answer = new int[] { 1,3,2,4,2 };
		for(int i=0; i< solution(answer).length; i++) {
			System.out.println(solution(answer)[i]);
		}
		
		

	}

	public static int[] solution(int[] answers) {
		int[] a = new int[] { 1, 2, 3, 4, 5 };
		int[] b = new int[] { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] c = new int[] { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, };
		int counta = 0, countb = 0, countc = 0;
		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == a[i % a.length]) {
				counta++;
			}
			if (answers[i] == b[i % b.length]) {
				countb++;
			}
			if (answers[i] == c[i % c.length]) {
				countc++;
			}
		}
		int max = Integer.max(Integer.max(counta, countb),countc);
		ArrayList<Integer> al = new ArrayList<>();
		if(counta==max) {
			al.add(1);
		}
		if(countb==max) {
			al.add(2);
		}
		if(countc==max) {
			al.add(3);
		}
		int[] answer = new int[al.size()];
		for(int i=0; i<answer.length; i++) {
			answer[i] = al.get(i);
		}
		return answer;
	}
}