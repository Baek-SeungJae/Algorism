package programmers.level1;

public class Programmers_12940 {
	public static void main(String[] args) {
		int n = 3;
		int m = 12;
		System.out.println(solution(n,m)[0]+","+solution(n,m)[1]);
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