package daily;

import java.util.Arrays;

public class O20200531 {

	public static void main(String[] args) {
		//백만개의 정수 배열을 가장 빨리 정렬하세요.
		
		int[] input = new int[] {1,2,4,3,5,6};
		Arrays.sort(input);
		for(int i=0; i<input.length;i++) {
			System.out.print(input[i]+" ");
		}
	}
}
