package programmers.level3;

import java.util.LinkedList;
import java.util.Queue;

public class programmers_49189 {

	public static void main(String[] args) {
		int n = 6;
		int[][] edge = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };
		System.out.println(solution(n, edge));
	}
	public static int solution(int n, int[][] edge) {
		ArrGraph graph = new ArrGraph(n);
		for (int i = 0; i < edge.length; i++) {
			graph.put(edge[i][0], edge[i][1]);
		}
		//graph.printGraphToAdjArr();
		
		graph.bfs(1);
		
		int answer = graph.getMax();
		return answer;
	}

	static class ArrGraph {
		private int initSize;
		private byte[][] arrGraph;
		private boolean[] visited;
		private int[] count;
		private int max = 0;
		// 그래프 초기화
		public ArrGraph(int initSize) {
			this.initSize = initSize;
			this.arrGraph = new byte[initSize + 1][initSize + 1];
		}

		// 그래프 return
		public byte[][] getGraph() {
			return this.arrGraph;
		}

		// 그래프 추가 (양방향)
		public void put(int x, int y) {
			arrGraph[x][y] = arrGraph[y][x] = 1;
		}

		// 그래프 추가 (단방향)
		public void putSingle(int x, int y) {
			arrGraph[x][y] = 1;
		}

		// 그래프 출력 (인접행렬)
		public void printGraphToAdjArr() {
			for (int i = 0; i < arrGraph.length; i++) {
				for (int j = 0; j < arrGraph[i].length; j++) {
					System.out.print(" " + arrGraph[i][j]);
				}
				System.out.println();
			}
		}

		public void bfs(int start) {
			visited = new boolean[initSize + 1];
			count = new int[initSize+1];
			for(int i=0; i< count.length;i++) {
				count[i] = 0;
			}
			Queue<Integer> q = new LinkedList<Integer>();
			q.offer(start);
			visited[start] = true;
			while (!q.isEmpty()) {
				int temp = q.poll();
				//System.out.print(temp);
				for (int j = 1; j <= initSize; j++) {
					if (arrGraph[temp][j] == 1 && visited[j] == false) {
						count[j] = count[temp]+1;
						//System.out.println(temp + " " + j);
						max = Math.max(count[j], max);
						q.offer(j);
						visited[j] = true; // 큐에 넣을 노드들을 잠재적으로 방문한다는 가정하에 입력
					}
				}
			}
		}
		public int getMax() {
			int counts = 0;
			for(int i=0; i<count.length; i++) {
				if(count[i]==max)
					counts++;
			}
			return counts;
		}
		public void printCount() {
			for(int i=0; i< count.length; i++) {
				System.out.print(count[i]);
			}
			System.out.println();
		}
	}
}
