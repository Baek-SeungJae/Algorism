package algorithm;

public class DFS {

	public static void main(String[] args) {
		int nV = 8;
		int[][] dfsGraph = graph(nV);
		boolean[] visitArr = visitArr(nV);
		
		put(dfsGraph, 1, 2);
		put(dfsGraph, 1, 3);
		put(dfsGraph, 2, 4);
		put(dfsGraph, 2, 5);
		put(dfsGraph, 4, 8);
		put(dfsGraph, 5, 8);
		put(dfsGraph, 6, 8);
		put(dfsGraph, 7, 8);
		printGraphToAdjArr(dfsGraph);
		dfs(dfsGraph,visitArr,6,nV);
	}

	// 그래프 초기화
	public static int[][] graph(int nV) {
		int[][] dfsgraph = new int[nV + 1][nV + 1];
		return dfsgraph;
	}

	// 방문여부 초기화
	public static boolean[] visitArr(int nV) {
		boolean[] visitArr = new boolean[nV + 1];
		return visitArr;
	}

	// 그래프 추가
	public static void put(int[][] dfsGraph, int x, int y) {
		// 정점 x와 y가 연결되어있음을 의미
		dfsGraph[x][y] = dfsGraph[y][x] = 1;
	}

	// 그래프 출력 (인접행렬)
	public static void printGraphToAdjArr(int[][] dfsGraph) {
		for (int i = 0; i < dfsGraph.length; i++) {
			for (int j = 0; j < dfsGraph[i].length; j++) {
				System.out.print(" " + dfsGraph[i][j]);
			}
			System.out.println();
		}
	}

	// 정점 방문 여부 확인 배열 초기화
	public static void clearVisitArr(boolean[] visitArr) {
		for (int i = 0; i < visitArr.length; i++) {
			visitArr[i] = false;
		}
	}
	public static void order(boolean[] orderArr) {
		
	}
	// 그래프 탐색 (재귀호출)
	public static void dfs(int[][] dfsGraph, boolean[] visitArr, int vIdx, int nV) {
		// dfs()에 들어온 vIdx는 방문한 것이므로
		// 방문배열의 해당 index값을 true로 바꿔주고 값을 출력함.
		visitArr[vIdx] = true;
		System.out.print(vIdx + " ");

		// 인접 행렬로 구현된 그래프에서
		// 정점의 개수(nV) 만큼 탐색
		for (int i = 1; i <= nV; i++) {
			// dfsGraph[][]의 해당 정점이 연결되어있는 것으로 표시되어 있으나 (연결은 1로 표시)
			// 방문 배열에서 방문하지 않은 상태(false)인 경우
			if (dfsGraph[vIdx][i] == 1 && visitArr[i] == false) {
				dfs(dfsGraph, visitArr, i, nV); // dfs() 재귀호출
			}
		}
	}

}
