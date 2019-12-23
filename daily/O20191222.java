package daily;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class O20191222 {

	public static void main(String[] args) {
		int[] input = {3,3,3};
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int i=0; i<input.length; i++) {
			set.add(input[i]);
		}
		ArrayList<Integer> arr = new ArrayList<Integer>(set);
		arr.sort(Collections.reverseOrder());
		
		if(arr.size()>=2)
			System.out.println(arr.get(1));
		else
			System.out.println("Does not exits.");
	}
}
