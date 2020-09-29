package BOJ;
/*
 * 백준 : 인구이동
 * 링크 : https://www.acmicpc.net/problem/16234
 * 주요내용 : 구현, dfs반복실행
 */
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class BOJ_16234 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int min = sc.nextInt();
		int max = sc.nextInt();
		int[][] map = map(N, sc);
		boolean[][] booleanMap = new boolean[N][N];
		System.out.println(solution(N, min, max, map, booleanMap));
	}

	public static int solution(int N, int min, int max, int[][] map, boolean[][] booleanMap) {
		/* 방문한 지점의 좌표를 저장하기 위한 Set */
		Set<String> set = new HashSet<>();
		int answer = 0;
		
		/* loop를 중지시키기 위한 변수 set의 길이가 0이면 중지임 */
		boolean loopCheck = true;
		while (loopCheck) {
			/* 루프 반복 횟수 증가 , loopCheck 초기화 */
			answer++;
			loopCheck = false;
			
			/* 방문 여부를 저장하는 배열 */
			booleanMap = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!booleanMap[i][j]) {
						/* map에 저장된 숫자가 min이상 max이하면 탐색, 탐색끝나면 set에 좌표 모두 저장 */
						dfs_recursion(map, booleanMap, i, j, min, max, set);
						int count = 0;
						int sum = 0;
						
						/* set 돌면서 평균을 n/m에서 n과 m을 구함 */
						for (String string : set) {
							loopCheck = loopCheck || true;
							count++;
							sum+=map[Integer.parseInt(string.split(",")[0])][Integer.parseInt(string.split(",")[1])];
						}
						/* 구해진 평균값을 map에 저장 */
						for (String string : set) {
							map[Integer.parseInt(string.split(",")[0])][Integer.parseInt(string.split(",")[1])] = sum / count;
						}
						/* set을 지우고 위 과정 반복 */
						set.clear();
					}
				}
			}
		}

		return answer-1;
	}

	public static int[][] map(int N, Scanner sc) {

		int[][] m = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				m[i][j] = sc.nextInt();
			}
		}
		return m;
	}

	public static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static void print(boolean[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static void dfs_recursion(int[][] map, boolean[][] booleanMap, int y, int x, int min, int max,
			Set<String> set) {
		boolean up = y > 0 && Math.abs(map[y][x] - map[y - 1][x]) >= min && Math.abs(map[y][x] - map[y - 1][x]) <= max
				&& booleanMap[y - 1][x] == false;
		boolean down = y < map.length - 1 && Math.abs(map[y][x] - map[y + 1][x]) >= min
				&& Math.abs(map[y][x] - map[y + 1][x]) <= max && booleanMap[y + 1][x] == false;
		boolean right = x < map[y].length - 1 && Math.abs(map[y][x] - map[y][x + 1]) >= min
				&& Math.abs(map[y][x] - map[y][x + 1]) <= max && booleanMap[y][x + 1] == false;
		boolean left = x > 0 && Math.abs(map[y][x] - map[y][x - 1]) >= min && Math.abs(map[y][x] - map[y][x - 1]) <= max
				&& booleanMap[y][x - 1] == false;
		// 위로 이동
		if (up) {
			//System.out.print("↑ ");
			booleanMap[y - 1][x] = true;
			dfs_recursion(map, booleanMap, y - 1, x, min, max, set);
			set.add((y - 1)+","+x);
		}
		// 아래로 이동
		if (down) {
			//System.out.print("↓ ");
			booleanMap[y + 1][x] = true;
			dfs_recursion(map, booleanMap, y + 1, x, min, max, set);
			set.add((y + 1) + ","+ x);
		}
		// 왼쪽으로 이동
		if (left) {
			//System.out.print("← ");
			booleanMap[y][x - 1] = true;
			dfs_recursion(map, booleanMap, y, x - 1, min, max, set);
			set.add(y+","+(x - 1));
		}
		// 오른쪽으로 이동
		if (right) {
			//System.out.print("→ ");
			booleanMap[y][x + 1] = true;
			dfs_recursion(map, booleanMap, y, x + 1, min, max, set);
			set.add(y+","+(x + 1));
		}
		
		// 되돌아갈 경우
		booleanMap[y][x] = true;
	}
}
