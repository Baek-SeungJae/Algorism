package programmers;

public class Programmers_12954 {
	public static void main(String[] args) {
		int x = 0;
		int n = 3;

		solution(x, n);

	}

	public static long[] solution(int x, int n) {
		long[] answer = new long[n];
        for(int i=0; i<n; i++) {
        	answer[i] = (long)x*(i+1);
        }
        return answer;
	}
}