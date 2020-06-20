package programmers;

import java.util.Arrays;

public class Programmers_12982 {
	public static void main(String[] args) {
		int[] d = new int[] {2,2,3,3};
		int budget = 10;

		solution(d, budget);

	}

	public static int solution(int[] d, int budget) {
        int answer = 0;
        
        Arrays.sort(d);
        int index=0;
        while(true) {
        	answer += d[index];
        	
        	if(answer>budget)
        		break;
        	index++;
        	if(index>=d.length)
        		break;
        }
        System.out.println(index);
        return index;
    }
}