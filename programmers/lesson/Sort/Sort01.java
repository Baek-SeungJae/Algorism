package programmers.lesson.Sort;

import java.util.ArrayList;

public class Sort01 {

	public static void main(String[] args) {
		int[] array = new int[] { 4, 5, 2, 6, 3, 7, 1 };
		int[][] commands = new int[][] { { 2, 5, 3 },  { 1, 7, 3 } , { 4, 4, 1 } };
		int[] result = solution(array, commands);
		for(int i=0; i<result.length; i++)
			System.out.println(result[i]);
	}

	public static int[] solution(int[] array, int[][] commands) {
		ArrayList<Integer> list = new ArrayList<Integer>(array.length);
		int[] answer = new int[commands.length];
		for (int i = 0; i < commands.length; i++) {
			for (int j = commands[i][0] - 1; j < commands[i][1]; j++) {
				list.add(array[j]);
			}
			System.out.println(list);
			list.sort(null);
			answer[i] = list.get(commands[i][2] - 1);
			list.clear();
		}
		return answer;
	}
	
}
