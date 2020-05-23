package skBB;

import java.util.Stack;
public class Exam1 {
	
	public static void main(String[] args) {
		int[] deposit = new int[] {500,1000,-200,100,-1000,100-100};
		int[] sol = solution(deposit);
		for(int i=0; i<sol.length;i++) {
			//System.out.println(sol);
		}
	}
    public static int[] solution(int[] deposit) {
		Stack<Integer> s = new Stack<Integer>();

		for (int i = 0; i < deposit.length; i++) {
			s.add(deposit[i]);
			
			while(s.peek()<0) {
				int last = s.pop();
				int secondlast = s.pop();
				int temp = last + secondlast;
				s.add(temp);
			}
			if(s.peek()==0) {
				s.pop();
			}
		}
		int[] answer = new int[s.size()];
		System.out.println(s);
		for(int i=0; i<answer.length;i++) {
			answer[i] = s.pop();
		}
		
		return answer;
    }
}