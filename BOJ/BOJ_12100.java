package BOJ;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/*
 * 백준 : 2048
 * 링크 : https://www.acmicpc.net/problem/12100
 */
public class BOJ_12100 {
	public static void main(String[] args) {
		System.out.println(solution());
	}

	public static int solution() {
		Game game = new Game();
		game.getData();

		// 손테스트용
		inputTestCase(game);

		int r = 5; // 5개를 뽑음
		int n = 4; // 4가지 중에서
		LinkedList<Integer> rePerArr = new LinkedList<Integer>();
		rePermutation(game, n, r, rePerArr);

		return game.getMaxValue();
	}

	private static int inputTestCase(Game game) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			switch (sc.nextInt()) {
				case 4:
					game.getCommand("keyLeft");
					game.print();
					break;
				case 8:
					game.getCommand("keyUp");
					game.print();
					break;
				case 6:
					game.getCommand("keyRight");
					game.print();
					break;
				case 2:
					game.getCommand("keyDown");
					game.print();
					break;
				case 0:
					return game.getMaxValue();
			}
		}
	}

	private static void rePermutation(Game game, int n, int r, LinkedList<Integer> rePerArr) {
		if (rePerArr.size() == r) {
			for (int i : rePerArr) {
				switch (i) {
					case 0:
						game.getCommand("keyUp");
						break;
					case 1:
						game.getCommand("keyDown");
						break;
					case 2:
						game.getCommand("keyLeft");
						break;
					case 3:
						game.getCommand("keyRight");
						break;
				}
			}
			game.reset();
			return;
		}

		for (int i = 0; i < n; i++) {
			rePerArr.add(i);
			rePermutation(game, n, r, rePerArr);
			rePerArr.removeLast();
		}
	}

	static class Game {
		private int[][] boardOriginal;
		private int[][] board;
		private int size;
		private int maxValue;

		public void getData() {
			Scanner sc = new Scanner(System.in);
			size = sc.nextInt();
			board = new int[size][size];
			boardOriginal = new int[size][size];
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					board[i][j] = sc.nextInt();
					boardOriginal[i][j] = board[i][j];
				}
			}
		}

		public int getMaxValue() {
			return maxValue;
		}

		public void reset() {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					board[i][j] = boardOriginal[i][j];
				}
			}
		}

		public void print() {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}
		}

		private void addInDeque(int i, int j, Deque<Integer> deque, Deque<Boolean> isUsed) {
			if (deque.isEmpty() == false) {
				if (deque.peekLast() == board[i][j] && isUsed.peekLast() == false) {
					int poll = deque.pollLast() + board[i][j];
					isUsed.pollLast();
					deque.addLast(poll);
					isUsed.addLast(true);
				} else {
					if (board[i][j] != 0) {
						deque.addLast(board[i][j]);
						isUsed.addLast(false);
					}
				}
			} else {
				if (board[i][j] != 0) {
					deque.addLast(board[i][j]);
					isUsed.addLast(false);
				}
			}
			maxValue = Math.max(maxValue, board[i][j]);
		}

		private void pollInDeque(int i, int j, Deque<Integer> deque) {

			if (deque.isEmpty() == false) {
				int poll = deque.pollFirst();
				board[i][j] = poll;
			} else {
				board[i][j] = 0;
			}
			maxValue = Math.max(maxValue, board[i][j]);
		}

		private void getCommand(String command) {
			for (int j = 0; j < size; j++) {
				Deque<Integer> deque = new LinkedList<>();
				Deque<Boolean> isUsed = new LinkedList<>();
				switch (command) {
					case "keyUp":
						for (int i = 0; i < size; i++) {
							addInDeque(i, j, deque, isUsed);
						}
						for (int i = 0; i < size; i++) {
							pollInDeque(i, j, deque);
						}
						break;
					case "keyDown":
						for (int i = size - 1; i >= 0; i--) {
							addInDeque(i, j, deque, isUsed);
						}
						for (int i = size - 1; i >= 0; i--) {
							pollInDeque(i, j, deque);
						}
						break;
					case "keyLeft":
						for (int i = 0; i < size; i++) {
							addInDeque(j, i, deque, isUsed);
						}
						for (int i = 0; i < size; i++) {
							pollInDeque(j, i, deque);
						}
						break;
					case "keyRight":
						for (int i = size - 1; i >= 0; i--) {
							addInDeque(j, i, deque, isUsed);
						}
						for (int i = size - 1; i >= 0; i--) {
							pollInDeque(j, i, deque);
						}
						break;
				}
			}
		}
	}
}
