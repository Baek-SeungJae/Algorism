package programmers;

public class Programmers_42862 {

	public static void main(String[] args) {
		int n = 5;
		int[] lost = new int[] { 1 };
		int[] reserve = new int[] { 1,5 };
		System.out.println(solution(n, lost, reserve));
	}

	public static int solution(int n, int[] lost, int[] reserve) {
		StringBuffer sb = new StringBuffer("");
		
		char[] ch = new char[n];
		for (int i = 0; i < n; i++) {
			ch[i] = 'a';
		}
		for (int i = 0; i < lost.length; i++) {
			ch[lost[i] - 1] = 'x';
		}
		for (int i = 0; i < reserve.length; i++) {
			if(ch[reserve[i] - 1] == 'x') {
				ch[reserve[i] - 1] = 'a';
			} else{
				ch[reserve[i] - 1] = 'o';
			}
		}
		System.out.println(sb.append(ch));
		sb = new StringBuffer("");
		
		
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				if (ch[i] == 'x') {
					if (ch[i + 1] == 'o') {
						ch[i] = 'a';
						ch[i + 1] = 'a';
					}
				}
			} else if (i == n - 1) {
				if (ch[i] == 'x') {
					if (ch[i - 1] == 'o') {
						ch[i] = 'a';
						ch[i - 1] = 'a';
					}
				}
			} else {
				if (ch[i] == 'x') {
					if (ch[i - 1] == 'o') {
						ch[i] = 'a';
						ch[i - 1] = 'a';
					} else if (ch[i + 1] == 'o') {
						ch[i] = 'a';
						ch[i + 1] = 'a';
					}
				}
			}

		}
		System.out.println(sb.append(ch));
		int answer = 0;
		for (int i = 0; i < n; i++) {
			if (ch[i] == 'a' || ch[i] == 'o')
				answer++;
		}
		return answer;
	}
}
