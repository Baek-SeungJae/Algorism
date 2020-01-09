package programmers;

public class Programmers_12944 {
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4};
		System.out.println(solution(arr));
	}

	public static double solution(int[] arr) {
		int sum =0;
		for(int i=0; i<arr.length; i++) {
			sum+=arr[i];
		}
		double answer = (double)sum/arr.length;
        return answer;
    }
}