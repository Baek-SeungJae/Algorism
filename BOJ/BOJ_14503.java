package BOJ;
/*
 * 백준 : 로봇청소기
 * 링크 : https://www.acmicpc.net/problem/14503
 * 주요내용 : 구현, 청소기가 더이상 갈 수 있는 방향이 없으면 종료
 */
import java.util.Scanner;

public class BOJ_14503 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 세로
		int M = sc.nextInt(); // 가로
		int r = sc.nextInt(); // 세로
		int c = sc.nextInt(); // 가로
		int d = sc.nextInt(); // 방향 0:북, 1:동 2:남 3:서
		int[][] input = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				input[i][j] = sc.nextInt();
			}
		}
		
		System.out.println(solution(input, N, M, r, c, d));
	}

	public static int solution(int[][] input, int N, int M, int r, int c, int d) {
		int[] dx = new int[] { 0, 1, 0, -1 };
		int[] dy = new int[] { -1, 0, 1, 0 };
		int x = c;
		int y = r;
		int count = 1;
		input[y][x] = 2;
		while (true) {
			boolean check = false;
			for (int i = 0; i < 4; i++) {
				d--;
				if (d < 0) {
					d = 3;
				}
				y += dy[d];
				x += dx[d];
				
				if (input[y][x] == 1 || input[y][x] == 2) {
					y -= dy[d];
					x -= dx[d];
					continue;
				}
				input[y][x] = 2;
				count++;
				check = true;
				break;
			}

			if (!check) {
				y -= dy[d];
				x -= dx[d];
				if (input[y][x] == 1) {
					break;
				}
			}

		}
		return count;
	}

	public static void print(int[][] input) {
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[i].length; j++) {
				System.out.print(input[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

}
