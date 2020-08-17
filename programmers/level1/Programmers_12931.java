package programmers.level1;

public class Programmers_12931 {
	public static void main(String[] args) {
		long n = 987;
		System.out.println(solution(n));
	}

	public static int[] solution(long n) {
		
		char[] ch = (new StringBuffer(n+"").reverse().toString()).toCharArray();
		
		int[] answer = new int[ch.length];
		for(int i=0; i<ch.length; i++) {
			answer[i] = Integer.parseInt(ch[i]+"");
		}
		
		return answer;
	}
}