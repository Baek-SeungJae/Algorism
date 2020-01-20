package daily;

public class O20200119 {
	public static void main(String[] args) {
		int input[] = { 1, 2, 3, 4, 5 };
    		int size = input.length;
		int output[] = new int[size];

		int one[] = new int[size];
		int two[] = new int[size];
		one[0] = 1;
		for (int i = 1; i < size; i++) {
			one[i] = one[i-1]* input[i - 1];
		}

		two[size - 1] = 1;
		for (int i = size - 2; i >= 0; i--) {
			 two[i] = two[i+1] * input[i + 1];
		}
      
		for (int i = 0; i < size; i++) {
			output[i] = one[i]* two[i];
		}
		for(int i=0; i<size; i++)
			System.out.println(output[i]);
		}
}
