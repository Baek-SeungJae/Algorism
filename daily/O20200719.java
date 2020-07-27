package dally;

import java.util.Random;

public class O20200719 {
	public static void main(String[] args) {
		int N = 100;
		System.out.println(solution(N));
	}
	public static int solution(int N) {
		int answer = 0;
		int[] array = new int[N-1];
		int random = new Random().nextInt(N);
		System.out.println("random : " + random);
		
		for(int i = 0; i<N-1; i++) {
			if(i<random) {
			array[i] = i;
			} else {
				array[i]=i+1;
			}
		}
		
		for(int i = 1; i< N-1; i++) {
			if(array[i]-array[i-1]!=1) {
				answer = i;
			}
		}
		
		return answer;
	}
}