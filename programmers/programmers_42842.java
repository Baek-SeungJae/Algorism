package programmers;

public class programmers_42842 {

	public static void main(String[] args) {
		int brown = 10;
		int yellow = 2;
		System.out.println(solution(brown, yellow)[0]);
		System.out.println(solution(brown, yellow)[1]);
	}

	public static int[] solution(int brown, int yellow) {
        int a = ((brown/2 + 2) + (int)Math.sqrt((brown/2 + 2)*(brown/2 + 2)-4*(brown+yellow)))/2;
        int b = ((brown/2 + 2) - (int)Math.sqrt((brown/2 + 2)*(brown/2 + 2)-4*(brown+yellow)))/2;
        int[] answer = {a,b};
        return answer;
    }
}
