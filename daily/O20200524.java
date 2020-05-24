package daily;

public class O20200524 {

	public static void main(String[] args) {
		int input = 6;

		System.out.println(solution(input));
	}

	public static int solution(int input) {
		int answer = 0;
		while (true) {

			if (input % 2 == 1) {
				answer++;
			} else {
			}
			if ((input == 0 || input == 1))
				break;
			input = input / 2;
		}
		
		return answer;
	}

}
