package programmers;

import java.util.Comparator;
import java.util.TreeMap;

public class Programmers_42746 {
	public static void main(String[] args) {
		int[] answer = new int[] { 10, 11, 1, 2, 3, 4, 5, 6, 7, 8, 9, 100, 10101, 101010 };
		System.out.println(solution(answer));

	}

	public static String solution(int[] numbers) {
		TreeMap<String, Integer> tm = new TreeMap<String, Integer>(Comparator.reverseOrder());
		for (int i = 0; i < numbers.length; i++) {
			String temp = String.valueOf(numbers[i]);
			int k=0;
			while (true) {
				if (temp.length() >= 4) {
					break;
				}
				temp = temp+temp.charAt(k);
				k++;
			}
			
			while(true) {
				if(tm.get(temp)!=null) {
					temp = temp+'a';
				} else {
					break;
				}
			}
			
			tm.put(temp, numbers[i]);
		}
		
		StringBuffer sb = new StringBuffer();
		for (String i : tm.keySet()) {
			sb.append(tm.get(i));
		}
		try {
		if(Long.parseLong(sb.toString())==0) {
			sb=new StringBuffer("0");
		}
		}catch(NumberFormatException e) {
			
		}
		return sb.toString();
	}
}