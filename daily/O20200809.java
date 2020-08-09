package dally;

import java.util.ArrayList;

public class O20200809 {
	public static void main(String[] args) {
		int[] array = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
		solution(array);
	}

	public static void solution(int[] array) {
		BSTree<Integer> tree = new BSTree<Integer>();
		ArrayList<Integer> list = new ArrayList<>();
		list.add(array.length/2);
		for(int i = 2; i<=4; i++) {
			ArrayList<Integer> tempList = new ArrayList<>();
			tempList.add((int)Math.ceil(array.length/Math.pow(2,i)));
			for(int j=0; j<list.size();j++) {
				tempList.add(list.get(j)+(int)Math.ceil(array.length/Math.pow(2,i)));
			}
			list.addAll(tempList);
		}
		list.add(array[0]);
		for(int i=0; i< array.length;i++) {
			tree.insert(list.get(i));
		}
		
		tree.print();
	}
}