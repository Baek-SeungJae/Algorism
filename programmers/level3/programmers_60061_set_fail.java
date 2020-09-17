package programmers.level3;

import java.util.TreeSet;

public class programmers_60061_set_fail {
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
		System.out.println(solution(n, build_frame));
	}
	public static int N;
	public static int[][] solution(int n, int[][] build_frame) {
		N = n;
		TreeSet<String> set = new TreeSet<>();
		for(int i= 0; i<build_frame.length; i++) {
			build(set,build_frame[i][0],build_frame[i][1],build_frame[i][2],build_frame[i][3]);
		}
		//print(set,n);
		int[][] answer = new int[set.size()][3];
		int count = 0;
		for (String string : set) {
			String[] strToInt = string.split(",");
			answer[count][0] = Integer.parseInt(strToInt[0]);
			answer[count][1] = Integer.parseInt(strToInt[1]);
			answer[count][2] = Integer.parseInt(strToInt[2]);
			count++;
		}
		//System.out.println(set);
		for(int i=0; i<answer.length; i++) {
			System.out.println(answer[i][0]+" "+answer[i][1]+" "+answer[i][2]);
		}
		return answer;
	}
	
	/* a가 0이면 기둥 ,1이면 보*/
	/* b가 0이면 삭제, 1이면 설치 */
	/* 구조물은 기둥은 위로 보는 오른쪽으로만 설치됨 */
	public static void build(TreeSet<String> set, int x, int y, int a, int b) {
		
		if(a==0) { // 기둥일때
			if(b==0) { // 삭제
				/*
				set.remove(x+","+y+","+a);
				boolean isValidAll = true;
				for (String string : set) {
					String[] strToInt = string.split(",");
					isValidAll = isValidAll && isValid(set,Integer.parseInt(strToInt[0]),Integer.parseInt(strToInt[1]),Integer.parseInt(strToInt[2]));
					if(!isValidAll) {
						set.add(x+","+y+","+a);
						break;
					}
				}
				*/
				if(!canDelete(set, x, y, a)) {
					set.add(x+","+y+","+a);
				}
			} else { // 설치
				if(isValid(set, x, y, a))
					set.add(x+","+y+","+a);
			}
			
		} else { //보일 때
			if(b==0) { // 삭제
				/*
				set.remove(x+","+y+","+a);
				boolean isValidAll = true;
				for (String string : set) {
					String[] strToInt = string.split(",");
					isValidAll = isValidAll && isValid(set,Integer.parseInt(strToInt[0]),Integer.parseInt(strToInt[1]),Integer.parseInt(strToInt[2]));
					if(!isValidAll) {
						set.add(x+","+y+","+a);
						break;
					}
				}
				*/
				if(!canDelete(set, x, y, a)) {
					set.add(x+","+y+","+a);
				}
			} else { // 설치
				if(isValid(set, x, y, a))
					set.add(x+","+y+","+a);
			}
		}
	}
	public static boolean isValid(TreeSet<String>set, int x, int y, int a) {
		if(a==0) { // 기둥일 때 
			if(y==0) { // 바닥에 설치할 때 
				return true;
			}
			if (y>0 &&set.contains(x+","+(y-1)+","+0)) { // 바로 밑에 기둥이 있을 때
				return true;
			}
			if (x>0 && set.contains((x-1)+","+y+","+1)) { // 보의 오른쪽 끝에 세울 때
				return true;
			}
			if (set.contains(x+","+y+","+1)) { // 보의 왼쪽 끝에 세울 때
				return true;
			}
				return false;
			
		} else { // 보일 때
			if(y>0 && set.contains(x+","+(y-1)+","+0)) { // 왼쪽 끝 아래에 기둥이 있을 때
				return true;
			}
			if (y>0 && x+1<=N && set.contains((x+1)+","+(y-1)+","+0)) { // 오른쪽 끝 아래에 기둥이 있을 때
				return true;
			}
			if (x>0 && x+1<=N && set.contains((x-1)+","+y+","+1) && set.contains((x+1)+","+y+","+1)) { // 양쪽 끝에 보가 있을 때
				return true;
			}
			return false;
		}
	}
	public static boolean canDelete(TreeSet<String>set, int x, int y, int a) {
		set.remove(x+","+y+","+a);
		if(a==0) { // 기둥일 때 
			if(y+1<=N && set.contains(x+","+(y+1)+","+0)) { // 기둥위에 다른 기둥이 있는지
				if(!isValid(set, x, y+1, a)) {
					return false;
				}
			}
			if(y+1<=N && set.contains(x+","+(y+1)+","+1)) { // 기둥 위에 오른쪽으로 걸쳐있는 보가 있는지
				if(!isValid(set, x, y+1, 1)) {
					return false;
				}
			}
			if(x>0 && y+1<=N && set.contains((x-1)+","+(y+1)+","+1)) { // 기둥 위에 왼쪽으로 걸쳐있는 보가 있는지
				if(!isValid(set, x-1, y+1, 1)) {
					return false;
				}
			}
			return true;
		} else { // 보일 때
			if(x+1<=N && set.contains(x+1+","+y+","+0)) { // 보 오른쪽 끝 위에있는 기둥이 지어지는지
				if(!isValid(set, x+1, y, 0)) {
					return false;
				}
			}
			if(set.contains(x+","+y+","+0)){ // 보 왼쪽 끝 위에있는 기둥이 지어지는지
				if(!isValid(set, x, y, 0)) {
					return false;
				}
			}
			if(x+1<=N && set.contains((x+1)+","+y+","+1)) { //보 오른쪽 끝에 있는 다른 보가 지어지는지
				if(!isValid(set, x+1, y, 1)) {
					return false;
				}
			}
			if(x>0 && set.contains((x-1)+","+y+","+1)) { // 보 왼쪽 끝에 있는 다른 보가 지어지는지  
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