package dataStructure;

public class graph {
	public static void main(String[] args) {
		int[][] arrGraph = graph(6);
		put(arrGraph, 1, 2, 1);
		put(arrGraph, 1, 3, 2);
		put(arrGraph, 2, 3, 1);
		put(arrGraph, 2, 4, 1);
		put(arrGraph, 3, 4, 1);
		put(arrGraph, 3, 5, 1);
		put(arrGraph, 4, 5, 1);
		put(arrGraph, 4, 6, 1);

		printGraphToAdjArr(arrGraph);

	}
	//초기화
	public static int[][] graph(int initSize) {
		int[][] arrGraph;
		arrGraph = new int[initSize + 1][initSize + 1];
		return arrGraph;
	}
	
	//양방향 w는 가중치
	public static void put(int[][] arrGraph, int x, int y, int w) {
		arrGraph[x][y] = arrGraph[y][x] = w;
	}
	
	//단방향
	public static void putSingle(int[][] arrGraph, int x, int y, int w) {
		arrGraph[x][y] = w;
	}

	//출력
	public static void printGraphToAdjArr(int[][] arrGraph) {
		for (int i = 0; i < arrGraph.length; i++) {
			for (int j = 0; j < arrGraph[i].length; j++) {
				System.out.print(" " + arrGraph[i][j]);
			}
			System.out.println();
		}
	}
}
