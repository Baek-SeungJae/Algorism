package programmers.level3;

public class programmers_43162 {

	public static void main(String[] args) {
		int n = 7;
		//int[][] computers =  {{1,1,0},{1,1,0},{0,0,1}};
		int[][] computers =  {{1,1,0,1},{1,1,0,0},{0,0,1,1},{1,0,1,1}};

		System.out.println(solution(n,computers));
	}

	public static int solution(int n, int[][] computers) {
		int count = 0;
		print(computers);
		for(int i=0; i<computers.length; i++) {
			if(computers[i][i]==1) {
				dfs(i,computers);
				print(computers);
				count++;
			}
		}
		//print(computers);
		System.out.println(count);
        int answer = 0;
        return answer;
    }
	public static void dfs(int index, int[][] computers) {
		for(int i = index; i<computers[index].length; i++) {
			if(computers[index][i]==1) {
				computers[index][i] = 0;
				dfs(i,computers);
			}
		}
		for(int i = computers[index].length-1; i>=0; i--) {
			if(computers[index][i]==1) {
				computers[index][i] = 0;
				dfs(i,computers);
			}
		}
	}
	public static void print(int[][] array) {
		for(int i=0; i<array.length;i++) {
			for(int j=0; j< array[0].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}