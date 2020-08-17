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
		/* ë£¨í”„ë¥? ìµœì†Œ 1?šŒ?Š” ?‹¤?–‰?•˜ë¯?ë¡? 0?œ¼ë¡? ì´ˆê¸°?™” */
        int answer = 0;
        
        while(a!=b) {
        	answer ++;
        	/* a?? bë¥? ëª¨ë‘ ì§ìˆ˜ë¡? ë³?ê²½í•˜ê³?, 2ë¡? ?‚˜?ˆ” */
        	a = ifOddReturnEven(a);
            b = ifOddReturnEven(b);
        	a /=2;
        	b /=2;
        	/* a==b?´ë©? ë¦¬í„´?´?‹¤. */
        }

        return answer;
    }
	/* ???ˆ˜ë©? +1, ì§ìˆ˜ë©? ê·¸ë?ë¡? ex) 1->2, 3->4, 6->6 */
	public static int ifOddReturnEven(int n) {
		if(n%2==0) {
			return n;
		} else {
			return n+1;
		}
	}
}
