package programmers.level1;

import java.util.Stack;

public class Programmers_64061 {
	public static void main(String[] args) {
		int[][] board = new int[][] { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 } };
		int[] moves = new int[] { 1, 5, 3, 5, 1, 2, 1, 4 };
		solution(board, moves);

	}

	public static int solution(int[][] board, int[] moves) {
		int answer = 0;
		
		Stack<Integer> st = new Stack<>();
		st.add(0);
		print(board);
		for (int i = 0; i < moves.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[j][moves[i] - 1] == 0) {
				} else {
					if (st.peek() == board[j][moves[i] - 1]) {
						st.pop();
						answer +=2;
						board[j][moves[i] - 1] = 0;
						break;
					} else {
						st.add(board[j][moves[i] - 1]);
						board[j][moves[i] - 1] = 0;
						break;
					}
				}
			}
		}

		System.out.println(answer);
		return answer;
	}

	public static void print(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

	}
}