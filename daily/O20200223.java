package daily;

import java.util.LinkedList;
import java.util.Queue;

public class O20200223 {
	static int count = 0;

	public static void main(String[] args) {
		int[][] input = { { 1, 0, 0, 1, 1, 0 }, { 1, 0, 0, 1, 0, 0 }, { 1, 1, 1, 1, 0, 0 }, { 1, 0, 0, 0, 0, 1 },
				{ 1, 1, 1, 1, 1, 1 } };

		int start[] = { 0, 0 };
		int finish[] = { 0, 4 };
		solution(input, start, finish);
	}

	public static int solution(int[][] input, int[] start, int[] finish) {
		int[] MIN = { input.length * input[0].length };
		System.out.println(dfs(input, start[0], start[1], finish[0], finish[1], MIN, 0));
		System.out.println(bfs(input,start[0],start[1],finish[0],finish[1],MIN));
		System.out.println(count);
		int answer = 0;
		return answer;
	}

	public static int dfs(int[][] input, int x, int y, int Goal_x, int Goal_y, int[] MIN, int l) {

		if (x == Goal_x && y == Goal_y) {
			input[x][y] = 8;
			if (MIN[0] > l) {
				MIN[0] = l;
			}
			input[x][y] = 1;
			return MIN[0];
		}

		input[x][y] = 8;
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, -1, 0, 1 };
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < input.length && ny >= 0 && ny < input[0].length) {
				if (!(input[nx][ny] == 8) && !(input[nx][ny] == 0)) {
					dfs(input, nx, ny, Goal_x, Goal_y, MIN, l + 1);
				}
			}
		}
		input[x][y] = 1;
		return MIN[0];
	}

	public static int bfs(int[][] input, int x, int y, int Goal_x, int Goal_y, int[] MIN) {
		int answer = 0;
		int[] start = { x, y, 0 };
		int[] end = { Goal_x, Goal_y, 0 };
		Queue<int[]> location = new LinkedList<int[]>();
		boolean[][] visit = new boolean[input.length][input[0].length];
		visit[x][y] = true;

		location.add(start);
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, -1, 0, 1 };

		while (!location.isEmpty()) {

			int[] now = location.element();
			location.remove();

			for (int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				if (nx >= 0 && ny >= 0 && nx < input.length && ny < input[0].length) {
					if (input[nx][ny] == 1 && visit[nx][ny] == false) {
						if (nx == end[0] && ny == end[1]) { // 도착
							visit[nx][ny] = true;
							answer = now[2] + 1;
							count++;
							//break;
						}
						int[] newLocation = { nx, ny, now[2] + 1 };
						location.add(newLocation);
						visit[nx][ny] = true;
						count++;
					}
				}
			}
			//if(answer != 0)
	        //    break;
		}
		//만약 전체 1의 개수를 체크해야 한다면 break 관련 문을 지우면 된다.
		return answer;
	}

	public static void print(int[][] input) {
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[i].length; j++) {
				System.out.print(input[i][j] + " ");
			}
			System.out.println();
		}
	}
}