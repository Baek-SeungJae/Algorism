package programmers.level3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class programmers_67258 {

	public static void main(String[] args) {
		String[] gems = { "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA" };
		solution(gems);
		String[] gems2 = { "AA", "AB", "AC", "AA", "AC" };
		solution(gems2);
		String[] gems3 = { "XYZ", "XYZ", "XYZ" };
		solution(gems3);
		String[] gems4 = { "ZZZ", "YYY", "NNNN", "YYY", "BBB" };
		solution(gems4);

	}

	public static int[] solution(String[] gems) {

		/* gems에서 중복 제거 */
		HashSet<String> set = new HashSet<>();
		HashSet<String> compareSet = new HashSet<>();
		for (int i = 0; i < gems.length; i++) {
			set.add(gems[i]);
		}
		int start = -1;
		int end = -1;
		int length = 1000000;
		int result_start = 0;
		int result_end = 0;
		while (true) {
			for (int i = start + 1; i < gems.length; i++) {
				if (!compareSet.contains(gems[i])) {
					compareSet.add(gems[i]);
				}
				if (compareSet.size() == set.size()) {
					end = i;
					break;
				}
			}
			if (end == 0 ) {
				break;
			}
			for (int i = end; i >= 0; i--) {
				if (compareSet.contains(gems[i])) {
					compareSet.remove(gems[i]);
				}
				if (compareSet.size() == 0) {
					start = i;
					break;
				}
			}

			if (length > (end - start)) {
				result_start = start;
				result_end = end;
				length = end - start;
			}

			compareSet.clear();
			end = 0;
		}
		System.out.println(result_start + 1 + "," + (result_end + 1));
		return new int[] { result_start + 1, result_end + 1 };
	}

}