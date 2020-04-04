package hyundaiNGV;

import java.util.HashMap;
import java.util.Scanner;

public class exam02 {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] Np = new int[N];
		int[][] Mp = new int[M][2];
		int first=0;
		int second=0;
		int count=0;
		
		for(int i=0; i<N; i++) {
			Np[i]=sc.nextInt();
			if(Np[i]==0) {
				first = Np[i];
			}
		}
		
		for(int i=0; i<M; i++) {
			Mp[i][0] = sc.nextInt();
			first=Mp[i][0];
			Mp[i][1] = sc.nextInt();
			second=Mp[i][0];
		}
		
		System.out.println(count);
	}
}

