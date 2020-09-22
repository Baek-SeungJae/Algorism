package programmers.level1;

import java.util.Arrays;
import java.util.HashSet;

public class Programmers_68644 {
	public static void main(String[] args) {
		int[] numbers = {5,0,7,2};
		int[] ans = solution(numbers);
		for(int i=0; i<ans.length; i++) {
			System.out.println(ans[i]);
		}
	}

	public static int[] solution(int[] numbers) {
		HashSet<Integer> set = new HashSet<>();
		
		for(int i=0; i< numbers.length-1; i++) {
			for(int j= i+1; j< numbers.length; j++) {
				set.add(numbers[i]+numbers[j]);
			}
		}
        int[] answer = new int[set.size()];
        int index = 0;
        for (int i : set) {
			answer[index++] = i;
		}
        Arrays.sort(answer);
        return answer;
    }
}