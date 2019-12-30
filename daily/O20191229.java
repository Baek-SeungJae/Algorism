package daily;

import java.util.ArrayList;

public class O20191229 {

	public static void main(String[] args) {
		int[] input = {3, 0, 3};
		int inputsizefirst = input.length;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i=0; i<input.length; i++) {
			arr.add(input[i]);
		}
		while((arr.indexOf(0))>=0) {
			arr.remove(arr.indexOf(0));
		}
		int inputsizelast = arr.size();
		
		for(int i=0; i<inputsizefirst-inputsizelast; i++)
			arr.add(0);
		
		for(int i=0; i<arr.size();i++) {
			System.out.println(arr.get(i));
		}
	}

}
