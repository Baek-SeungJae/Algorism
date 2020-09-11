package programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class programmers_42890 {
	public static void main(String[] args) {

		/*String[][] relation = { { "100", "ryan", "music", "2" }, { "200", "apeach", "math", "2" },
				{ "300", "tube", "computer", "3" }, { "400", "con", "computer", "4" }, { "500", "muzi", "music", "3" },
				{ "600", "apeach", "music", "2" } };*/
		/*String[][] relation = {{"a","b","c"},
			{"1","b","c"},
			{"a","b","4"},
			{"a","5","c"}};
		*/
		String[][] relation = {{"b","2","a","a","b"},
				{"b","2","7","1","b"},
				{"1","0","a","a","8"},
				{"7","5","a","a","9"},
				{"3","0","a","f","9"}};
			
		System.out.println(solution(relation));
		// solution(relation);
	}

	public static int MAX;

	public static ArrayList<int[]> al;

	public static int solution(String[][] relation) {
		int answer = 0;
		MAX = relation.length;
		al = new ArrayList<>();
		HashMap<String, Integer> check_MAX = new HashMap<String, Integer>();
		HashSet<String> set = new HashSet<String>();
		for (int i = 0; i < relation[0].length; i++) {
			int[] comArr = new int[i + 1];
			combination(comArr, relation[0].length, i + 1, 0, 0);
		}
		
		for (int i = 0; i < al.size(); i++) {
			int[] temp = al.get(i);
			for (int j : temp) {
				System.out.print(j);
			}
			String key = "";
			for (int j = 0; j < MAX; j++) {
				String str = "";
				for (int temp_i = 0; temp_i < temp.length; temp_i++) {
					str += relation[j][temp[temp_i]]+",";
					if(j==0)
						key += temp[temp_i];
				}
				set.add(str);
			}
			if(set.size()==MAX) {
				check_MAX.put(key,MAX);
				answer ++;
			}
			set.clear();
		}
		Set<String> compareSet = ((HashMap<String, Integer>) check_MAX.clone()).keySet();
		Set<String> removeSet = ((HashMap<String, Integer>) check_MAX.clone()).keySet();
		System.out.println(check_MAX);
		for (String string : removeSet) {
			for (String string2 : compareSet) {
				if(!string.equals(string2)) {
					boolean check = true;
					for (char ch : string.toCharArray()) {
						check = check && string2.contains(ch+"");
					}
					if(check) {
						check_MAX.remove(string2);
					}
				}
			}
		}
		System.out.println(check_MAX);
		answer = check_MAX.size();
		return answer;
	}

	private static void combination(int[] comArr, int n, int r, int index, int target) {

		if (r == 0) {
			int[] copy = comArr.clone();
			al.add(copy);
			return;
		}
		if (target == n)
			return;

		comArr[index] = target;
		combination(comArr, n, r - 1, index + 1, target + 1);// 뽑는경우
		combination(comArr, n, r, index, target + 1);// 안뽑는경우

	}
}