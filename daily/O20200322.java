package daily;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

public class O20200322 {
	public static void main(String[] args) {
		int[] input = { 3, 1, 5, 6 };
		TreeMap<Integer, Integer> inputMap = new TreeMap<Integer, Integer>();
		TreeSet<Integer> inputSet = new TreeSet<Integer>();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < input.length; i++) {
			inputMap.put(input[i], input[i]);
			inputSet.add(input[i]);
			arr.add(input[i]);
		}
		
		System.out.println(inputMap);
		System.out.println(inputSet);
		System.out.println(arr);
	}
}