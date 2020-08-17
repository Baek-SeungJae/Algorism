package programmers.level3;

import java.util.HashSet;

public class programmers_42895 {
	static int answer = 9;

	public static void main(String[] args) {
		int N = 4;
		int number = 17;
		System.out.println(solution(N, number));
	}

	public static int solution(int N, int number) {

		dfs(0, 0, N, number);
		
		if (answer == 9) {
			answer = -1;
		}
		System.out.println("dfs -> " + answer );
		
		dp(N,number);
		System.out.println("dp -> " + answer );
		
		return 0;
	}

	public static void dfs(int idx, int current, int N, int destination) {
		if (idx > 8) {
			return;
		}
		if(current>=32000) {
			return;
		}
		if (destination == current) {
			answer = Math.min(answer, idx);
			return;
		}
		int tempNumber = 0;
		for (int i = 0; i < 6; i++) {
			try {
			tempNumber = tempNumber * 10 + N;
			dfs(idx+1 + i, current * tempNumber, N, destination);
			dfs(idx+1 + i, current / tempNumber, N, destination);
			dfs(idx+1 + i, current + tempNumber, N, destination);
			dfs(idx+1 + i, current - tempNumber, N, destination);
			
			}catch(ArithmeticException e) {
				
			}
		}
	}

	public static int dp(int N, int destination) {
		HashSet<Integer> dp[] = new HashSet[9];
		dp[1] = new HashSet<>();
		dp[1].add(N);
		int NN = N;
		for(int i=2; i<9; i++) {
			dp[i] = new HashSet<>();
			dp[i].add(NN*10 + N);
			for(int j = 1; j<i; j++) {
				for (Integer num1 : dp[j]) {
					for (Integer num2 : dp[i-j]) {
						dp[i].add(num1+num2);
						if(num1-num2>0)
							dp[i].add(num1-num2);
						dp[i].add(num1*num2);
						if(num2!=0)
							dp[i].add(num1/num2);
					}
				}
			}
		}
		for(int i=1; i<9; i++) {
			if(dp[i].contains(Integer.valueOf(destination))) {
				answer = i;
				return answer;
			}
		}
		answer = 9;
		return answer;
	}
}
