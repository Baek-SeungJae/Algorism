package programmers.level3;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class programmers_60063_bfs {

	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 1, 1 }, { 0, 0, 0, 1, 0 }, { 0, 1, 0, 1, 1 }, { 1, 1, 0, 0, 1 },
				{ 0, 0, 0, 0, 0 } };
		int[][] board2 = { { 0, 0, 0, 0, 0, 0, 1 }, { 1, 1, 1, 1, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 0 }, { 0, 1, 1, 1, 1, 1, 0 }, { 0, 0, 0, 0, 0, 1, 1 }, { 0, 0, 1, 0, 0, 0, 0 } };
		int[][] board3 = { { 0, 0, 0, 0, 0, 0, 1 }, { 1, 1, 1, 1, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 0 }, { 0, 1, 1, 1, 1, 1, 0 }, { 0, 0, 0, 0, 0, 1, 0 }, { 0, 0, 1, 0, 0, 0, 0 } };
		int[][] board4 = { { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1, 1, 1, 0, 0 }, { 1, 1, 1, 1, 1, 1, 1, 1, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 1, 1, 1, 1, 1, 0, 0 }, { 0, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1, 1, 1, 1, 0 } };
		System.out.println("33 : " + solution(board4));
		System.out.println("21 : " + solution(board2));
		System.out.println("11 : " + solution(board3));
		System.out.println("7 : " + solution(board));
	}

	public static int answer = 10000;

	public static int solution(int[][] board) {
		boolean[][] visited = new boolean[board.length][board[0].length];
		visited[0][0] = true;
		bfs(board, 0, 0, 0, 1, board.length - 1, board[0].length - 1);
		return answer;
	}

	public static void bfs(int[][] board, int Y1, int X1, int Y2, int X2, int Goal_y, int Goal_x) {
		int dir = 0;
		int[] start = { Y1, X1, Y2, X2, dir, 0 };
		
		Queue<int[]> location = new LinkedList<>();

		Set<String> set = new HashSet<>(); 
		set.add(Y1+","+X1+","+Y2+","+X2);
		location.add(start);
		// 우 하 좌 상 우하 하 우상 상
		while (!location.isEmpty()) {
			int[] now = location.poll();
			int y1 = now[0];
			int x1 = now[1];
			int y2 = now[2];
			int x2 = now[3];
			dir = now[4];
			if(dir==0) {
				//print(now[5],board,y1,x1,dir);
				if(y2==board.length-1 && x2== board[0].length-1) {
					answer = now[5];
					return;
				}
				/* 우 */
				if(x2<board[0].length-1&&!set.contains((y1)+","+(x1+1)+","+(y2)+","+(x2+1)) && board[y2][x2+1]==0 ) {
					int[] newLocation = {y1,x1+1,y2,x2+1,0,now[5]+1};
					set.add((y1)+","+(x1+1)+","+(y2)+","+(x2+1));
					location.add(newLocation);
				}
				/* 하 */
				if(y2<board.length-1&&!set.contains((y1+1)+","+(x1)+","+(y2+1)+","+(x2)) && board[y1+1][x1]==0 && board[y2+1][x2]==0 ) {
					int[] newLocation = {y1+1,x1,y2+1,x2,0,now[5]+1};
					set.add((y1+1)+","+(x1)+","+(y2+1)+","+(x2));
					location.add(newLocation);
				}
				/* 좌 */
				if(x1>0 && !set.contains((y1)+","+(x1-1)+","+(y2)+","+(x2-1)) && board[y1][x1-1]==0) {
					int[] newLocation = {y1,x1-1,y2,x2-1,0,now[5]+1};
					set.add((y1)+","+(x1-1)+","+(y2)+","+(x2-1));
					location.add(newLocation);
				}
				/* 상 */
				if(y1>0 && !set.contains((y1-1)+","+(x1)+","+(y2-1)+","+(x2)) && board[y1-1][x1]==0 && board[y2-1][x2]==0 ) {
					int[] newLocation = {y1-1,x1,y2-1,x2,0,now[5]+1};
					set.add((y1-1)+","+(x1)+","+(y2-1)+","+(x2));
					location.add(newLocation);
				}
				/* 1축 아래 */
				if(y1<board.length-1 && !set.contains((y1)+","+(x1)+","+(y2+1)+","+(x2-1)) &&board[y1+1][x1]==0 &&board[y2+1][x2]==0 ) {
					int[] newLocation = {y1,x1,y2+1,x2-1,1,now[5]+1};
					set.add((y1)+","+(x1)+","+(y2+1)+","+(x2-1));
					location.add(newLocation);
				}
				/* 2축 아래 */
				if(y1<board.length-1 && !set.contains((y2)+","+(x2)+","+(y1+1)+","+(x1+1)) &&board[y1+1][x1]==0 &&board[y2+1][x2]==0) {
					int[] newLocation = {y2,x2,y1+1,x1+1,1,now[5]+1};
					set.add((y2)+","+(x2)+","+(y1+1)+","+(x1+1));
					location.add(newLocation);
				}
				/* 1축 위 */
				if(y1>0 && !set.contains((y2-1)+","+(x2-1)+","+(y1)+","+(x1)) &&board[y1-1][x1]==0 &&board[y2-1][x2]==0) {
					int[] newLocation = {y2-1,x2-1,y1,x1,1,now[5]+1};
					set.add((y2-1)+","+(x2-1)+","+(y1)+","+(x1));
					location.add(newLocation);
				}
				/* 2축 위 */
				if(y1>0 && !set.contains((y1-1)+","+(x1+1)+","+(y2)+","+(x2)) &&board[y1-1][x1]==0 &&board[y2-1][x2]==0) {
					int[] newLocation = {y1-1,x1+1,y2,x2,1,now[5]+1};
					set.add((y1-1)+","+(x1+1)+","+(y2)+","+(x2));
					location.add(newLocation);
				}
			} else {
				//print(now[5],board,y1,x1,dir);
				if(y2==board.length-1 && x2== board[0].length-1) {
					answer = now[5];
					return;
				}
				/* 우 */
				if(x1<board[0].length-1 && !set.contains((y1)+","+(x1+1)+","+(y2)+","+(x2+1)) && board[y1][x1+1]==0 && board[y2][x2+1]==0) {
					int[] newLocation = {y1,x1+1,y2,x2+1,1,now[5]+1};
					set.add((y1)+","+(x1+1)+","+(y2)+","+(x2+1));
					location.add(newLocation);
				}
				/* 하 */
				if(y2<board.length-1 && !set.contains((y1+1)+","+(x1)+","+(y2+1)+","+(x2)) && board[y2+1][x2]==0 ) {
					int[] newLocation = {y1+1,x1,y2+1,x2,1,now[5]+1};
					set.add((y1+1)+","+(x1)+","+(y2+1)+","+(x2));
					location.add(newLocation);
				}
				/* 좌 */
				if(x2>0 && !set.contains((y1)+","+(x1-1)+","+(y2)+","+(x2-1)) && board[y1][x1-1]==0 && board[y2][x2-1]==0) {
					int[] newLocation = {y1,x1-1,y2,x2-1,1,now[5]+1};
					set.add((y1)+","+(x1-1)+","+(y2)+","+(x2-1));
					location.add(newLocation);
				}
				/* 상 */
				if(y1>0 && !set.contains((y1-1)+","+(x1)+","+(y2-1)+","+(x2)) && board[y1-1][x1]==0 ) {
					int[] newLocation = {y1-1,x1,y2-1,x2,1,now[5]+1};
					set.add((y1-1)+","+(x1)+","+(y2-1)+","+(x2));
					location.add(newLocation);
				}
				/* 2축 우*/
				if(x2<board[0].length-1 && !set.contains((y2)+","+(x2)+","+(y1+1)+","+(x1+1)) && board[y1][x1+1]==0 && board[y2][x2+1]==0) {
					int[] newLocation = {y2,x2,y1+1,x1+1,0,now[5]+1};
					set.add((y2)+","+(x2)+","+(y1+1)+","+(x1+1));
					location.add(newLocation);
				}
				/* 1축 우*/
				if(x1<board[0].length-1 && !set.contains((y1)+","+(x1)+","+(y2-1)+","+(x2+1)) && board[y1][x1+1]==0 && board[y2][x2+1]==0) {
					int[] newLocation = {y1,x1,y2-1,x2+1,0,now[5]+1};
					set.add((y1)+","+(x1)+","+(y2-1)+","+(x2+1));
					location.add(newLocation);
				}
				/* 2축 좌*/
				if(x2>0 && !set.contains((y1+1)+","+(x1-1)+","+(y2)+","+(x2)) && board[y1][x1-1]==0 && board[y2][x2-1]==0) {
					int[] newLocation = {y1+1,x1-1,y2,x2,0,now[5]+1};
					set.add((y1+1)+","+(x1-1)+","+(y2)+","+(x2));
					location.add(newLocation);
				}
				/* 1축 좌*/
				if(x1>0 && !set.contains((y2-1)+","+(x2-1)+","+(y1)+","+(x1)) && board[y1][x1-1]==0 && board[y2][x2-1]==0) {
					int[] newLocation = {y2-1,x2-1,y1,x1,0,now[5]+1};
					set.add((y2-1)+","+(x2-1)+","+(y1)+","+(x1));
					location.add(newLocation);
				}
			}
			
		}
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