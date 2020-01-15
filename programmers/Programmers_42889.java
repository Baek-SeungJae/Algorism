package programmers;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;

public class Programmers_42889 {
	public static void main(String[] args) {

		int N = 5;
		int[] stages = new int[] { 2, 1, 2, 6, 2, 4, 3, 3 };
		solution(N, stages);

	}

	public static int[] solution(int N, int[] stages) {
		HashMap<Integer, Integer> tryCount = new HashMap<>();
		HashMap<Integer, Integer> successCount = new HashMap<>();

		// 시도횟수 구하기
		for (int i = 0; i < stages.length; i++) {
			tryCount.put(stages[i], tryCount.getOrDefault(stages[i], 0)+1);
		}
		successCount = (HashMap<Integer, Integer>) tryCount.clone();
		for(int i=N; i>0; i--) {
			tryCount.put(i,tryCount.getOrDefault(i+1, 0)+tryCount.getOrDefault(i, 0));
		}
		tryCount.remove(N+1);
		//System.out.println(tryCount);
		
		// 성공횟수 구하기
		for (int i : tryCount.keySet()) {
			successCount.put(i, tryCount.getOrDefault(i, 0)-successCount.getOrDefault(i, 0));
		}
		successCount.remove(N+1);
		//System.out.println(successCount);
		
		// 성공확률 구하기 + 자릿수고정 + index붙이기
		String[] percent = new String[successCount.size()];
		for(int i=0; i<N; i++) {
			double temp = (double)successCount.get(i+1)/tryCount.get(i+1);
			DecimalFormat format = new DecimalFormat();
			format.applyPattern("0.00000000000");
			DecimalFormat format2 = new DecimalFormat();
			format2.applyPattern("000");
			percent[i] = format.format(temp)+","+format2.format(i+1);
		}
		Arrays.sort(percent);
		
		//답안 만들기
		int[] answer = new int[percent.length];
		for(int i=0; i<answer.length; i++) {
			answer[i] = Integer.parseInt(percent[i].split(",")[1]);
			
		}
		return answer;
	}
}