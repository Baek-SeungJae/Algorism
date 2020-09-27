package daily;

import java.util.HashSet;

public class O20200906 {
	public static void main(String[] args) {
		int N = 5;
		solution(N);
	}

	public static void solution(int N) {
		HashSet<String> set = new HashSet<>();
		recursion(0,N,0,"",set);
		for (String string : set) {
			System.out.println(string);
		}
	}
	
	public static void recursion (int idx, int N, int current, String str, HashSet<String> set) {
		if(idx==N) {
			set.add(str);
			return;
		}
		
		if(current==1) {
			recursion(idx+1, N, 0, str+0,set);
		} else {
			recursion(idx+1, N, 0, str+0,set);
			recursion(idx+1, N, 1, str+1,set);
		}
	}
}