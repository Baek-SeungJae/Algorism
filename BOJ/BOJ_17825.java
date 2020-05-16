package BOJ;

import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_17825 {
	public static void main(String[] args) {

		solution();

	}

	public static int solution() {
		int input[] = new int[] { 1, 2, 3, 4, 1, 2, 3, 4, 1, 2 };
		int[][] map = map();
		
		move(0,input[1],0);
		return 0;
	}
	public static void move(int current, int go, int mapNum) {
		if(mapNum==0&&current==6) {
			mapNum = 1;
			current = go;
		}
		if(mapNum==0&&current==11) {
			mapNum=2;
			current = go;
		}
		if(mapNum==0&&current==16) {
			mapNum=3;
			current=go;
		}
		if(mapNum==0)
		System.out.println("current"+current);
		System.out.println("go" + go);
		System.out.println("mapNum"+mapNum);
	}
	
	
	public static int[][] map(){
		int[][] map = new int[4][];
		map[0] = new int[] {0,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,0};
		map[1] = new int[] {0,13,16,19,25,30,35,40,0};
		map[2] = new int[] {0,22,24,25,30,35,40,0};
		map[3] = new int[] {0,28,27,26,25,30,35,40,0};
		return map;
	}
}
