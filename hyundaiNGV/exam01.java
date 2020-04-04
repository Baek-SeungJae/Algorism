package hyundaiNGV;
public class exam01 {

	public void solve(int n, int k, String problem) {
		int N = n;
		int K = k;
		String str = problem;
		int size = N-K+1;
		long max=0;
		long temp = 0;
		for(int i=0; i<size; i++) {
			temp = Long.parseLong(str.substring(i, i+K));
			if(temp>max)
				max = temp;
		}
		System.out.println(max);
	}
}
