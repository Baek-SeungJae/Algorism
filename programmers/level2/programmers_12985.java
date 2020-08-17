package programmers.level2;

public class programmers_12985 {

	public static void main(String[] args) {
		int n = 8;
		int a = 4;
		int b = 7;
		System.out.println(solution(n, a, b));

	}

	public static int solution(int n, int a, int b)
    {
		/* 루프�? 최소 1?��?�� ?��?��?���?�? 0?���? 초기?�� */
        int answer = 0;
        
        while(a!=b) {
        	answer ++;
        	/* a?? b�? 모두 짝수�? �?경하�?, 2�? ?��?�� */
        	a = ifOddReturnEven(a);
            b = ifOddReturnEven(b);
        	a /=2;
        	b /=2;
        	/* a==b?���? 리턴?��?��. */
        }

        return answer;
    }
	/* ???���? +1, 짝수�? 그�?�? ex) 1->2, 3->4, 6->6 */
	public static int ifOddReturnEven(int n) {
		if(n%2==0) {
			return n;
		} else {
			return n+1;
		}
	}
}
