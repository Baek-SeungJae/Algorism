package daily;

public class O20200510 {

	public static void main(String[] args) {
		int arr[] = new int[] {1,3,4,5};
		solution(arr);
	}
	public static int solution(int[] arr) {
		int answer = 1;
		
		for (int i = 0; i < arr.length && arr[i] <= answer; i++) 
			answer = answer + arr[i]; 
		
		System.out.println(answer);
		return answer;
	}
}
