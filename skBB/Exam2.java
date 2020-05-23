package skBB;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

public class Exam2 {

	public static void main(String[] args) {
		String[] companey = new String[] { "warehouse", "parkworld", "eggandbacon", "xyz", "hellomark", "olive" };
		int[][] scores = new int[][] { { 74, 76, 65, 90, 75 }, { 95, 70, 85, 60, 65 }, { 75, 75, 75, 75, 80 },
				{ 90, 100, 85, 75, 70 }, { 100, 79, 100, 70, 79 }, { 70, 71, 100, 80, 39 } };
		solution(companey, scores);
	}

	public static String[] solution(String[] company_names, int[][] scores) {
		HashMap<String, Integer> overeighty = new HashMap<>();
		HashMap<String, Integer> total = new HashMap<>();
		for (int i = 0; i < company_names.length; i++) {
			int count = 0;
			int tot = 0;
			for (int j = 0; j < scores[i].length; j++) {
				if (scores[i][j] >= 80) {
					count++;
				}
				tot += scores[i][j];
			}
			overeighty.put(company_names[i], count);
			total.put(company_names[i], tot);
		}

		TreeMap<Integer,String> one = new TreeMap<>(Comparator.reverseOrder());
		TreeMap<Integer,String> two = new TreeMap<>(Comparator.reverseOrder());
		TreeMap<Integer,String> three = new TreeMap<>(Comparator.reverseOrder());
		TreeMap<Integer,String> four = new TreeMap<>(Comparator.reverseOrder());
		TreeMap<Integer,String> five = new TreeMap<>(Comparator.reverseOrder());
		
		for (String str : overeighty.keySet()) {
			int i = overeighty.get(str);
			int k = total.get(str);
			switch (i) {
			case 1:
				if(one.containsKey(k)) {
					if(one.get(k).charAt(0)<str.charAt(0))
						one.put(k+1, str);
					else
						one.put(k-1, str);
				} else
				one.put(k,str);
				break;
			case 2:
				if(two.containsKey(k)) {
					if(two.get(k).charAt(0)<str.charAt(0))
						two.put(k+1, str);
					else
						two.put(k-1, str);
				} else
				two.put(k,str);
				break;
			case 3:
				if(three.containsKey(k)) {
					if(three.get(k).charAt(0)<str.charAt(0))
						three.put(k+1, str);
					else
						three.put(k-1, str);
				} else
				three.put(k,str);
				break;
			case 4:
				if(four.containsKey(k)) {
					if(four.get(k).charAt(0)<str.charAt(0))
						four.put(k+1, str);
					else
						four.put(k-1, str);
				} else
				four.put(k,str);
				break;
			case 5:
				if(five.containsKey(k)) {
					if(five.get(k).charAt(0)<str.charAt(0))
						five.put(k+1, str);
					else
						five.put(k-1, str);
				} else
				five.put(k,str);
				break;
			}
		}
		ArrayList<String> arr = new ArrayList<>();
		for (Integer i : five.keySet()) {
			arr.add(five.get(i));
		}
		for (Integer i : four.keySet()) {
			arr.add(four.get(i));
		}
		for (Integer i : three.keySet()) {
			arr.add(three.get(i));
		}
		for (Integer i : two.keySet()) {
			arr.add(two.get(i));
		}
		for (Integer i : one.keySet()) {
			arr.add(one.get(i));
		}
		String[] answer = new String[arr.size()];
		System.out.println(arr);
		for(int i=0; i<arr.size();i++) {
			answer[i] = arr.get(i);
		}
		return answer;
	}

}
