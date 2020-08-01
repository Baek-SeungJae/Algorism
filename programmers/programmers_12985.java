package programmers;

public class programmers_12985 {

	public static void main(String[] args) {
		int n = 8;
		int a = 4;
		int b = 7;
		System.out.println(solution(n, a, b));

	}

	public static int solution(int n, int a, int b)
    {
		/* 루프를 최소 1회는 실행하므로 0으로 초기화 */
        int answer = 0;
        
        while(a!=b) {
        	answer ++;
        	/* a와 b를 모두 짝수로 변경하고, 2로 나눔 */
        	a = ifOddReturnEven(a);
            b = ifOddReturnEven(b);
        	a /=2;
        	b /=2;
        	/* a==b이면 리턴이다. */
        }

        return answer;
    }
	/* 홀수면 +1, 짝수면 그대로 ex) 1->2, 3->4, 6->6 */
	public static int ifOddReturnEven(int n) {
		if(n%2==0) {
			return n;
		} else {
			return n+1;
		}
	}
}
