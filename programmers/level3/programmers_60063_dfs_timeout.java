package programmers.level3;

class programmers_60063_dfs_timeout {

	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 1, 1 }, { 0, 0, 0, 1, 0 }, { 0, 1, 0, 1, 1 }, { 1, 1, 0, 0, 1 },
				{ 0, 0, 0, 0, 0 } };
		int[][] board2 = {{0, 0, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 0}, {0, 1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 1, 1}, {0, 0, 1, 0, 0, 0, 0}};
		int[][] board3 = {{0, 0, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 0, 0}, {0, 1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 1, 0}, {0, 0, 1, 0, 0, 0, 0}};
		int[][] board4 = {{0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 1, 0, 0}, {0, 1, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 1, 1, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 0}};
		System.out.println("33 : "+solution(board4));
		System.out.println("21 : "+solution(board2));
		System.out.println("11 : "+solution(board3));
		System.out.println("7 : "+solution(board));
	}

	public static int answer = 10000;

	public static int solution(int[][] board) {
		boolean[][] visited = new boolean[board.length][board[0].length];
		visited[0][0] = true;

		dfs_recursion(0, board, visited, 0, 0, 0);

		return answer;
	}

	public static void dfs_recursion(int idx, int[][] board, boolean[][] VISITED, int y, int x, int dir) {
		if (idx >= answer) {
			return;
		}
		if (y == board.length - 1 && x + 1 == board[0].length - 1 && dir == 0) {
			answer = Math.min(answer, idx);
			return;
        }
		if (y + 1 == board.length - 1 && x == board[0].length - 1 && dir == 1) {
			answer = Math.min(answer, idx);
			return;
        }
		
		boolean[][] visited = VISITED.clone();
		for (int i = 0; i < visited.length; i++) {
			visited[i] = VISITED[i].clone();
		}

		// print(visited);
		//print(idx, board, y, x, dir);
		switch (dir) {
		case 0:
			if (x < board[0].length - 2 && !VISITED[y][x + 2] && board[y][x + 2] == 0) {
				visited[y][x + 1] = true;
				dfs_recursion(idx + 1, board, visited, y, x + 1, 0); // 우
			}
			
			if (y < board.length - 1 && !VISITED[y + 1][x] && board[y + 1][x] == 0 && board[y + 1][x + 1] == 0) {
				visited[y + 1][x] = true;
				dfs_recursion(idx + 1, board, visited, y + 1, x, 0); // 하
			}
			if (x > 0 && !VISITED[y][x - 1] && board[y][x - 1] == 0) {
				visited[y][x - 1] = true;
				dfs_recursion(idx + 1, board, visited, y, x - 1, 0); // 좌
			}
			if (y > 0 && !VISITED[y - 1][x] && board[y - 1][x] == 0 && board[y - 1][x + 1] == 0) {
				visited[y - 1][x] = true;
				dfs_recursion(idx + 1, board, visited, y - 1, x, 0); // 상
			}
			
			if (y < board.length - 1 && !VISITED[y + 1][x + 1] && board[y + 1][x] == 0 && board[y + 1][x + 1] == 0) {
				visited[y][x + 1] = true;
				dfs_recursion(idx + 1, board, visited, y, x + 1, 1); // 축이 아래로
			}
			if (y < board.length - 1 && !VISITED[y + 1][x] && board[y + 1][x] == 0 && board[y + 1][x + 1] == 0) {
				visited[y][x + 1] = true;
				dfs_recursion(idx + 1, board, visited, y, x, 1); // 축기준 아래로
			}
			if (y > 0 && !VISITED[y - 1][x] && board[y - 1][x] == 0 && board[y - 1][x + 1] == 0) {
				visited[y - 1][x] = true;
				dfs_recursion(idx + 1, board, visited, y - 1, x, 1); // 축기준 위로
			}
			
			if (y > 0 && !VISITED[y - 1][x + 1] && board[y - 1][x] == 0 && board[y - 1][x + 1] == 0) {
				visited[y - 1][x + 1] = true;
				dfs_recursion(idx + 1, board, visited, y - 1, x + 1, 1); // 축이 위로
			}
			break;
		case 1:
			if (x < board[0].length - 1 && !VISITED[y][x + 1] && board[y][x + 1] == 0 && board[y + 1][x + 1] == 0) {
				visited[y][x + 1] = true;
				dfs_recursion(idx + 1, board, visited, y, x + 1, 1); // 우
			}
			
			if (y < board.length - 2 && !VISITED[y + 2][x] && board[y + 2][x] == 0) {
				visited[y + 1][x] = true;
				dfs_recursion(idx + 1, board, visited, y + 1, x, 1); // 하
			}
			if (x > 0 && !VISITED[y][x - 1] && board[y][x - 1] == 0 && board[y + 1][x - 1] == 0) {
				visited[y][x - 1] = true;
				dfs_recursion(idx + 1, board, visited, y, x - 1, 1); // 좌
			}
			if (y > 0 && !VISITED[y - 1][x] && board[y - 1][x] == 0) {
				visited[y - 1][x] = true;
				dfs_recursion(idx + 1, board, visited, y - 1, x, 1); // 상
			}
			
			if (x < board[0].length - 1 && !VISITED[y + 1][x + 1] && board[y][x + 1] == 0 && board[y + 1][x + 1] == 0) {
				visited[y + 1][x] = true;
				dfs_recursion(idx + 1, board, visited, y + 1, x, 0); // 축이 우로
			}
			if (x < board[0].length - 1 && !VISITED[y][x + 1] && board[y][x + 1] == 0 && board[y + 1][x + 1] == 0) {
				visited[y][x] = true;
				dfs_recursion(idx + 1, board, visited, y, x, 0); // 축기준 우로
			}
			if (x > 0 && !VISITED[y + 1][x - 1] && board[y][x - 1] == 0 && board[y + 1][x - 1] == 0) {
				visited[y + 1][x - 1] = true;
				dfs_recursion(idx + 1, board, visited, y + 1, x - 1, 0); // 축이 좌로
			}
			if (x > 0 && !VISITED[y][x - 1] && board[y][x - 1] == 0 && board[y + 1][x - 1] == 0) {
				visited[y][x - 1] = true;
				dfs_recursion(idx + 1, board, visited, y, x - 1, 0); // 축기준 좌로
			}
			break;
		}
		VISITED[y][x] = true;
	}

	public static void print(int idx, int[][] board, int Y1, int X1, int dir) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				switch (dir) {
				case 0:
					if (i == Y1 && j == X1) {
						System.out.print("* ");
					} else if (i == Y1 && j == X1 + 1) {
						System.out.print("* ");
					} else {
						System.out.print(board[i][j] + " ");
					}
					break;
				case 1:
					if (i == Y1 && j == X1) {
						System.out.print("* ");
					} else if (i == Y1 + 1 && j == X1) {
						System.out.print("* ");
					} else {
						System.out.print(board[i][j] + " ");
					}
				}

			}
			System.out.println();
		}
		System.out.println(idx);
	}

	public static void print(boolean[][] visited) {
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited[i].length; j++) {
				if (visited[i][j]) {
					System.out.print("t ");
				} else {
					System.out.print("f ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
}