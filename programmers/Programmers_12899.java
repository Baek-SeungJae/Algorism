package programmers;

public class Programmers_12899 {

	public static void main(String[] args) {
		int n = 2;
		for(int i=10; i<20;i++)
			System.out.println(solution(i));
	}

	public static String solution(int n) {
		StringBuffer sb = new StringBuffer("");

		while (true) {
			int quotient = n / 3;
			int remainder = n % 3;
			n = n / 3;
			
			if(remainder!=0) {
				sb.append(remainder);
			} else {
				n = n-1;
				if(quotient==0 && remainder==0) {
					break;
				}
				sb.append(4);
			}
			
		}

		sb.reverse();
		String answer = sb.toString();
		return answer;
	}
}
