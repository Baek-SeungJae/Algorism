package programmers.DevMatching2020_3;

import java.util.LinkedList;

public class exam2 {
	static int minCost = 2147483647;
	static int[][] Graph = null;
	static boolean[] visit = null;
	public static void main(String[] args) {
		int n = 6;
		int[][] network = { { 1, 2 }, { 3, 5 }, { 4, 2 }, { 5, 6 } };
		int[][] repair = { { 3, 2, 10 }, { 5, 4, 15 } };
		System.out.println(solution(n, network, repair));
	}
	
	public static int solution(int n, int[][] network, int[][] repair) {
		int nV = n;
		Graph = graph(nV);
		visit = visitArr(nV);

		for (int i = 0; i < network.length; i++) {
			put(Graph, network[i][0], network[i][1]);
		}
		
		LinkedList<int[]> perArr = new LinkedList<int[]>();
		int[] perCheck = new int[repair.length];
		permutation(Graph, nV, repair.length, repair.length,perArr,perCheck,repair,visit);
		
		if(minCost==2147483647) {
			return -1;
		} else {
			return minCost;
		}
	}

	static void permutation(int[][] dfsGraph, int nV, int n, int r, LinkedList<int[]> perArr, int[] perCheck, int[][] repair,
			boolean[] visitArr) {
		dfsGraph = Graph.clone();
		visitArr = visit.clone();
		double cost = 0;
		for (int[] i : perArr) {
			put(dfsGraph, i[0], i[1]);
		}
		dfs(dfsGraph, visitArr, 1, nV);
		System.out.println("테스트");
		if(visitAll(visitArr)) {
			for(int i=0; i< perArr.size(); i++) {
				cost += perArr.get(i)[2];
			}
			if(minCost<cost) {
				return;
			} else {
				minCost = (int)cost;
			}
		}
		if (perArr.size() == r) {
			return;
		}
		for (int i = 0; i < n; i++) {
			if (perCheck[i] == 0) {
				perArr.add(repair[i]);
				perCheck[i] = 1;
				permutation(dfsGraph, nV, n, r, perArr, perCheck, repair, visitArr);
				perCheck[i] = 0;
				perArr.removeLast();
			}
		}
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

	// 정점 방문 여부 확인 배열 초기화
	public static void clearVisitArr(boolean[] visitArr) {
		for (int i = 0; i < visitArr.length; i++) {
			visitArr[i] = false;
		}
	}

	// 그래프 탐색 (재귀호출)
	public static void dfs(int[][] dfsGraph, boolean[] visitArr, int vIdx, int nV) {
		// dfs()에 들어온 vIdx는 방문한 것이므로
		// 방문배열의 해당 index값을 true로 바꿔주고 값을 출력함.
		visitArr[vIdx] = true;
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

	public static boolean visitAll(boolean[] visitArr) {
		boolean visitAll = true;
		for (int i = 1; i < visitArr.length; i++) {
			visitAll = visitAll && visitArr[i];
		}
		return visitAll;
	}
}
