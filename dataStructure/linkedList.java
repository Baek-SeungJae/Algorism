package dataStructure;

import java.util.LinkedList;

public class linkedList {

	public static void main(String[] args) {
		LinkedList<String> ll = new LinkedList<String>();
		ll.add(0, "0번");
		ll.add(1, "1번");
		ll.add(2, "2번");
		ll.add(1, "3번");
		ll.remove("3번");
		//ll.remove();
		ll.remove(1);
		System.out.println(ll);
	}

}
