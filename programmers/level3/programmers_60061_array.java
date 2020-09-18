package programmers.level3;

import java.util.ArrayList;
import java.util.TreeSet;

public class programmers_60061_array {
	/*
	 * x,y 방향에 주의
	 * 
	 * 
	 * */
	public static void main(String[] args) {
		int n = 5;
		int[][] build_frame = { { 1, 0, 0, 1 }, { 1, 1, 1, 1 }, { 2, 1, 0, 1 }, { 2, 2, 1, 1 }, { 5, 0, 0, 1 },{ 5, 1, 0, 1 }, { 4, 2, 1, 1 }, { 3, 2, 1, 1 } };
		//int[][] build_frame ={{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}};
		//int[][] build_frame = {{1,0,0,1}, {1,1,1,1},{1,1,0,1}};
		int[][] answer = solution(n, build_frame);
		for(int i=0; i<answer.length; i++)
			System.out.println(answer[i][0] +"," +answer[i][1]+","+answer[i][2]);
	}
	public static int N;
	public static int[][] solution(int n, int[][] build_frame) {
		N = n;
		boolean[][][] set = new boolean[n+1][n+1][2];
		for(int i= 0; i<build_frame.length; i++) {
			build(set,build_frame[i][0],build_frame[i][1],build_frame[i][2],build_frame[i][3]);
		}
		//print(set,n);
		ArrayList<int[]> arrayList = new ArrayList<>();
		for(int i=0; i< set.length; i++) {
			for(int j=0; j<set[0].length; j++) {
				for(int k=0; k<set[0][0].length;k++) {
					if(set[i][j][k]) {
						int[] temp = {i,j,k};
						arrayList.add(temp);
					}
				}
			}
		}
		int[][] answer = new int[arrayList.size()][3];
		for(int i=0; i<answer.length; i++) {
			answer[i] = arrayList.get(i);
		}
		return answer;
	}
	
	/* a가 0이면 기둥 ,1이면 보*/
	/* b가 0이면 삭제, 1이면 설치 */
	/* 구조물은 기둥은 위로 보는 오른쪽으로만 설치됨 */
	public static void build(boolean[][][] set, int x, int y, int a, int b) {
		
		if(a==0) { // 기둥일때
			if(b==0) { // 삭제
				if(!canDelete(set, x, y, a)) {
					set[x][y][a] = true;
				}
			} else { // 설치
				if(isValid(set, x, y, a))
					set[x][y][a] = true;
			}
			
		} else { //보일 때
			if(b==0) { // 삭제

				if(!canDelete(set, x, y, a)) {
					set[x][y][a] = true;
				}
			} else { // 설치
				if(isValid(set, x, y, a))
					set[x][y][a] = true;
			}
		}
	}
	public static boolean isValid(boolean[][][] set, int x, int y, int a) {
		if(a==0) { // 기둥일 때 
			if(y==0) { // 바닥에 설치할 때 
				return true;
			}
			if (y>0 && set[x][y-1][0]) { // 바로 밑에 기둥이 있을 때
				return true;
			}
			if (x>0 && set[x-1][y][1]) { // 보의 오른쪽 끝에 세울 때
				return true;
			}
			if (set[x][y][1]) { // 보의 왼쪽 끝에 세울 때
				return true;
			}
				return false;
			
		} else { // 보일 때
			if(y>0 && set[x][y-1][0]) { // 왼쪽 끝 아래에 기둥이 있을 때
				return true;
			}
			if (y>0 && x+1<=N && set[x+1][y-1][0]) { // 오른쪽 끝 아래에 기둥이 있을 때
				return true;
			}
			if (x>0 && x+1<=N && set[x-1][y][1] && set[x+1][y][1]) { // 양쪽 끝에 보가 있을 때
				return true;
			}
			return false;
		}
	}
	public static boolean canDelete(boolean[][][] set, int x, int y, int a) {
		set[x][y][a]=false;
		if(a==0) { // 기둥일 때 
			if(y+1<=N && set[x][y+1][0]) { // 기둥위에 다른 기둥이 있는지
				if(!isValid(set, x, y+1, a)) {
					return false;
				}
			}
			if(y+1<=N && set[x][y+1][1]) { // 기둥 위에 오른쪽으로 걸쳐있는 보가 있는지
				if(!isValid(set, x, y+1, 1)) {
					return false;
				}
			}
			if(x>0 && y+1<=N && set[x-1][y+1][1]) { // 기둥 위에 왼쪽으로 걸쳐있는 보가 있는지
				if(!isValid(set, x-1, y+1, 1)) {
					return false;
				}
			}
			return true;
		} else { // 보일 때
			if(x+1<=N && set[x+1][y][0]) { // 보 오른쪽 끝 위에있는 기둥이 지어지는지
				if(!isValid(set, x+1, y, 0)) {
					return false;
				}
			}
			if(set[x][y][0]){ // 보 왼쪽 끝 위에있는 기둥이 지어지는지
				if(!isValid(set, x, y, 0)) {
					return false;
				}
			}
			if(x+1<=N && set[x+1][y][1]) { //보 오른쪽 끝에 있는 다른 보가 지어지는지
				if(!isValid(set, x+1, y, 1)) {
					return false;
				}
			}
			if(x>0 && set[x-1][y][1]) { // 보 왼쪽 끝에 있는 다른 보가 지어지는지  
				if(!isValid(set, x-1, y, 1)){
					return false;
				}
			}
			return true;
		}
	}
	
	public static void print(TreeSet<String>set, int n) {
		int[][] answer = new int[n][n];
		for(int i=answer.length-1; i>=0 ; i--) {
			for(int j=0; j< answer[0].length; j++) {
				answer[i][j] = 8;
			}
		}
		for (String string : set) {
			String[] strToInt = string.split(",");
			answer[Integer.parseInt(strToInt[1])][Integer.parseInt(strToInt[0])] = Integer.parseInt(strToInt[2]);
			
		}
		
		for(int i=answer.length-1; i>=0 ; i--) {
			for(int j=0; j< answer[0].length; j++) {
				if(answer[i][j]==0) {
					System.out.print("| ");
				} else if(answer[i][j]==1) {
					System.out.print("__");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}
}