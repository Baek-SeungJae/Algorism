package daily;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class O20200126 {
	public static void main(String[] args) {
		int array[] = {-1, 3, -1, 5, 4};
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0; i<array.length; i++) {
			set.add(array[i]);
		}
		ArrayList<Integer> list = new ArrayList<Integer>(set);
		Collections.sort(list);
		System.out.println(list.get(1));
		}
}
