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
		/* λ£¨νλ₯? μ΅μ 1?? ?€??λ―?λ‘? 0?Όλ‘? μ΄κΈ°? */
        int answer = 0;
        
        while(a!=b) {
        	answer ++;
        	/* a?? bλ₯? λͺ¨λ μ§μλ‘? λ³?κ²½νκ³?, 2λ‘? ?? */
        	a = ifOddReturnEven(a);
            b = ifOddReturnEven(b);
        	a /=2;
        	b /=2;
        	/* a==b?΄λ©? λ¦¬ν΄?΄?€. */
        }

        return answer;
    }
	/* ???λ©? +1, μ§μλ©? κ·Έλ?λ‘? ex) 1->2, 3->4, 6->6 */
	public static int ifOddReturnEven(int n) {
		if(n%2==0) {
			return n;
		} else {
			return n+1;
		}
	}
}
