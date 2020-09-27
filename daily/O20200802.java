package daily;

import java.util.Stack;

public class O20200802 {
	public static void main(String[] args) {
		int N = 10;
		solution(N);
	}

	public static void solution(int N) {
		System.out.println("1");
		Stack<Character> st = new Stack<>();
		String tempStr = "1";
		for (int i = 0; i < N-1; i++) {
			StringBuilder sb = new StringBuilder("");
			st.add(tempStr.charAt(0));
			for (int j = 1; j < tempStr.length(); j++) {
				if(st.peek()==tempStr.charAt(j)) {
					st.add(tempStr.charAt(j));
				}else {
					sb.append(st.size());
					sb.append(st.peek());
					st.clear();
					st.add(tempStr.charAt(j));
				}
			}
			if(!st.isEmpty()) {
				sb.append(st.size());
				sb.append(st.peek());
				st.clear();
			}
			tempStr = sb.toString();
			System.out.println(tempStr);
		}

	}
}