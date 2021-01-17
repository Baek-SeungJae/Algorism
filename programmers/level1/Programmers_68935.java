package programmers.level1;

public class Programmers_68935 {
	public static void main(String[] args) {
		int n1 = 45;
		int n2 = 125;
		System.out.println(solution(n1));
		System.out.println(solution(n2));
	}

	public static int solution(int n) {
		int answer = TriTodec(decToTri(n));
		return answer;
	}

	public static String decToTri(int n) {
		StringBuilder sb = new StringBuilder();
		while (n != 0) {
			sb.append(n % 3);
			n /= 3;
		}
		return sb.reverse().toString();
	}

	public static int TriTodec(String n) {
		int dec = 0;
		for (int i = 0; i < n.length(); i++) {
			dec += Math.pow(3, i) * Integer.parseInt(String.valueOf(n.charAt(i)));
		}
		return dec;
	}
}