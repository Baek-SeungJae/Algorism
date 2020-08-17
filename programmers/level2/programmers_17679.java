package programmers.level2;

import java.util.Stack;

public class programmers_17679 {

	public static void main(String[] args) {
		int m = 6;
		int n = 6;
		//String[] board = { "AA", "AA","AA" };
		//String[] board = { "ABCDE", "ABCDE", "ABCDE", "ABCDE" };
		String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF","TMMTTJ"};
		System.out.println(solution(m, n, board));

	}

	// A,C,F,J,M,N,T,R
	public static int solution(int m, int n, String[] board) {
		/* ë°°ì—´ ì´ˆê¸°?™” */
		char[][] table = new char[m][n];
		for (int i = 0; i < m; i++) {
			table[i] = board[i].toCharArray();
		}

		/* ?ƒ?ƒœë¥? ???ž¥?•  temp ë°°ì—´ ë³µì‚¬ */
		char[][] table_copy = copy_table(table);
		
		/* ê¹¨íŠ¸ë¦? ë¸”ë¡?„ table?—?„œ ì°¾ì•„?„œ table_copy?— ë³µì‚¬ */
		find_block(table, table_copy);
		
		while (change_anymore(table, table_copy)) {
			/* Xë¥? ìµœìƒ?‹¨?œ¼ë¡? ëº? */
			sort(table_copy);
			/* ë°°ì—´?„ ?‹¤?‹œ ë³µì‚¬ */
			table = copy_table(table_copy);
			/* ê¹¨íŠ¸ë¦? ë¸”ë¡?„ table?—?„œ ì°¾ì•„?„œ table_copy?— ë³µì‚¬ */
			find_block(table, table_copy);
		}
		
		/* ìµœì¢…?™•?¸?„ ?œ„?•œ print */
		//print(table_copy);
		int answer = count(table_copy);
		return answer;
	}

	/* ?‚¬ê°í˜• ì°¾ì•„?„œ x?‘œ?‹œ */
	public static void find_block(char[][] table, char[][] table_copy) {
		for (int i = 0; i < table.length - 1; i++) {
			for (int j = 0; j < table[i].length - 1; j++) {
				if (table[i][j] == table[i][j + 1] && table[i][j] == table[i + 1][j]
						&& table[i][j] == table[i + 1][j + 1]) {
					table_copy[i][j] = table_copy[i + 1][j] = table_copy[i][j + 1] = table_copy[i + 1][j + 1] = '*';
				}
			}
		}
	}

	/* ì¤‘ê°„ ì²´í¬ë¥? ?œ„?•œ print */
	public static void print(char[][] table) {
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
				System.out.print(table[i][j]);
			}
			System.out.println();
		}
	}

	/* ?” ?´?ƒ ?„°?Š¸ë¦? ë¸”ë¡?´ ?—†?Š”ì§? ?™•?¸ */
	public static boolean change_anymore(char[][] table, char[][] table_copy) {
		boolean answer = false;
		for (int i = 0; i < table.length - 1; i++) {
			for (int j = 0; j < table[i].length - 1; j++) {
				if (table[i][j] != table_copy[i][j]) {
					return true;
				}
			}
		}
		return answer;
	}

	/* ë°°ì—´ ë³µì‚¬ */
	public static char[][] copy_table(char[][] table) {
		char[][] table_copy = table.clone();
		for (int i = 0; i < table.length; i++) {
			table_copy[i] = table[i].clone();
		}
		return table_copy;
	}

	/* Xë¥? ì¹´ìš´?Š¸ - ? •?‹µì°¾ê¸° */
	public static int count(char[][] table) {
		int answer = 0;
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
				if (table[i][j] == '*') {
					answer++;
				}
			}
		}
		return answer;
	}

	/* Xë¥? ?œ„ë¡? ë°?ê¸? */
	public static void sort(char[][] table) {
		Stack<Character> stack = new Stack<Character>();
		for (int j = 0; j < table[0].length; j++) {
			for (int i = 0; i < table.length; i++) {
				if (table[i][j] != '*') {
					stack.add(table[i][j]);
				}
			}
			for (int k = table.length - 1; k >= 0; k--) {
				if (!stack.isEmpty()) {
					table[k][j] = stack.pop();
				} else {
					table[k][j] = '*';
				}

			}
		}
	}
}
