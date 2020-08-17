package programmers.DevMatching2020_1;

public class Exam02 {

	public static void main(String[] args) {
		int[][] office = { { 5, -1, 4 }, { 6, 3, -1 }, { 2, -1, 1 } };
		int r = 1;
		int c = 0;
		String[] move = { "go", "go", "right", "go", "right", "go", "left", "go" };
		System.out.println(solution(office, r, c, move));
	}

	public static int solution(int[][] office, int r, int c, String[] move) {
		int y = r;
		int x = c;
		int N = office.length;
		int d = 0; // 0북, 1서, 2남, 3동
		int count = 0;
		count += office[y][x];
		office[y][x] = 0;
		String command = "";
		int[] dy = new int[] { -1, 0, 1, 0 };
		int[] dx = new int[] { 0, -1, 0, 1 };
		for (int i = 0; i < move.length; i++) {
			command = move[i];
			if (command.equals("right")) {
				d = d - 1;
				if (d < 0)
					d = 3;
			} else if (command.equals("left")) {
				d = d + 1;
				if (d > 3) {
					d = 0;
				}
			} else if (command.equals("go")) {
				y += dy[d];
				x += dx[d];
				if (x < 0 || x > N - 1 || y < 0 || y > N - 1 || office[y][x] == -1) {
					y -= dy[d];
					x -= dx[d];
				}
				count += office[y][x];
				office[y][x] = 0;
			}
		}
		int answer = count;
		return answer;
	}
}