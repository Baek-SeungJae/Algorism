package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class programmers_64605 {

	public static void main(String[] args) {
		String s1 = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		String s2 = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
		String s3 = "{{20,111},{111}}";
		String s4 = "{{123}}";
		String s5 = "{{4,2,3},{3},{2,3,4,1},{2,3}}";

		print(solution(s1));
		print(solution(s2));
		print(solution(s3));
		print(solution(s4));
		print(solution(s5));

	}

	public static int[] solution(String s) {
		String[] strArr = s.split("},");
		for(int i=0; i< strArr.length; i++){
			strArr[i] = strArr[i].replaceAll("[^0-9,]","");
		}
		Arrays.sort(strArr, comp1);

		List<String> tuple = new ArrayList<>();

		for(int i=0; i< strArr.length; i++){
			String[] temp = strArr[i].split(",");
			for(int j=0; j< temp.length; j++){
				if(!tuple.contains(temp[j])){
					tuple.add(temp[j]);
				}
			}
		}

		int[] answer = new int[tuple.size()];
		for(int i=0; i< answer.length; i++){
			answer[i] = Integer.parseInt(tuple.get(i));
		}
		return answer;
	}

	static Comparator<String> comp1 = new Comparator<String>() {

		@Override
		public int compare(String o1, String o2) {
			if(o1.split(",").length >= o2.split(",").length){
				return 1;
			} else {
				return -1;
			}
		}
	};


	public static void print(int[] arr){
		for(int i=0; i< arr.length; i++){
			System.out.print(arr[i] +" ");
		}
		System.out.println();
	}
}
