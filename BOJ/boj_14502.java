package BOJ;
/*
 * 백준 : 연구소
 * 링크 : https://www.acmicpc.net/problem/14502
 * 주요내용 : 조합, dfs
 */
import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_14502 {
	/* 변수선언 단 */
	static int[][] laboratory;
	static int[][] laboratory_copy;
	static int max = 0;
	static ArrayList<int[]> virus_position;
	public static void main(String[] args) {
		/* 초기화 단 */
		laboratory = init();
		laboratory_copy = new int[laboratory.length][laboratory[0].length];
		for (int i = 0; i < laboratory.length; i++) {
			for (int j = 0; j < laboratory[i].length; j++) {
				laboratory_copy[i][j] = laboratory[i][j];
			}
		}
		/* 초기 바이러스 위치잡기 */
		virus_position = new ArrayList<>();
		for (int i = 0; i < laboratory.length; i++) {
			for (int j = 0; j < laboratory[i].length; j++) {
				if(laboratory[i][j]==2) {
					virus_position.add(new int[] {i,j});
				}
			}
		}
		
		solution(laboratory);
	}

	public static void solution(int[][] laboratory) {
		/* 조합찾고 조합안에서 dfs */
		int[] combination = new int[3];
		combination(combination, laboratory.length*laboratory[0].length,3, 0, 0);
		System.out.println(max);
	}

	private static void combination(int[] comArr, int n, int r, int index, int target) {
		/* 조합 안에서 벽이 세개 세워졌는지 체크하고 세개가 세워졌으면 dfs시작함, 여기서 call_by_ref문제 때문에 copy를 복사함 */
		/* 조합 함수 자체는 구글링 */
        if(r==0){
        	boolean check_loop_all = true;
            for(int i : comArr){
                check_loop_all = check_loop_all && (laboratory_copy[i/laboratory[0].length][i%laboratory_copy[0].length]==0);
            }
            print(laboratory_copy);
            System.out.println();
            if(check_loop_all) {
            	for(int i : comArr){
            		laboratory_copy[i/laboratory_copy[0].length][i%laboratory_copy[0].length]=1;
                }
            	for(int i=0; i<virus_position.size();i++) {
            		dfs_recursion_virus(laboratory_copy, virus_position.get(i)[0], virus_position.get(i)[1]);
            	}
            	max = Math.max(max, countZero(laboratory_copy));
            	for (int i = 0; i < laboratory.length; i++) {
        			for (int j = 0; j < laboratory[i].length; j++) {
        				laboratory_copy[i][j] = laboratory[i][j];
        			}
        		}
            }
            
            return;
        }
        if(target == n)
        	return;
        comArr[index] = target;
        combination(comArr, n, r-1, index+1, target+1);//뽑는경우
        combination(comArr, n, r, index, target+1);//안뽑는경우
    }

	public static void dfs_recursion_virus(int[][] laboratory, int y, int x) {
		boolean up = y > 0 && laboratory[y - 1][x] != 1 && laboratory[y - 1][x] != 2;
		boolean down = y < laboratory.length - 1 && laboratory[y + 1][x] != 1 && laboratory[y + 1][x] != 2;
		boolean right = x < laboratory[y].length - 1 && laboratory[y][x + 1] != 1 && laboratory[y][x + 1] != 2;
		boolean left = x > 0 && laboratory[y][x - 1] != 1 && laboratory[y][x - 1] != 2;
		// 위로 이동
		if (up) {
			//System.out.print("↑ ");
			laboratory[y - 1][x] = 2;
			dfs_recursion_virus(laboratory, y - 1, x);
		}
		// 아래로 이동
		if (down) {
			//System.out.print("↓ ");
			laboratory[y + 1][x] = 2;
			dfs_recursion_virus(laboratory, y + 1, x);
		}
		// 왼쪽으로 이동
		if (left) {
			//System.out.print("← ");
			laboratory[y][x - 1] = 2;
			dfs_recursion_virus(laboratory, y, x - 1);
		}
		// 오른쪽으로 이동
		if (right) {
			//System.out.print("→ ");
			laboratory[y][x + 1] = 2;
			dfs_recursion_virus(laboratory, y, x + 1);
		}
		// 되돌아갈 경우
		laboratory[y][x] = 2;
	}

	public static int[][] init() {
		/* 초기화함수 모듈화 */
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] laboratory = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				laboratory[i][j] = sc.nextInt();
			}
		}
		return laboratory;
	}
	/* 중간점검을 위한 print 함수 */
	public static void print(int[][] laboratory) {
		for (int i = 0; i < laboratory.length; i++) {
			for (int j = 0; j < laboratory[i].length; j++) {
				System.out.print(laboratory[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	/* 연구소안에 안전공간이 몇칸인지 카운트 */
	public static int countZero(int[][] laboratory) {
		int count = 0;
		for (int i = 0; i < laboratory.length; i++) {
			for (int j = 0; j < laboratory[i].length; j++) {
				if (laboratory[i][j] == 0) {
					count++;
				}
			}
		}
		return count;
	}
}
