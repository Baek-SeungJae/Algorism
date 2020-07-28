package dally;

import java.util.ArrayList;

public class O20200726 {
	public static void main(String[] args) {
		int[] list = {3,-5,1,-1,5,1,2,3};
		System.out.println(solution(list));
	}
	public static ArrayList<Integer> solution(int[] list) {
		ArrayList<Integer> al = new ArrayList<>();
		int[] sum = new int[list.length];
		for(int i=0; i< list.length; i++) {
			al.add(list[i]);
			for(int j=0; j<=i;j++) {
				sum[j]+=list[i];
				if(sum[j]==0) {
					for(int k=j; k<=i;k++) {
						al.remove(Integer.valueOf(list[k]));
					}
				}
			}
		}
		return al;
	}
}