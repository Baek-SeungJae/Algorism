package programmers;

public class Programmers_12934 {
	public static void main(String[] args) {
		int n = 12;
		int m = 3;
		System.out.println(solution(n,m));
	}

	public static int[] solution(int n, int m) {
        int[] answer = {gcd(n,m),lcm(n,m)};
        return answer;
    }
	public static int gcd(int n, int m) {
		if(m==0) {
			return n;
		}
		return gcd(m,n%m);
	}
	public static int lcm(int n, int m) {
		return n*m/gcd(n,m);
	}
}