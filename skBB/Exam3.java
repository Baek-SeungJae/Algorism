package skBB;

import java.util.HashMap;

public class Exam3 {

	public static void main(String[] args) {
		int n = 5;
		int[][] d = new int[][]{{2,4},{3,5},{2,5}};
		int k = 5;
		solution(n,d,k);
	}

	public static int solution(int n, int[][] d, int k)
    {
		int answer = 0;
		int[] cup = new int[n];
		for(int i=0; i<cup.length; i++) {
			cup[i] = i+1;
		}
		for(int i=0; i<d.length; i++) {
			swap(cup,d[i][0]-1,d[i][1]-1);
		}
		for(int i=0; i<cup.length; i++) {
			if(cup[i]==k) {
				answer = i+1;
				break;
			}
		}
       
        return answer;
    }
	public static void swap(int[]p, int a, int b) {
		int temp = p[a];
		p[a] = p[b];
		p[b] = temp;
	}

}
