package kakaoTest_2019;

import java.util.Stack;

public class Exam02 {

	public static void main(String[] args) {
		int[][] input = {
				{0,0,0,0,0},
				{0,0,1,0,3},
				{0,2,5,0,1},
				{4,2,4,4,2},
				{3,5,1,3,1}
				};
		int[] moves = {1,5,3,5,1,2,1,4};
		solution(input,moves);
	}

	public static int solution(int[][] board, int[] moves) {
		Stack<Integer> st = new Stack<Integer>();
		st.add(0);
		int count = 0;
		int movesize = moves.length;
		int boardsize = board.length;
		String str="";
		
		for(int i=0; i<movesize; i++) {
			for(int j=0; j<boardsize; j++) {
				if(board[j][moves[i]-1]==0) {
					
				} else {
					if(st.peek()!=board[j][moves[i]-1]) {
						st.add(board[j][moves[i]-1]);
						board[j][moves[i]-1]=0;
						break;
					} else {
						count +=2;
						st.pop();
						board[j][moves[i]-1]=0;
						break;
					}
				}
			}
		}
		System.out.println(count);
		return count;
	}
}
