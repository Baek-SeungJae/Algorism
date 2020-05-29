package programmers.DevMatching2020_2;

import java.util.ArrayList;
import java.util.TreeSet;

public class e3 {
	public static void main(String[] args) {
		int total_sp = 121;
		int[][] skills = new int[][] { { 1, 2 }, { 1, 3 }, { 3, 6 }, { 3, 4 }, { 3, 5 } };
		System.out.println(solution(total_sp, skills));
	}

	public static int[] solution(int total_sp, int[][] skills) {
		
		int[][] arrGraph = graph(skills.length+1);
		for(int i=0; i<skills.length; i++) {
			putSingle(arrGraph, skills[i][0], skills[i][1], 1);
		}
		printGraphToAdjArr(arrGraph);
		int[] answer = {};
		return answer;
	}
	
	public static int[][] graph(int initSize) {
		int[][] arrGraph;
		arrGraph = new int[initSize + 1][initSize + 1];
		return arrGraph;
	}
	public static void putSingle(int[][] arrGraph, int x, int y, int w) {
		arrGraph[x][y] = 1;
	}
	public static void printGraphToAdjArr(int[][] arrGraph) {
		for (int i = 0; i < arrGraph.length; i++) {
			for (int j = 0; j < arrGraph[i].length; j++) {
				System.out.print(" " + arrGraph[i][j]);
			}
			System.out.println();
		}
	}
}
