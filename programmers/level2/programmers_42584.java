package programmers.level2;

public class programmers_42584 {
	public static void main(String[] args) {
		int[] prices = new int[] { 1, 2, 1, 2, 3 };
		int[] priced = new int[] { 5, 4, 3, 1, 1, 0 };
		solution(prices);
	}
	public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		for (int i = 0; i < prices.length; i++) {
			answer[i] = 1;
			for (int j = i + 1; j < prices.length - 1; j++) {
				if (prices[i] <= prices[j]) {
					answer[i]++;
				} else {
					break;
				}
			}
		}
		answer[prices.length - 1] = 0;
		return answer;
	}

}