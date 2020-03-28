package algorithm;

public class DFSMaze {

		
	public static void main(String[] args) {
		int MAZE_SIZE = 7;
		int MIN[] = {MAZE_SIZE * MAZE_SIZE};
		int GOAL_X = 6;
		int GOAL_Y = 5;
		int SEARCH_CNT[] = {0};
		String[][] maze = new String[MAZE_SIZE][MAZE_SIZE];

		// 미로 생성
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				if (i == 0 || i == MAZE_SIZE - 1 || j == 0 || j == MAZE_SIZE - 1)
					maze[i][j] = "■";
				else
					maze[i][j] = "□";
			}
		}
		// 미로에서 이동이 불가능한 좌표 설정
		maze[1][0] = "□";
		maze[5][6] = "□";
		maze[2][1] = "■";
		maze[2][2] = "■";
		maze[2][3] = "■";
		maze[2][4] = "■";
		maze[4][2] = "■";
		maze[4][4] = "■";
		maze[4][5] = "■";

		// 생성된 초기 미로 출력
		System.out.println("[ 초기 생성 미로 ]");
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				System.out.print(maze[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("\n\n\n"+dfsMazeSearch(MAZE_SIZE, maze, MIN, GOAL_X, GOAL_Y, SEARCH_CNT, 1, 0, 1));
		System.out.println();
		System.out.println(SEARCH_CNT[0]);
	}

	// DFS 탐색
	public static int dfsMazeSearch(int MAZE_SIZE, String[][] maze, int[] MIN, int GOAL_X, int GOAL_Y, int[] SEARCH_CNT,
			int y, int x, int l) {

		// 목표 정점에 도착했을 경우
		if (y == GOAL_Y && x == GOAL_X) {

			++SEARCH_CNT[0];
			System.out.println("\n[ " + SEARCH_CNT[0] + "차 미로 탐색 종료 ]\n");

			// 목표 정점에 도착했음을 표시하기 위해 '*'을 값으로 설정
			maze[y][x] = "*";

			for (int i = 0; i < maze.length; i++) {
				for (int j = 0; j < maze[i].length; j++) {
					System.out.print(maze[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();

			// 최단 경로값이 l보다 크면, l이 작은 것이므로 l을 최단 경로값으로 지정
			if (MIN[0] > l) {
				MIN[0] = l;
			}

			// 되돌아갈 경우
			// 방문했던 좌표를 방문가능한 상태로 되돌리기 위해 '□'을 값으로 설정
			maze[y][x] = "□";
			System.out.print("back ");
			return MIN[0];
		}

		// 해당 좌표를 방문했음을 표시하기 위해 '*'을 값으로 설정
		// 배열에서는 y가 세로축, x가 가로축이 되므로 반대로 좌표값을 입력
		maze[y][x] = "*";

		// 미로의 상하좌우 탐색
		// 방문한 좌표값 : '*'
		// 방문 불가능한 좌표값 : '■'
		// 방문 가능한 좌표값 : '□'
		// 해당 좌표로 이동이 가능할 경우, 이동할 좌표를 설정하고 길이를 1 증가시켜 dfsMazeSearch() 호출

		// 위로 이동
		// y축 좌표가 0보다 크고, 이동할 좌표의 값이 '*'과 '■'이 아닌 경우
		if (y > 0 && !maze[y - 1][x].equals("*") && !maze[y - 1][x].equals("■")) {
			System.out.print("↑ up ");
			dfsMazeSearch(MAZE_SIZE, maze, MIN, GOAL_X, GOAL_Y, SEARCH_CNT, y - 1, x, l + 1);
		}
		// 아래로 이동
		// y축 좌표가 미로의 세로 길이보다 작고, 이동할 좌표의 값이 '*'과 '■'이 아닌 경우
		if (y < MAZE_SIZE - 1 && !maze[y + 1][x].equals("*") && !maze[y + 1][x].equals("■")) {
			System.out.print("↓ down ");
			dfsMazeSearch(MAZE_SIZE, maze, MIN, GOAL_X, GOAL_Y, SEARCH_CNT, y + 1, x, l + 1);
		}
		// 왼쪽으로 이동
		// x축 좌표가 0보다 크고, 이동할 좌표의 값이 '*'과 '■'이 아닌 경우
		if (x > 0 && !maze[y][x - 1].equals("*") && !maze[y][x - 1].equals("■")) {
			System.out.print("← left ");
			dfsMazeSearch(MAZE_SIZE, maze, MIN, GOAL_X, GOAL_Y, SEARCH_CNT, y, x - 1, l + 1);
		}
		// 오른쪽으로 이동
		// x축 좌표가 미로의 가로 길이보다 작고, 이동할 좌표의 값이 '*'과 '■'이 아닌 경우
		if (x < MAZE_SIZE - 1 && !maze[y][x + 1].equals("*") && !maze[y][x + 1].equals("■")) {
			System.out.print("→ right ");
			dfsMazeSearch(MAZE_SIZE, maze, MIN, GOAL_X, GOAL_Y, SEARCH_CNT, y, x + 1, l + 1);
		}

		// 되돌아갈 경우
		// 방문했던 좌표를 방문가능한 상태로 되돌리기 위해 '□'을 값으로 설정
		maze[y][x] = "□";
		System.out.print("back ");
		return MIN[0];
	}
}
