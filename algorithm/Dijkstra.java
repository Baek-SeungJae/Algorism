package algorithm;
/*
 * 주요내용 : 그래프, 다익스트라, 탐색
 *	작성자 : 백승재  
 */
public class Dijkstra {

	public static void main(String[] args) {

		int vsize = 7;
		int inf = 1000000;
		int[][] graph = graph(vsize);
		put(graph,1,5,5);
		put(graph,1,2,2);
		put(graph,5,4,5);
		put(graph,2,5,1);
		put(graph,2,4,8);
		put(graph,2,3,3);
		put(graph,3,4,1);
		put(graph,4,6,1);
		put(graph,4,7,5);
		put(graph,3,7,4);
		put(graph,6,7,1);
		printGraphToAdjArr(graph);
		
		int[] dist = new int[vsize+1];
		boolean[] visit = new boolean[vsize+1];
		
		for(int i = 1; i <= vsize; i++){
            dist[i] = inf;
        }
		
		ssp(graph, dist, visit, inf, vsize, 1,5);
	}

	// 초기화
	public static int[][] graph(int initSize) {
		int[][] arrGraph;
		arrGraph = new int[initSize + 1][initSize + 1];
		return arrGraph;
	}
	// 양방향 w는 가중치
	public static void put(int[][] arrGraph, int x, int y, int w) {
		arrGraph[x][y] = arrGraph[y][x] = w;
	}
	// 출력
	public static void printGraphToAdjArr(int[][] arrGraph) {
		for (int i = 0; i < arrGraph.length; i++) {
			for (int j = 0; j < arrGraph[i].length; j++) {
				System.out.print(" " + arrGraph[i][j]);
			}
			System.out.println();
		}
	}

	public static void ssp(int[][] graph, int[] dist, boolean[] visit, int inf, int vsize, int start, int end){
		dist[start] = 0;    // 최초 시작 값 distance 초기화
        String s = "";
        for( int j = 0; j < vsize; j++) // dist 값을 한번 초기화 했으므로 n-1번만 진행
        {
            int min = inf+1;    // dist 최소값 찾기 위한 임시 값 초기화
            int index = -1;
            for(int k = 1; k <= vsize; k++){
                if(visit[k] == false && min > dist[k]){
                    min = dist[k];
                    index = k;
                }
            }
            visit[index] = true;
            s += index + " ";  // 경로를 체크하는 방법
            
            for(int l = 1; l <= vsize; l++){
                if(graph[index][l] != 0 && dist[l] > dist[index] + graph[index][l]){ //인접 행렬을 검사하여 최적의 값을 찾아
                        dist[l] = dist[index] + graph[index][l];
                }
                
            }
        }
        
        for(int i = 1; i <= vsize; i++){
            System.out.print(dist[i]);
        }
        System.out.println();
        System.out.println(dist[end]);
        System.out.println(s);  
    }
}
